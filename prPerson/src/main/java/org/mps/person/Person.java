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
     * @param gender the gender of the person, must be set to Male or Female
     */
    public Person(String name, int age, String gender) {
        if (name == null) throw new IllegalArgumentException("The name of a person cannot be null");
        if (age < 0) throw new IllegalArgumentException("The age of a person cannot be negative");
        if (gender == null || (!gender.equals("Male") && !gender.equals("Female")))
            throw new IllegalArgumentException("The gender of a person must be equal to Male or Female");
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
     * and the second one is the female mean age. If there are no male persons on the list
     * the first element of the array will be -1, If there are no female persons on the list
     * the second element of the array will be -1
     * @param persons A list of people
     * @return A 2 element array containing the average age of male and female people
     */
    public double[] averageAgePerGender(List<Person> persons) {
        double maleAgeSum = 0, femaleAgeSum = 0;
        int maleCount = 0, femaleCount = 0;
        for (Person person : persons) {
            if (person.getGender().equals("Male")) {
                maleAgeSum += person.getAge();
                maleCount++;
            } else { // we assume there are only two possibilities: male or female
                femaleAgeSum += person.getAge();
                femaleCount++;
            }
        }
        double maleAgeAverage = maleCount == 0? -1 : maleAgeSum / maleCount;
        double femaleAgeAverage = femaleCount == 0? -1 : femaleAgeSum / femaleCount;
        return new double[]{maleAgeAverage, femaleAgeAverage};
    }
}
