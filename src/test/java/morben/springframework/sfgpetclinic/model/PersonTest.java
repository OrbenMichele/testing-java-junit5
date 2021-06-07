package morben.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

//@Tag("model")
class PersonTest implements ModelTests{

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

    @RepeatedTest(value = 10, name = "{displayName} : {currentRepetition}/{totalRepetitions}")
    @DisplayName("My repeated test")
    void myRepeatedTest() {
        //todo - impl
    }

    @RepeatedTest(value = 5, name = "{displayName} : {currentRepetition}/{totalRepetitions}")
    //@DisplayName("My repeated test")
    void myRepeatedTestWithDI(TestInfo testInfo, RepetitionInfo repetitionInfo) {

        System.out.println(testInfo.getDisplayName()
                + ": " + repetitionInfo.getCurrentRepetition());
    }
}