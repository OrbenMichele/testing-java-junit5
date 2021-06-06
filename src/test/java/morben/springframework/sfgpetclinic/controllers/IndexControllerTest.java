package morben.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {

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
}