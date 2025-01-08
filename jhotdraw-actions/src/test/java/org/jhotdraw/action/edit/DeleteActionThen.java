package org.jhotdraw.action.edit;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ScenarioState;

import org.junit.jupiter.api.Assertions;

public class DeleteActionThen extends Stage<DeleteActionThen> {

    @ScenarioState(required = true)
    String result;

    public void the_text_should_be_correct(String expectedResult){
        Assertions.assertEquals(expectedResult, result);
    }
}
