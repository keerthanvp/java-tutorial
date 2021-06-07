package com.vpk.tutorial.javatutorial.lrucache;

import java.util.HashMap;
import java.util.Map;

public class CustomLRUCache<k,v> {

    private Node<k,v> mru;
    private Node<k,v> lru;
    private Map<k,Node<k,v>> container;
    private int capacity;
    private int currentSize;

    public CustomLRUCache(int capacity){
        mru = new Node<>(null,null,null,null);
        lru = new Node<>(null,null,null,null);
        container = new HashMap<>();
        this.capacity = capacity;
        currentSize = 0;
    }

    public void put(k key, v value){
        Node<k,v> newNode = new Node<>(key,value,mru,null);
        mru.next = newNode;
        container.put(key,newNode);     //first add the new node to the mru then check if we the capacity is full or not
        mru = newNode;

        if(currentSize==capacity){      //no need to increment and decrement the size here bcuz we are removing a node after adding a new node
            container.remove(lru.key);
            lru = lru.next;
            lru.prev = null;
        }
        else if(currentSize<capacity){
            if (currentSize == 0)
                lru = newNode;          //only one node is present so lru and mru will point to same node in the map
            currentSize++;
        }
    }

    public v get(k key){
        Node<k,v> node = container.get(key);
        if(node == null)
            return null;
        else if (mru.key == key)
            return mru.value;

        Node<k,v> nextNode = node.next;
        Node<k,v> prevNode = node.prev;

        if (lru.key == node.key){
            nextNode.prev = null;
            lru = nextNode;
        }else if(node.key!=mru.key){
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }

        node.prev = mru;
        mru.next = node;
        mru = node;
        mru.next = null;

        return node.value;
    }

    public void display(){
        Node<k,v> currNode = lru;
        while (currNode!=null){
            System.out.println(currNode.value);
            currNode = currNode.next;
        }
        System.out.println("-------------------------------------");
    }
}
