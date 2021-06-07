package com.vpk.tutorial.javatutorial.countdownlatch;

public class CustomCountDownLatchTest {

    public static void main(String[] args) {
        System.out.println("Thread : "+Thread.currentThread().getId()+"\tExecution of main started");
        CustomCountDownLatch countDownLatch = new CustomCountDownLatch(2);

        new Thread(new FileReaderTask(countDownLatch)).start();
        new Thread(new DBReaderTask(countDownLatch)).start();

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
    }
}
