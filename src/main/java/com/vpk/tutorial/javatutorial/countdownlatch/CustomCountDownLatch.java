package com.vpk.tutorial.javatutorial.countdownlatch;

public class CustomCountDownLatch  {

    private int count;

    public CustomCountDownLatch(int count){
        this.count = count;
    }

    public synchronized void await() throws InterruptedException {
        if (count>0){
            this.wait();
        }
    }

    public synchronized void countDown(){
        count --;

        if (count == 0){
            this.notify();
        }
    }
}
