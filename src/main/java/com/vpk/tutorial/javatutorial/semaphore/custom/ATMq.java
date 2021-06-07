package com.vpk.tutorial.javatutorial.semaphore.custom;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ATMq {

    private Queue<Customer> queue;

    public ATMq(){
        queue = new ConcurrentLinkedQueue<Customer>();
    }

    public void joinQueue(Customer customer){
        queue.add(customer);
    }

    public Customer leaveQueue(){
        if(!queue.isEmpty()){
            return queue.poll();
        }
        System.out.println("Queue Is Empty");
        return null;
    }

    public Boolean isQueueEmpty(){
        return queue.isEmpty();
    }
}
