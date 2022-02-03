/*
* Demonstration of various stream api
* */


package com.kiprono.driver;

import com.kiprono.data.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Driver {

    public static void main(String[] args) {
        // 6 people
        List<Person> people = new ArrayList<>();
        people.add(new Person("Abe", 23, "Male"));
        people.add(new Person("Abraham Kebenei", 20, "Female"));
        people.add(new Person("Abraham Lincoln", 23, "Male"));
        people.add(new Person("Gabriel Kogo", 18, "Female"));
        people.add(new Person("Roger Miller", 17, "Male"));
        people.add(new Person("Ama", 16, "Female"));
        people.add(new Person("Brendon Aware", 19, "Male"));
        people.add(new Person("Yuri Gagarin", 23, "Female"));

        search(people).forEach(System.out::println);

        List<Integer> integerList = people.stream().map(Person::getAge).collect(Collectors.toList());
        System.out.println();
        System.out.println(getString(integerList));
        System.out.println();
        System.out.println(average(integerList));

        List<String> stringList = people.stream().map(Person::getName).collect(Collectors.toList());
        System.out.println();
        System.out.println(upperCase(stringList));
    }

    // 1)	Given a list of Objects, write a method that returns a list of all strings that start with the letter
    // 'a' (lower case) and have exactly 3 letters
    public static List<Person> search(List<Person> personList){
        List<Person> resultsList = new ArrayList<>();

        resultsList = personList.stream()
                .filter(x->x.getName().toLowerCase(Locale.ROOT).startsWith("a"))
                .filter(x->x.getName().length() == 3).collect(Collectors.toList());

        return resultsList;
    }

    // 2)	Write a method that returns a comma separated string based on a given list of integers. Each element should
    // be preceded by the letter 'e' if the number is even, preceded by the letter 'o' if the number is odd.
    public static String getString(List<Integer> list){
        return list.stream().map(i -> i%2 ==0 ? "e" + i : "o" + i).collect(Collectors.joining(","));
    }


    // 3)	Write a method that returns the average of a list of integers.
    public static Double average(List<Integer> integerList){
        return integerList.stream().mapToDouble(i -> i).average().orElse(0.0);
    }

    // 4)	Write a method that converts all strings in a list to their upper case.
    public static List<String> upperCase(List<String> list){
        return list.stream().map(i -> i.toUpperCase()).collect(Collectors.toList());
    }
}
