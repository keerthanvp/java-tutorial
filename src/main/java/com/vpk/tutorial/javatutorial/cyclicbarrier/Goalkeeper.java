package com.vpk.tutorial.javatutorial.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Goalkeeper implements Runnable {

    private CyclicBarrier cyclicBarrier;

    public Goalkeeper(CyclicBarrier cyclicBarrier){
        this.cyclicBarrier = cyclicBarrier;
    }

    public void run() {
        System.out.println("Walking towards goalkeeping position");
        try {
            Thread.sleep(3000);
            System.out.println("Goalkeeper is Ready");
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
}
