package com.vpk.tutorial.javatutorial.java8.executor_service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceTest {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getId());

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(()-> System.out.println(Thread.currentThread().getId()));
        executorService.shutdown();
        System.out.println(executorService.isShutdown());

        ExecutorService fixedPool = Executors.newFixedThreadPool(2);
        fixedPool.execute(()-> System.out.println(Thread.currentThread().getId()));
        fixedPool.shutdown();

        ExecutorService cachedPool = Executors.newCachedThreadPool();

        ExecutorService workStealingPool = Executors.newWorkStealingPool(3);

        ExecutorService scheduledExecutor = Executors.newScheduledThreadPool(2);

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        scheduledExecutorService.scheduleAtFixedRate(()->{},2,5, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleWithFixedDelay(()->{},2,5,TimeUnit.SECONDS);
    }
}
