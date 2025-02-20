package com.symund.step_definitions;
import com.symund.pages.TasksPage;
import com.symund.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;

public class TasksStepDefs {

TasksPage tasksPage=new TasksPage();

    @When("the user clicks on {string}")
    public void theUserClicksOn(String navigationButton) {
        tasksPage.addlistButton.click();
        BrowserUtils.sleep(3);

    }

    @And("enters {string} as the name of the new task list and hits the enter")
    public void entersAsTheNameOfTheNewTaskListAndHitsTheEnter(String nameOfTheNewTaskList) {
      tasksPage.newListBox.sendKeys(nameOfTheNewTaskList+Keys.ENTER);
      //tasksPage.saveButton.click();
        BrowserUtils.sleep(3);
    }

    @Then("a new task list named {string} should be created and displayed in the sidebar")
    public void aNewTaskListNamedShouldBeCreatedAndDisplayedInTheSidebar(String createdTaskListName) {
        tasksPage.displayCreatedTaskListName(createdTaskListName);
    }

