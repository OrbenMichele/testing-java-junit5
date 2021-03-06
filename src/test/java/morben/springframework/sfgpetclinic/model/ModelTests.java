package morben.springframework.sfgpetclinic.model;


import org.junit.jupiter.api.*;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Tag("model")
public interface ModelTests {

    @BeforeEach
    default void beforeEachConsoleOutput(TestInfo testInfo) {

        System.out.println("Running Test - " + testInfo.getDisplayName());
    }
}
