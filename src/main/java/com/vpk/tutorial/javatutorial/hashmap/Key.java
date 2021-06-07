package com.vpk.tutorial.javatutorial.hashmap;

public class Key {
    String key;

    public Key(String key){
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    @Override
    public int hashCode(){
        return key.charAt(0);
    }

    @Override
    public boolean equals(Object object){
        Key keyObj = (Key) object;
        return this.key.equals(keyObj.getKey());
    }
}
