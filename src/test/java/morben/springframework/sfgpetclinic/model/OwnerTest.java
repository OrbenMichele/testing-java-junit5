package morben.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {

    @Test
    void dependentAssertions(){

        Owner owner = new Owner(1L, "Joe", "Last");
        owner.setCity("Floripa");
        owner.setTelephone("+5548991833333");

        assertAll("Properties Test",
                () -> assertAll("Person Properties",
                    () -> assertEquals("Joe", owner.getFirstName(), "First name Did Not Match"),
                    () -> assertEquals("Last", owner.getLastName())),
                () ->  assertAll("Owner Properties",
                        () -> assertEquals("Floripa", owner.getCity(), "City Did Not Match"),
                        () -> assertEquals("+5548991833333", owner.getTelephone())
        ));
    }

}