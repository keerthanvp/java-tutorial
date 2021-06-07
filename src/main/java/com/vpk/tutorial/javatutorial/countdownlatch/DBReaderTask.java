package com.vpk.tutorial.javatutorial.countdownlatch;

public class DBReaderTask implements Runnable {

    private CustomCountDownLatch customCountDownLatch;

    public DBReaderTask(CustomCountDownLatch customCountDownLatch){
        this.customCountDownLatch = customCountDownLatch;
    }

    public void run() {
        System.out.println("Thread : "+Thread.currentThread().getId()+"\tExecuting DB Reader Task");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread : "+Thread.currentThread().getId()+"\tDB Reader Task execution completed");
        customCountDownLatch.countDown();
    }
}
