package morben.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

/**
 * Created by micheleorben on 6/6/21
 */

public class PersonRepeatedTests implements ModelRepeatedTests{


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

    @RepeatedTest(value = 5, name = "{displayName} : {currentRepetition}/{totalRepetitions}")
    @DisplayName("My Assignment repeated test")
    void myAssignmentRepeated() {

    }
}
