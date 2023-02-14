import org.junit.jupiter.api.Test;
import org.mps.person.Person;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    public void personNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> new Person(null, 20, "Male"));
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


}
