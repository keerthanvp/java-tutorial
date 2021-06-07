package com.vpk.tutorial.javatutorial.lrucache;

public class CustomLRUCacheTest {
    public static void main(String[] args) {
        CustomLRUCache<Integer,Integer> cache = new CustomLRUCache<>(3);

        cache.put(1,10);
        cache.put(2,20);
        cache.display();
        cache.put(3,30);
        cache.display();
        cache.put(4,40);
        cache.display();
        cache.get(3);
        cache.display();
        cache.get(2);
        cache.display();
    }
}
