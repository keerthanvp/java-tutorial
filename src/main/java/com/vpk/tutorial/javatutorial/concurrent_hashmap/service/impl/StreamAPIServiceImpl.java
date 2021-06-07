package com.vpk.tutorial.javatutorial.concurrent_hashmap.service.impl;

import com.vpk.tutorial.javatutorial.concurrent_hashmap.service.StreamAPIService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StreamAPIServiceImpl implements StreamAPIService {

    private List<String> list;

    public StreamAPIServiceImpl(){
        list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
    }

    @Override
    public void fetch() {
        System.out.println("Stream: "+list.stream());
        System.out.println("Stream: "+list.stream().count());
        System.out.println("Stream: "+list.stream().map((value)->{return value.toLowerCase();}));
    }
}
