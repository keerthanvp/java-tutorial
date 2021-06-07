package com.vpk.tutorial.javatutorial.hashmap;

import java.util.ArrayList;
import java.util.List;

public class CustomHashMap<k,v>{

    private List<HashNode<k,v>> buckets;
    private final int numberOfBuckets = 16;
    private int size;

    public CustomHashMap(){
        buckets = new ArrayList<>();
        for (int i = 0; i < numberOfBuckets; i++) {
            buckets.add(null);
        }
    }

    private int getBucketIndex(k key){
        int hashCode = key.hashCode();
        int index = hashCode % numberOfBuckets;
        System.out.println("HashCode: "+hashCode+"\tIndex: "+index);
        return index;
    }

    public void put(k key, v value){

        int bucketIndex = getBucketIndex(key);
        HashNode<k,v> headNode = buckets.get(bucketIndex);
        while (headNode!=null){
            if (headNode.key.equals(key)){
                headNode.value = value;
                return;
            }
            headNode = headNode.next;
        }
        HashNode<k,v> newNode = new HashNode<>(key, value);
        newNode.next = null;
        buckets.add(bucketIndex,newNode);
        size++;
    }

    public v get(k key){
        int bucketIndex = getBucketIndex(key);
        HashNode<k,v> headNode = buckets.get(bucketIndex);
        while (headNode!=null){
            if(headNode.key.equals(key)){
                return headNode.value;
            }
            headNode = headNode.next;
        }
        return null;
    }

    public boolean isEmpty(){
        return buckets.isEmpty();
    }

    public int size(){
        return size;
    }

    @Override
    public String toString() {
        return "CustomHashMap{" +
                "buckets=" + buckets +
                ", numberOfBuckets=" + numberOfBuckets +
                ", size=" + size +
                '}';
    }
}
