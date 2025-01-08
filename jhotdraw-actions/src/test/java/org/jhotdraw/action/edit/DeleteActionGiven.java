package org.jhotdraw.action.edit;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.annotation.Quoted;
import com.tngtech.jgiven.annotation.ScenarioStage;
import com.tngtech.jgiven.annotation.ScenarioState;

import javax.swing.*;
import javax.swing.text.JTextComponent;

public class DeleteActionGiven extends Stage<DeleteActionGiven> {

    @ScenarioState
    String message;

    DeleteActionGiven a_text_component_with_text(@Quoted String message){
        this.message = message;
        return self();
    }

    ;
}
