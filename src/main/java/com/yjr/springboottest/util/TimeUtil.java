package com.yjr.springboottest.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtil {
    public static String getNowTime() {
        // 获取当前日期和时间
        LocalDateTime currentDateTime = LocalDateTime.now();
        // 定义日期时间格式，精确到秒
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 格式化当前时间
        String formattedDateTime = currentDateTime.format(formatter);

        return formattedDateTime;
    }
}
