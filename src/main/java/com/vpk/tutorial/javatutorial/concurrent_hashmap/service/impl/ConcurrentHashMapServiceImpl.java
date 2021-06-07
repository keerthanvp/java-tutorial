package com.vpk.tutorial.javatutorial.concurrent_hashmap.service.impl;

import com.vpk.tutorial.javatutorial.concurrent_hashmap.service.ConcurrentHashMapService;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class ConcurrentHashMapServiceImpl implements ConcurrentHashMapService {

    private ConcurrentHashMap<Integer,String> map;

    public ConcurrentHashMapServiceImpl(){
        map = new ConcurrentHashMap<>();
        map.put(1,"one");
        map.put(2,"two");
        map.put(3,"three");
        map.put(4,"four");
        map.put(5,"five");
        map.put(6,"Six");
        map.put(7,"Seven");
        map.put(8,"Eight");
        map.put(9,"Nine");
        map.put(10,"Ten");
    }

    @Override
    public void forEach(long parallelismThreshold) {
        map.forEach(parallelismThreshold,(k,v)->{
            System.out.println(""+Thread.currentThread().getId()+":"+v+"\t"+Thread.currentThread());
        });
    }

    @Override
    public void forEachKey(long parallelismThreshold, int key) {
        map.forEachKey(parallelismThreshold,(k)->{
            System.out.println(""+Thread.currentThread().getId()+":"+k+"\t"+Thread.currentThread());
            if (k == key){
                System.out.println("key is present : "+k);
            }
        });
    }

    @Override
    public void forEachValue(long parallelismThreshold, String value) {
        map.forEachValue(parallelismThreshold,(v)->{
            System.out.println(""+Thread.currentThread().getId()+":"+v+"\t"+Thread.currentThread());
            if(value.equals(v)){
                System.out.println("Value is present : "+v);
            }
        });
    }

    @Override
    public void forEachEntry(long parallelismThreshold) {

    }

    @Override
    public void search(long parallelismThreshold, int key) {
        String result = map.search(parallelismThreshold,(k,v)->{
            System.out.println(""+Thread.currentThread().getId()+":"+k+"\t"+Thread.currentThread());
            if(k == key){
                return k + v;
            }
            return null;
        });
        System.out.println("result: "+result);
    }
}
