package com.vpk.tutorial.javatutorial.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierTest {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        System.out.println("Welcome to Penalty Shootout");

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i =0; i<3;i++){
            System.out.println("*****Round: "+(i+1));
            executorService.execute(new Goalkeeper(cyclicBarrier));
            executorService.execute(new PenaltyTaker(cyclicBarrier));

            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("Penalty Taker has taken the penalty and it is a goal!");
            cyclicBarrier.reset();
        }
        executorService.shutdown();

    }
}
