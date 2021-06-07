package morben.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInstance;

/**
 * Created by micheleorben on 6/6/21
 */

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Tag("controllers")
public interface ControllersTest {

    @BeforeAll
    default void beforeAll() {
        System.out.println("Lets do smt here");
    }
}
