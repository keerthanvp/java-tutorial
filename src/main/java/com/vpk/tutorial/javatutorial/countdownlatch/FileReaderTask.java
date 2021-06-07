package com.vpk.tutorial.javatutorial.countdownlatch;

public class FileReaderTask implements Runnable {

    private CustomCountDownLatch customCountDownLatch;

    public FileReaderTask(CustomCountDownLatch customCountDownLatch){
        this.customCountDownLatch = customCountDownLatch;
    }

    public void run() {
        System.out.println("Thread : "+Thread.currentThread().getId()+"\tExecuting File Reader Task");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread : "+Thread.currentThread().getId()+"\tFile Reader Task execution completed");
        customCountDownLatch.countDown();
    }
}
