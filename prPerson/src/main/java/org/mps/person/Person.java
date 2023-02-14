package org.mps.person;


import java.util.List;

/**
 * Class representing a person with a name, age and gender
 * @author Daniel de Lizaur
 */
public class Person {
    private final String name;
    private final int age;

    private final String gender; // male, female

    /**
     * Constructs a person with a name, age and gender
     * @param name the name of the person
     * @param age the age of the person
     * @param gender the gender of the person
     */
    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    /**
     * Computes the average age of male and female persons in a list and returns the
     * result in an array of two elements, where the first element is the male mean age
     * and the second one is the female mean age
     * @param persons
     * @return
     */
    public double[] averageAgePerGender(List<Person> persons) {
        return null;
    }
}
