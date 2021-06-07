package com.vpk.tutorial.javatutorial.lrucache;

public class Node<k,v> {
    k key;
    v value;
    Node<k,v> prev;
    Node<k,v> next;
    Node(k key, v value, Node<k,v> prev, Node<k,v> next){
        this.key = key;
        this.value = value;
        this.prev = prev;
        this.next = next;
    }
}
