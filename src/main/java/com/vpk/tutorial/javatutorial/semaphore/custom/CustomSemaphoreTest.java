package com.vpk.tutorial.javatutorial.semaphore.custom;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomSemaphoreTest {

    public static void main(String[] args) {
        CustomSemaphore customSemaphore = new CustomSemaphore(2);

        ATMq atmQue = new ATMq();
        atmQue.joinQueue(new Customer("Holland",customSemaphore));
        atmQue.joinQueue(new Customer("Sancho",customSemaphore));
        atmQue.joinQueue(new Customer("Mbappe",customSemaphore));
        atmQue.joinQueue(new Customer("Wilson",customSemaphore));

        ExecutorService executorService = Executors.newCachedThreadPool();
        while (!atmQue.isQueueEmpty()){
            executorService.execute(atmQue.leaveQueue());
        }
    }

}
