package com.yjr.springboottest.controller;

import com.yjr.springboottest.util.TimeUtil;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@RequestMapping("/reactive")
@RestController
public class ReactiveController {

    @GetMapping(value = "/emitter", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter sseChat(){
        SseEmitter emitter = new SseEmitter();

        // 创建一个定时任务
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(() -> {
            try {
                // 发送当前时间戳
                emitter.send(TimeUtil.getNowTime());
            } catch (IOException e) {
                // 处理异常（如客户端关闭连接）
                emitter.completeWithError(e);
            }
        }, 0, 1, TimeUnit.SECONDS); // 每秒发送一次

        // 处理连接关闭
        emitter.onCompletion(() -> executor.shutdown());
        emitter.onTimeout(() -> {
            emitter.complete();
            executor.shutdown();
            System.out.println("End");
        });

        return emitter; // 返回SseEmitter实例
    }

    @GetMapping(value = "/stream", produces = org.springframework.http.MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> streamStrings() {
        return Flux.interval(Duration.ofSeconds(1))  // 每秒生成一个数字
                .map(sequence -> "Message " + sequence)  // 转换为字符串
                .doOnNext(message -> {
                    // 在这里添加业务逻辑打印
                    System.out.println("正在生成: " + message);
                    // 这里可以添加更多业务逻辑
                })
                .take(10);  // 限制只发送10个元素（可选）
    }

    private static final List<Integer> NUMBERS = Arrays.asList(1, 2, 3, 4, 5);

    @GetMapping(value = "/stream2", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> customFluxStream() {
        return Flux.<String>create(sink -> {
                    AtomicInteger index = new AtomicInteger(0);

                    // 在独立线程中执行（避免阻塞响应式线程）
                    Schedulers.boundedElastic().schedule(() -> {
                        while (index.get() < NUMBERS.size() && !sink.isCancelled()) {
                            int number = NUMBERS.get(index.getAndIncrement());

                            // 打印并发送数据
                            System.out.println("[处理中] 数字: " + number);
                            sink.next("数据-" + number);

                            // 模拟处理延迟
                            try {
                                Thread.sleep(1000); // 实际项目建议用非阻塞方式
                            } catch (InterruptedException e) {
                                sink.error(e);
                            }
                        }
                        sink.complete();
                    });
                })
                .doOnCancel(() -> System.out.println("客户端断开连接"));
    }

    @GetMapping(value = "/stream3", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> FluxStream() {

        // 创建一个包含字符串数字的 Flux
        Flux<String> flux = Flux.just("1", "2", "3");

        // 使用 map 操作符将字符串转换为整数，乘以 2 后再转换回字符串
        Flux<String> resultFlux = flux.map(str -> {
            try {
                // 将字符串转换为整数
                int num = Integer.parseInt(str);
                // 对整数乘以 2
                int multiplied = num * 2;
                // 将结果转换回字符串
                System.out.println(multiplied);
                return String.valueOf(multiplied);
            } catch (NumberFormatException e) {
                // 若字符串无法转换为整数，可根据需求进行异常处理，这里简单返回原字符串
                System.err.println("Failed to parse string: " + str);
                return str;
            }
        });

        return resultFlux;
    }

    @GetMapping(value = "/stream4", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> FluxStream4() {

        // 原始流：A, B, C
        Flux<String> flux = Flux.just("A", "B", "C")
                // 第一个 concatWith：使用 boundedElastic 调度器
                .concatWith(
                        Flux.just("1", "2", "3")
                                // 切换线程到 boundedElastic
                                .publishOn(Schedulers.boundedElastic())
                                // 模拟阻塞操作（如 I/O、睡眠等）
                                .map(item -> {
                                    try {
                                        Thread.sleep(2000); // 阻塞 200ms
                                        System.out.println("[BoundedElastic] Processed " + item +
                                                " on thread: " + Thread.currentThread().getName());
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    return item;
                                })
                )
                // 第二个 concatWith：普通流（默认使用调用者线程，通常是主线程）
                .concatWith(
                        Flux.just("X", "Y", "Z")
                                .map(item -> {
                                    System.out.println("[Main Thread] Processed " + item +
                                            " on thread: " + Thread.currentThread().getName());
                                    return item;
                                })
                );

        return flux;
    }

}
