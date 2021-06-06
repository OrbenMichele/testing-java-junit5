package morben.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {

    private IndexController indexController;
    @BeforeEach
    void setUp() {
        indexController = new IndexController();
    }

    @Test
    void index() {
        assertEquals("index", indexController.index());
        assertEquals("index", indexController.index(),"Wrong View Returned");

        assertEquals("index", indexController.index(),() -> "Another Expensive Message " +
                "Make me only if you have to");

    }

    @Test
    void oupsHandler() {

        assertTrue("notimplemented".equals(indexController.oupsHandler()));
        assertTrue("notimplemented".equals(indexController.oupsHandler()), () -> "This is some expensive " +
                "Message to build "+
                "for my test"
        );
    }
}