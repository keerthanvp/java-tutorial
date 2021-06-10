package com.vpk.tutorial.javatutorial.java8.streams.example1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamsApiTest1 {

    private static List<String> list;

    public static void main(String[] args) {
        init();
        numberOfDistinctElements();
        distinctElements();
        filterNamesContainingALetter();
        convertNamesToUppercase();
    }

    public static void init(){
        list = new ArrayList<>();
        list.add("Mark");
        list.add("Ben");
        list.add("Tim");
        list.add("Paul");
        list.add("Ben");
        list.add("Paul");
    }

    public static void numberOfDistinctElements(){
        System.out.println("Total Names Count: "+ list.size());
        long count = list.stream().distinct().count();
        System.out.println("Distinct Names Count: "+count);
    }

    public static void distinctElements(){
        System.out.println("\nDistinct Names: ");
        list.stream().distinct().forEach((name)-> System.out.println("Name: "+name));
    }

    public static void filterNamesContainingALetter(){
        System.out.println("\nNames containing letter A: ");
        Stream<String> stringStream = list.stream().filter((name)-> name.contains("a"));
        stringStream.forEach(ele-> System.out.println("Name: "+ele));
    }

    public static void convertNamesToUppercase(){
        System.out.println("\nPrinting all Names in uppercase: ");
        list.stream()
                .map(String::toUpperCase)
                .forEach(name-> System.out.println("Name: "+name));
    }
}
