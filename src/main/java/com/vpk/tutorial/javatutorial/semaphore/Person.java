package com.vpk.tutorial.javatutorial.semaphore;

import java.util.concurrent.Semaphore;

public class Person implements Runnable {

    private String name;
    private Semaphore semaphore;

    public Person(String name, Semaphore semaphore){
        this.name = name;
        this.semaphore = semaphore;
    }

    public void run() {
        try {
            semaphore.acquire();
            System.out.println("Thread : "+Thread.currentThread().getId()+"\tEntering the ATM : "+name);
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Thread : "+Thread.currentThread().getId()+"\tStepping out of ATM : "+name);
            semaphore.release();
        }
    }
}
