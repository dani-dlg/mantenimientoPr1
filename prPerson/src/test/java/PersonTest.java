import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mps.person.Person;
import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Person class
 * @author Daniel de Lizaur
 *
 * Tests the following behaviours of the Person claas:
 * - A person's name cannot be null
 * - A person's age cannot be negative
 * - A person's gender cannot be null and must also be equal to either "Male" or "Female"
 * Trying to instantiate a Person with invalid arguments will raise an Exception
 *
 * This class also test the method averageAgePerGender on the following scenarios:
 * - On a list with no male people, the first element of the returned array must be -1
 * - On a list with no female people, the second element of the returned array must be -1
 * - On an empty list, both elements of the returned array must be -1
 * - Otherwise, the first element of the returned array is the average age of every male person, and the second element is the average age of every female person
 */
public class PersonTest {

    // placeholder Person instance used to test the averageAgePerGender method
    private Person p;

    @BeforeEach
    public void setup() {
        p = new Person("Lucas", 21, "Male");
    }
    @Test
    public void personNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> new Person(null, 20, "Male"));
    }

    @Test
    public void getNameReturnsTheName() {
        Person person = new Person("Laura", 36, "Female");
        String obtainedValue = person.getName();
        String expectedValue = "Laura";
        assertEquals(obtainedValue, expectedValue);
    }

    @Test
    public void personAgeCannotBeNegative() {
        assertThrows(IllegalArgumentException.class, () -> new Person("Daniel", -1, "Male"));
    }

    @Test
    public void personGenderCannotBeOtherThanMaleOrFemale() {
        assertThrows(IllegalArgumentException.class, () -> new Person("Daniel", 20, "Other gender"));
    }

    @Test
    public void personGenderCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> new Person("Daniel", 20, null));
    }

    @Test
    public void averageOfEmptyListIsNegativeOne() {
        List<Person> persons = new ArrayList<>();
        double[] obtainedValue = p.averageAgePerGender(persons);
        double[] expectedValue = {-1,-1};
        assertArrayEquals(obtainedValue, expectedValue);
    }

    @Test
    public void averageOfListWithNoMales() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Elena", 20, "Female"));
        persons.add(new Person( "Martina", 30, "Female"));
        double[] obtainedValue = p.averageAgePerGender(persons);
        double[] expectedValue = {-1,25};
        assertArrayEquals(obtainedValue, expectedValue);
    }

    @Test
    public void averageOfListWithNoFemales() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Antonio", 20, "Male"));
        persons.add(new Person( "Miguel", 30, "Male"));
        double[] obtainedValue = p.averageAgePerGender(persons);
        double[] expectedValue = {25,-1};
        assertArrayEquals(obtainedValue, expectedValue);
    }

    @Test
    public void averageOfListWithOneMaleAndOneFemale() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Antonio", 20, "Male"));
        persons.add(new Person( "Martina", 30, "Female"));
        double[] obtainedValue = p.averageAgePerGender(persons);
        double[] expectedValue = {20,30};
        assertArrayEquals(obtainedValue, expectedValue);
    }

    @Test
    public void averageOfMultipleMalesAndFemales() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Elena", 20, "Female"));
        persons.add(new Person( "Miguel", 30, "Male"));
        persons.add(new Person( "Martina", 30, "Female"));
        persons.add(new Person("Antonio", 20, "Male"));
        persons.add(new Person("Daniel", 22, "Male"));
        double[] obtainedValue = p.averageAgePerGender(persons);
        double[] expectedValue = {24,25};
        assertArrayEquals(obtainedValue, expectedValue);
    }


}
