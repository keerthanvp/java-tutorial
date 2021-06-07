package com.vpk.tutorial.javatutorial.synchronization;

public class MathService {

    public synchronized int add(int num1, int num2) throws InterruptedException {
        System.out.println("Executing add");
        Thread.sleep(2000);
        return num1+num2;
    }

    public synchronized int subtract(int num1, int num2) throws InterruptedException {
        System.out.println("Executing subtract");
        Thread.sleep(3000);
        return num1-num2;
    }
}
