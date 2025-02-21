package com.symund.step_definitions;
import com.symund.pages.TasksPage;
import com.symund.utilities.BrowserUtils;
import com.symund.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class TasksStepDefs {

    TasksPage tasksPage = new TasksPage();

    @When("the user clicks on {string}")
    public void theUserClicksOn(String navigationButton) {
        tasksPage.addlistButton.click();
        BrowserUtils.sleep(3);
    }

    @And("enters {string} as the name of the new list and hits the enter")
    public void entersAsTheNameOfTheNewListAndHitsTheEnter(String nameOfTheList) {
        tasksPage.newListBox.sendKeys(nameOfTheList + Keys.ENTER);
    }

    @Then("a new task list named {string} should be created and displayed in the sidebar")
    public void aNewTaskListNamedShouldBeCreatedAndDisplayedInTheSidebar(String createdTaskListName) {
        BrowserUtils.sleep(2);
        tasksPage.displayCreatedTaskListName(createdTaskListName);
    }

    @Given("the user has selected the {string} list")
    public void theUserHasSelectedTheList(String nameOfTheList) {
        BrowserUtils.waitForClickablility(By.xpath("//span[@title='"+nameOfTheList+"']"),3);
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
        BrowserUtils.waitForVisibility(By.xpath("//div[@class='title']/span[text()='" + taskName + "']"), 10);
        tasksPage.verifyTaskInList(taskName, listName);
    }

    @Given("{string} exists in the {string} task list")
    public void existsInTheTaskList(String taskName, String listName) {
        tasksPage.clickOnSelectedList(listName);
        BrowserUtils.waitForVisibility(By.xpath("//div[@class='title']/span[text()='" + taskName + "']"), 20);
        tasksPage.verifyTaskInList(taskName, listName);
    }

    @When("the user clicks on the checkbox next to {string} task")
    public void theUserClicksOnTheCheckboxNextToTask(String taskName) {
        BrowserUtils.clickWithWait(By.xpath("//span[.='"+taskName+"']/../../preceding-sibling::div/label"),3);
    }

    @Then("sees the {string} task checked")
    public void seesTheTaskChecked(String taskName) {
        WebElement completeCheckbox = Driver.getDriver().findElement(By.xpath("//li[contains(@class, 'task-item')" +
        " and contains(@class, 'done')]//span[normalize-space(text())='" + taskName + "']/../../preceding-sibling::div/label"));
        BrowserUtils.waitForPresenceOfElement(By.xpath("//li[contains(@class, 'task-item') and contains(@class, 'done')]" +
        "//span[normalize-space(text())='"+taskName +"']/../../preceding-sibling::div/label"),10);
        BrowserUtils.verifyElementDisplayed(completeCheckbox);

    }
}