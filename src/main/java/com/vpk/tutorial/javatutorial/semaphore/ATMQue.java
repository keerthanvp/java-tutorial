package com.vpk.tutorial.javatutorial.semaphore;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ATMQue {

    private Queue<Person> queue;

    public ATMQue(){
        queue = new ConcurrentLinkedQueue<>();
    }

    public void joinQueue(Person person){
        queue.add(person);
    }

    public Person leaveQueue(){
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
