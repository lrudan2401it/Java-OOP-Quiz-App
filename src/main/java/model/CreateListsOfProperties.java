package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CreateListsOfProperties {
    private static final List<Person> PEOPLE = List.of(new Person("Sarah", 29),
                                                       new Person("John", 16),
                                                       new Person("Mary", 21),
                                                       new Person("Susan", 55));

    public static void main(String... args) {
        System.out.println("Without Streams");
        withoutStreams();

        System.out.println("With Streams");
        withStreams();
    }

    private static void withoutStreams() {
        List<String> names = new ArrayList<>();
        List<Integer> ages = new ArrayList<>();

        for (Person person : PEOPLE) {
            names.add(person.getName());
            ages.add(person.getAge());
        }

        // To print the results you most likely used something like StringUtils.join, or Guava's Joiner
        // Or you did messy things like this:
        System.out.println("Names: " + String.join(", ", names.toArray(new String[0])));
        System.out.println("Ages: " + Arrays.toString(ages.toArray()).replace("[", "").replace("]", ""));
    }

    private static void withStreams() {
        List<String> names = PEOPLE.stream().map(Person::getName).collect(Collectors.toList());
        List<Integer> ages = PEOPLE.stream().map(Person::getAge).collect(Collectors.toList());

        System.out.println("Names: " + names.stream().collect(Collectors.joining(", ")));
        System.out.println("Ages: " + ages.stream().map(Object::toString).collect(Collectors.joining(", ")));
    }

    private static class Person {
        private String name;
        private int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        String getName() {
            return name;
        }

        int getAge() {
            return age;
        }
    }
}