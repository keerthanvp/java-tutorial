package com.vpk.tutorial.javatutorial.java8.streams.example1;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsApiTest1 {

    private static List<String> list;

    public static void main(String[] args) {
        init();
        numberOfDistinctElements();
        distinctElements();
        filterNamesContainingALetter();
        convertNamesToUppercase();

        printIntegerStream();
        printIntegerStreamSumWithSkip();
        printIntegerStreamSummaryStatistics();
        printDoubleSum();

        sortFilterPrint();
        sortFilterCollectPrint();
    }

    public static void init(){
        list = new ArrayList<>();
        list.add("Sebastian");
        list.add("Mark");
        list.add("Ben");
        list.add("Tim");
        list.add("Paul");
        list.add("Segal");
        list.add("Ben");
        list.add("Paul");
        list.add("James");
        list.add("Brandon");
        list.add("Shawn");
        list.add("Samuel");
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

    public static void printIntegerStream(){
        System.out.println("\nInteger stream: ");
        IntStream.range(1,10)
                .forEach(System.out::println);
    }

    public static void printIntegerStreamSumWithSkip(){
        int sum = IntStream.range(1,10)
                .skip(3)
                .sum();
        System.out.println("\nSum from 4-10: "+sum);
    }

    public static void printIntegerStreamSummaryStatistics(){
        IntSummaryStatistics summaryStatistics = IntStream.of(1,20,30,42,5,23,67,27)
                .summaryStatistics();
        System.out.println("\nIntSummaryStatistics: "+summaryStatistics);
    }

    public static void printDoubleSum(){
        Double sum = Stream.of(20.0,30.1,23.5)
                .reduce(0.0,(Double runningSum, Double value)->runningSum+value);
        //Method Reference representation:  .reduce(0.0, Double::sum);
        System.out.println("\nSum of double stream: "+sum);
    }

    public static void sortFilterPrint(){
        System.out.println("\nAll names starting with S in sorted order");
        list.stream()
                .filter(name->name.startsWith("S"))
                .sorted()
                .forEach(System.out::println);
    }

    public static void sortFilterCollectPrint(){
        System.out.println("\nAll names containing 'A' in sorted order");
        List<String> collection = list.stream()
                .filter(name->name.contains("a"))
                .sorted()
                .collect(Collectors.toCollection(ArrayList::new));

        collection.forEach(System.out::println);
    }
}
