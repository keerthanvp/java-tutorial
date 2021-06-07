package com.vpk.tutorial.javatutorial.synchronization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
Single Instance : One thread per instance so the other thread has to wait for the first thread to finish
Two instances : Since we are having two different instances we can execute it simultaneously from two different threads
 */
public class SynchronizedTest {
    public static void main(String[] args) {
        executeSingleInstance();
//        executeTwoInstance();
    }

    public static void executeSingleInstance(){
        MathService mathService = new MathService();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(()->{
            try {
                int sum = mathService.add(10,20);
                System.out.println(sum);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.execute(()->{
            try {
                int result = mathService.subtract(20,10);
                System.out.println(result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.shutdown();
    }

    public static void executeTwoInstance(){
        MathService mathService1 = new MathService();
        MathService mathService2 = new MathService();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(()->{
            try {
                int sum = mathService1.add(10,20);
                System.out.println(sum);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.execute(()->{
            try {
                int result = mathService2.subtract(20,10);
                System.out.println(result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.shutdown();
    }
}
