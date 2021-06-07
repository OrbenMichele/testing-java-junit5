package morben.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

//@Tag("model")
class OwnerTest implements ModelTests{

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

        assertThat(owner.getCity(), is("Floripa")); //hamcrest
    }

    @ParameterizedTest
    @ValueSource(strings = {"Spring", "Famework", "morben"})
    void testValueSouce(String val) {
        System.out.println(val);
    }
}