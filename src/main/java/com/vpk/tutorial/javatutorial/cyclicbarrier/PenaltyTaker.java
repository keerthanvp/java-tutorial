package com.vpk.tutorial.javatutorial.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class PenaltyTaker implements Runnable{

    private CyclicBarrier cyclicBarrier;

    public PenaltyTaker(CyclicBarrier cyclicBarrier){
        this.cyclicBarrier = cyclicBarrier;
    }

    public void run() {
        System.out.println("Walking towards the penalty spot");
        try {
            Thread.sleep(5000);
            System.out.println("Penalty taker is ready");
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
}
