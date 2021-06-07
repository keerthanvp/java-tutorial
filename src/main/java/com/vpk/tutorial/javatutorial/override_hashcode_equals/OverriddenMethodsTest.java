package com.vpk.tutorial.javatutorial.override_hashcode_equals;

import java.util.HashMap;
import java.util.Map;

/*
User class has overridden hashCode and equals method which validates equality based all the attributes in the user class
Person class has no overridden hashCode and equals method so by default it is verifying the object reference for equality
 */
public class OverriddenMethodsTest {
    public static void main(String[] args) {
        User user1 = new User(1,"Mark",12);
        User user2 = new User(1,"Mark",12);

        System.out.println("user1.equals(user2): "+user1.equals(user2));

        Person person1 = new Person(1,"Mark",12);
        Person person2 = new Person(1,"Mark",12);

        System.out.println("person1.equals(person2): "+person1.equals(person2));

        Map<User,String> userStringMap = new HashMap<>();
        userStringMap.put(user1,"user1");
        userStringMap.put(user2,"user2");

        Map<Person,String> personStringMap = new HashMap<>();
        personStringMap.put(person1,"person1");
        personStringMap.put(person2,"person2");
    }
}
