import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mps.person.Person;
import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

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
