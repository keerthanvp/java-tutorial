package com.vpk.tutorial.javatutorial.concurrent_hashmap.service;

public interface ConcurrentHashMapService {
    void forEach(long parallelismThreshold);
    void forEachKey(long parallelismThreshold, int key);
    void forEachValue(long parallelismThreshold, String value);
    void forEachEntry(long parallelismThreshold);
    void search(long parallelismThreshold, int key);
}
