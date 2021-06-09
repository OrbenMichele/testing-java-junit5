package morben.springframework.sfgpetclinic.model;

import morben.springframework.sfgpetclinic.CustomArgsProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

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

    @DisplayName("Value Source Test ")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ValueSource(strings = {"Spring", "Famework", "morben"})
    void testValueSouce(String val) {
        System.out.println(val);
    }

    @DisplayName("Enum Source Test ")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @EnumSource(OwnerType.class)
    void enumTest(OwnerType ownerType) {
        System.out.println(ownerType);
    }

    @DisplayName("CSV Input Test ")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvSource({
            "FL, 1, 2",
            "OH, 2, 3",
            "MI, 3, 4"
    })
    void csvInputTest(String stateName, int val1, int val2) {
        System.out.println(stateName + " - " + val1 + ":" + val2);
    }

    @DisplayName("CSV from File Test ")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvFileSource(resources = "/input.csv", numLinesToSkip = 1)
    void csvFromFileSourceTest(String stateName, int val1, int val2) {
        System.out.println(stateName + " - " + val1 + ":" + val2);
    }

    @DisplayName("Method Provider Test ")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @MethodSource("getArgs")
    void fromMethodProviderTest(String stateName, int val1, int val2) {
        System.out.println(stateName + " - " + val1 + ":" + val2);
    }

    static Stream<Arguments> getArgs() {
        return Stream.of(
                Arguments.of("FL", 14, 24),
                Arguments.of("MI", 12, 23)
        );
    }


    @DisplayName("Custom Provider Test ")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ArgumentsSource(CustomArgsProvider.class)
    void customProviderTest(String stateName, int val1, int val2) {
        System.out.println(stateName + " - " + val1 + ":" + val2);
    }
}
