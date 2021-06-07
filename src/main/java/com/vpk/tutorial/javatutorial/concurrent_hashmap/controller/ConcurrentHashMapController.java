package com.vpk.tutorial.javatutorial.concurrent_hashmap.controller;

import com.vpk.tutorial.javatutorial.concurrent_hashmap.service.ConcurrentHashMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/concurrentHashMap")
public class ConcurrentHashMapController {

    @Autowired
    ConcurrentHashMapService concurrentHashMapService;

    @GetMapping("/forEach")
    public void forEach(@RequestParam long parallelismThreshold){
        concurrentHashMapService.forEach(parallelismThreshold);
        System.out.println("----------------------------------------------------------");
    }

    @GetMapping("/forEachKey")
    public void forEachKey(@RequestParam long parallelismThreshold, @RequestParam int key){
        concurrentHashMapService.forEachKey(parallelismThreshold, key);
        System.out.println("----------------------------------------------------------");
    }

    @GetMapping("/forEachValue")
    public void forEachValue(@RequestParam long parallelismThreshold, @RequestParam String value){
        concurrentHashMapService.forEachValue(parallelismThreshold, value);
        System.out.println("----------------------------------------------------------");
    }

    @GetMapping("/search")
    public void search(@RequestParam long parallelismThreshold, @RequestParam int key){
        concurrentHashMapService.search(parallelismThreshold, key);
        System.out.println("----------------------------------------------------------");
    }
}
