package org.jhotdraw.action.edit;

import com.tngtech.jgiven.annotation.ScenarioStage;
import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

public class MyJGivenTest extends ScenarioTest<DeleteActionGiven, DeleteActionWhen, DeleteActionThen> {

    @ScenarioStage
    DeleteActionGiven givenStage;

    @ScenarioStage
    DeleteActionWhen whenStage;

    @ScenarioStage
    DeleteActionThen thenStage;



    @Test
    public void test_scenario() {
        given().a_text_component_with_text("Hello world");
        when().an_action_is_performed();
        then().the_text_should_be_correct("Hello world 1");
    }
}