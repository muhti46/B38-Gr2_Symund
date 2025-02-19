package com.symund.step_definitions;

import com.symund.pages.TasksPage;
import io.cucumber.java.en.And;

public class TasksStepDefs {

    TasksPage tasksPage = new TasksPage();

    @And("the user navigates to {string} module")
    public void the_user_navigates_to_module(String moduleName) {
        tasksPage.clickMenuByText(moduleName);
    }
}
