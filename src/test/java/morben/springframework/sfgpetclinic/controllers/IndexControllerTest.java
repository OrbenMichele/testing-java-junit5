package morben.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

//@Tag("controllers")
class IndexControllerTest implements ControllersTest{

    private IndexController indexController;
    @BeforeEach
    void setUp() {
        indexController = new IndexController();
    }

    @DisplayName("Test proper view name is returned for index page")
    @Test
    void index() {
        assertEquals("index", indexController.index());

        assertEquals("index", indexController.index(),
                "Wrong View Returned");

        assertEquals("index", indexController.index(),
                () -> "Another Expensive Message " +
                "Make me only if you have to");

        assertThat(indexController.index()).isEqualTo("index"); //AssertJ

    }

    @Test
    @DisplayName("Test exception")
    void oupsHandler() {

        assertThrows(ValueNotFoundException.class,
                () -> { indexController.oupsHandler();
        });

//        assertTrue("notimplemented".equals(indexController.oupsHandler()));
//
//        assertTrue("notimplemented".equals(indexController.oupsHandler()),
//                () -> "This is some expensive " +
//                "Message to build "+
//                "for my test"
//        );
    }

    @Disabled("Demo of timeout")
    @Test
    void testTimeOut() {
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(5000);

            System.out.println("I got here!!");

        });

    }

    @Disabled("Demo of timeout")
    @Test
    void testTimeOutPreempt() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(5000);

            System.out.println("I Did not get here!");

        });

    }

    @Test
    void testAssumptionTrue() {

        assumeTrue("micheleorben".equalsIgnoreCase(System.getenv("USER")));

    }

    @Test
    void testAssumptionTrueAssumptionIsTrue() {

        assumeTrue("MORBEN".equalsIgnoreCase("MORBEN"));

    }

    @EnabledOnOs(OS.MAC)
    @Test
    void testMeOnMacOS() {

    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void testMeOnWindows() {

    }

    @EnabledOnOs(OS.LINUX)
    @Test
    void testMeOnLinux() {

    }

    @EnabledOnJre(JRE.JAVA_8)
    @Test
    void testMeOnJava8() {

    }

    @EnabledOnJre(JRE.JAVA_11)
    @Test
    void testMeOnJava11() {

    }

    @EnabledIfEnvironmentVariable(named = "USER", matches = "micheleorben")
    @Test
    void testIfUserMicheleOrben() {

    }

    @EnabledIfEnvironmentVariable(named = "USER", matches = "mo")
    @Test
    void testIfUserMO() {

    }
}