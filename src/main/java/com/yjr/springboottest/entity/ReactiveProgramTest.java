package com.yjr.springboottest.entity;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.TimeUnit;

public class ReactiveProgramTest {

//    public static void main(String[] args) {
//
//        Flux<String> flux1 = Flux.just("A", "B", "C")
//                .doOnNext(item -> {
//                    try {
//                        TimeUnit.MILLISECONDS.sleep(200);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("Before publishOn - Produced " + item);
//                })
//                .concatWith(Flux.just("X", "Y", "Z"))
//                .doOnNext(item -> System.out.println("After concatWith - Processed " + item));
//
//        flux1.subscribe();
//
//    }

        public static void main(String[] args) {

        Flux<String> flux1 = Flux.just("A", "B", "C")
                .doOnNext(item -> System.out.println("Before publishOn - Produced " + item + " on thread: " + Thread.currentThread().getName()))
                .doOnNext(item -> {
                    // 这里只是示例，实际上 doOnNext 里这么用 publishOn 一般不是常见做法
                    Flux.just(item)
                            .publishOn(Schedulers.boundedElastic())
                            .subscribe(subItem -> {
                                System.out.println("Inside doOnNext - Processed " + subItem + " on thread: " + Thread.currentThread().getName());
                            });
                })
                .concatWith(Flux.just("X", "Y", "Z"))
                .doOnNext(item -> System.out.println("After concatWith - Processed " + item + " on thread: " + Thread.currentThread().getName()));

        flux1.subscribe();

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
