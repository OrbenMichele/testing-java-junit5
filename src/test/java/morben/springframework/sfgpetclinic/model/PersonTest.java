package morben.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void groupedAssertions(){

        //given
        Person person = new Person(1L, "Joe", "Last");

        //then
        assertAll("Test Pops Set",
                () -> assertEquals("Joe", person.getFirstName()),
                () -> assertEquals("Last", person.getLastName()));
    }

    @Test
    void groupedAssertionsMsgs(){

        //given
        Person person = new Person(1L, "Joe", "Last");

        //then
        assertAll("Test Pops Set",
                () -> assertEquals("Joe", person.getFirstName(), "First name failed"),
                () -> assertEquals("Last", person.getLastName(), "Last name failed"));
    }
}