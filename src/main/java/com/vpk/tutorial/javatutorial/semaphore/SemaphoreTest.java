package com.vpk.tutorial.javatutorial.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);

        System.out.println("Welcome to the ATM system\nOnly two people are allowed inside the ATM counter");

        ATMQue atmQue = new ATMQue();
        atmQue.joinQueue(new Person("Aguero",semaphore));
        atmQue.joinQueue(new Person("Benayoun",semaphore));
        atmQue.joinQueue(new Person("Kuyt",semaphore));
        atmQue.joinQueue(new Person("Gerrard",semaphore));
        atmQue.joinQueue(new Person("Torres",semaphore));
        atmQue.joinQueue(new Person("Carragher",semaphore));
        atmQue.joinQueue(new Person("Alonso",semaphore));

        ExecutorService executorService = Executors.newCachedThreadPool();
        while (!atmQue.isQueueEmpty()){
            executorService.execute(atmQue.leaveQueue());
        }
    }
}
