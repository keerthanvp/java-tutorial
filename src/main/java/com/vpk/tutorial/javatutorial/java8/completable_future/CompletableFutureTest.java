package com.vpk.tutorial.javatutorial.java8.completable_future;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getId());
        BusinessService businessService = new BusinessService();

        CompletableFuture.runAsync(businessService::uploadImage)
                .thenRun(()-> System.out.println("Image upload completed"))
                .exceptionally((ex)->{throw new RuntimeException(ex);});

        CompletableFuture.supplyAsync(businessService::uploadThumbnail)
                .thenApply((url)-> url+".jpg")
                .thenAccept((url)-> System.out.println("URL: "+url));

        Thread.sleep(5000);
    }
}
