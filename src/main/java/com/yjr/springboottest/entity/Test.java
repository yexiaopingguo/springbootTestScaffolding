package com.yjr.springboottest.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yjr.springboottest.entity.enums.ProcessStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.LocalTime;
import java.util.Stack;
import java.util.concurrent.TimeUnit;


@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("test_table")
public class Test {

    private Integer testColumn1;
    private String testColumn2;

    public static int[] global_nums;

    public static TreeNode mid (int start, int end) {
        if (start > end || end > global_nums.length || start < 0) return null;

        TreeNode root = new TreeNode(global_nums[(start + end) / 2]);
        root.left = mid(start, (start + end) / 2 - 1);
        root.right = mid((start + end) / 2 + 1, end);

        return root;
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        global_nums = nums;
        TreeNode root = mid(0, nums.length - 1);

        return root;
    }

    private static Flux<String> getFluxWithDefer1() {
        // 创建一个包含当前时间的 Flux
        String currentTime = LocalTime.now().toString();
        return Flux.just("Time at creation: " + currentTime);
    }

    private static Flux<String> getFluxWithDefer2() {
        // 使用 defer 延迟创建 Flux
        return Flux.defer(() -> {
            String currentTime = LocalTime.now().toString();
            return Flux.just("Time at subscription: " + currentTime);
        });
    }

    public static void main(String[] args) {
        System.out.println(ProcessStatusEnum.PENDING.getCode());
    }

}
