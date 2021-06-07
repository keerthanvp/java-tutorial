package com.vpk.tutorial.javatutorial.semaphore.custom;

public class Customer implements Runnable {

    private String name;
    private CustomSemaphore semaphore;

    public Customer(String name, CustomSemaphore semaphore){
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
