package com.kiroule.ocpupgradejava8.topic2_3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Igor Baiborodine
 */
public class ConsumerInterfaceExample {

    public static void main(String... args) {

        Person person1 = new Person("Bender", "Rodriguez");
        Person person2 = new Person("Philip", "Fry");
        Person person3 = new Person("Amy", "Wong");

        List<Person> persons = new ArrayList<>();
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);

        Consumer<Person> fullName = (Person s) -> System.out.println("Full name: " + s.getFirstName() + " " + s.getLastName());
        persons.forEach(fullName);

        for (Person person : persons) {
            person.printFullName(new Person.InvertedFullNameConsumer());
        }
    }
}

class Person {

    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void printFullName(Consumer<Person> consumer) {
        consumer.accept(this);
    }

    public static class InvertedFullNameConsumer implements Consumer<Person> {
        @Override
        public void accept(Person e) {
            System.out.println("Inverted full name: " + e.getLastName() + ", " + e.getFirstName());
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}



