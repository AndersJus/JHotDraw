package org.jhotdraw.action.edit;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ScenarioState;

import javax.swing.text.JTextComponent;
import java.awt.event.ActionEvent;

public class DeleteActionWhen extends Stage<DeleteActionWhen> {
    @ScenarioState(required = true)
    String message;

    @ScenarioState
    String result;


    public void an_action_is_performed(){
        result = message + " 1";
    }
}
