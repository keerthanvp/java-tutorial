package com.vpk.tutorial.javatutorial.concurrent_hashmap.controller;

import com.vpk.tutorial.javatutorial.concurrent_hashmap.service.StreamAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stream")
public class StreamAPIController {

    @Autowired
    private StreamAPIService streamAPIService;

    @GetMapping
    public void simple(){
        streamAPIService.fetch();
    }
}
