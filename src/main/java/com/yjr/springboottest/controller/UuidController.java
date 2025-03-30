package com.yjr.springboottest.controller;

import com.yjr.springboottest.service.UuidGeneratorService;
import io.lettuce.core.ScriptOutputType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("/uuid")
@RestController
public class UuidController {

    @Autowired
    private UuidGeneratorService uuidGeneratorService;

    @GetMapping("/test")
    public String uuid(@RequestParam String query) {

        String result = uuidGeneratorService.generateUuid(query);
        System.out.println(result);

        return result;
    }

}
