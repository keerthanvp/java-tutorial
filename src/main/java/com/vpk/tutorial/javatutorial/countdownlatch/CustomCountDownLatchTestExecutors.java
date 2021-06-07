package com.vpk.tutorial.javatutorial.countdownlatch;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomCountDownLatchTestExecutors {
    public static void main(String[] args) {

        System.out.println("Thread : "+Thread.currentThread().getId()+"\tExecution of main started");
        CustomCountDownLatch countDownLatch = new CustomCountDownLatch(2);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new DBReaderTask(countDownLatch));
        executorService.execute(new FileReaderTask(countDownLatch));

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread : "+Thread.currentThread().getId()+"\tExecution of main resumed");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread : "+Thread.currentThread().getId()+"\tExecution of main completed");
        executorService.shutdown();
    }
}
