package com.yjr.springboottest.service;

import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

@Service
public class UuidGeneratorService {

    public String generateUuid(String query) {
        // 将 query 转换为字节数组，使用 UTF-8 编码
        byte[] queryBytes = query.getBytes(StandardCharsets.UTF_8);
        // 使用 UUID.nameUUIDFromBytes 方法根据字节数组生成 UUID
        UUID uuid = UUID.nameUUIDFromBytes(queryBytes);
        
        // 将 UUID 转换为字符串返回
        return uuid.toString();
    }
}
