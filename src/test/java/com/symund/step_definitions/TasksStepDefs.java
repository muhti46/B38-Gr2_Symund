package com.symund.step_definitions;

import com.symund.pages.TasksPage;
import com.symund.utilities.BrowserUtils;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.Keys;

public class TasksStepDefs {

TasksPage tasksPage=new TasksPage();

    @When("the user clicks on {string}")
    public void theUserClicksOn(String navigationButton) {
        tasksPage.addlistButton.click();
        BrowserUtils.sleep(3);
    }

    @And("enters {string} as the name of the new list and hits the enter")
    public void entersAsTheNameOfTheNewListAndHitsTheEnter(String nameOfTheList) {
        tasksPage.newListBox.sendKeys(nameOfTheList+Keys.ENTER);
    }

    @Then("a new task list named {string} should be created and displayed in the sidebar")
    public void aNewTaskListNamedShouldBeCreatedAndDisplayedInTheSidebar(String createdTaskListName) {
        BrowserUtils.sleep(2);
        tasksPage.displayCreatedTaskListName(createdTaskListName);
    }

    @Given("the user has selected the {string} list")
    public void theUserHasSelectedTheList(String nameOfTheList) {
        BrowserUtils.sleep(2);
        tasksPage.clickOnSelectedList(nameOfTheList);
    }


    @When("the user enters {string} in the Add a task to field and hits the enter")
    public void theUserEntersInTheAddATaskToFieldAndHitsTheEnter(String taskName) {
        BrowserUtils.waitFor(3);
        tasksPage.addingTask(taskName);
    }

    @Then("{string} should be added to the {string} task list")
    public void shouldBeAddedToTheTaskList(String taskName, String listName) {
       tasksPage.clickOnSelectedList(listName);
        BrowserUtils.waitForVisibility(By.xpath("//div[@class='title']/span[text()='" + taskName +"']"), 10);
        tasksPage.verifyTaskInList(taskName, listName);

    }

    @Given("{string} exists in the {string} task list")
    public void existsInTheTaskList(String taskName, String listName) {
        tasksPage.clickOnSelectedList(listName);
        BrowserUtils.waitForVisibility(By.xpath("//div[@class='title']/span[text()='" + taskName +"']"), 20);
        tasksPage.verifyTaskInList(taskName, listName);
    }

    @When("the user clicks on the checkbox next to {string} task")
    public void theUserClicksOnTheCheckboxNextToTask(String taskName) {
       BrowserUtils.waitForClickablility(By.xpath("//span[.='"+taskName+"']/../../preceding-sibling::div/label"),15);
       tasksPage.getCheckboxForTask(taskName).click();
    }

    @Then("sees the {string} task checked")
    public void seesTheTaskChecked(String taskName) {
        BrowserUtils.waitFor(15);
        Assert.assertTrue(
                "Task '" + taskName + "' is not marked as completed!",
                tasksPage.isTaskCompleted(taskName)
        );

    }
}
