package com.symund.pages;
import com.symund.utilities.BrowserUtils;
import com.symund.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;

/**
 * {@code TasksPage} class represents the Page Object Model for the Tasks application within Symund.
 * It contains WebElements and methods to interact with the Tasks page.
 */
public class TasksPage extends BasePage {

    /**
     * {@code addlistButton} WebElement represents the "Add List…" button in the sidebar.
     * This button is used to initiate the creation of a new task list.
     */
    @FindBy(xpath = "//span[@title='Add List…']")
    public WebElement addlistButton;

    /**
     * {@code newListBox} WebElement represents the input field that appears after clicking "Add List…".
     * Users enter the name of the new task list into this input field.
     */
    @FindBy(xpath = "//input[@id='newListInput']")
    public WebElement newListBox;

    /**
     * {@code addingTaskBox} WebElement represents the "Add a task to" input field within a selected task list.
     * Users type the name of a new task into this field and press Enter to add it to the list.
     */
    @FindBy(xpath = "//input[@id='target']")
    public WebElement addingTaskBox;

    /**
     * Verifies if a newly created task list name is correctly displayed in the sidebar.
     * It finds the created task list element by its title and asserts if the displayed name matches the expected name.
     * @param taskListName The name of the task list that is expected to be displayed.
     */
    public void displayCreatedTaskListName(String taskListName) {
        WebElement createdTaskList = Driver.getDriver().findElement(By.xpath("//span[@title='" + taskListName + "']"));
        Assert.assertEquals(taskListName, createdTaskList.getText().trim());
    }

    /**
     * Clicks on a specific task list in the sidebar to select and view tasks within that list.
     * @param nameOfTheList The name of the task list to be selected and clicked.
     */
    public void clickOnSelectedList(String nameOfTheList) {
        WebElement selectedList = Driver.getDriver().findElement(By.xpath("//span[@title='" + nameOfTheList + "']"));
        selectedList.click();
    }

    /**
     * Adds a new task to the currently selected task list.
     * It enters the given task name into the "Add a task to"
     * input field and presses the ENTER key to submit.
     * @param taskName The name of the task to be added.
     */
    public void addingTask(String taskName) {
        addingTaskBox.sendKeys(taskName + Keys.ENTER);
    }

    /**
     * Verifies if a specific task is present in a given task list.
     * It selects the task list, then iterates through the displayed tasks in the
     * list and asserts if the target task name is found.
     *
     * @param taskName The name of the task to verify.
     * @param listName The name of the task list where the task should be present.
     */
    public void verifyTaskInList(String taskName, String listName) {
        clickOnSelectedList(listName);
        List<WebElement> tasksInList = Driver.getDriver().findElements(By.xpath("//div[@class='title']/span"));
        boolean taskFound = false;
        for (WebElement task : tasksInList) {
            if (task.getText().trim().equals(taskName)) {
                taskFound = true;
                break;
            }
        }
        Assert.assertTrue("Task '" + taskName + "' was not found in the '" + listName + "' list", taskFound);
    }

    /**
     * Verifies that elements within a task list are displayed on the page.
     * This method locates all task elements within a specified task list using XPath,
     * checks if the list is empty, and then asserts that each task element is displayed.
     * If the list is empty or any task element is not displayed, the test will fail.
     *
     * @param listName The name of the task list to verify. This name is used in the XPath locator
     *                 to find the task list and its elements.
     *
     * @throws AssertionError If the task list is empty, or if any task within the list is not displayed.
     *                        The assertion message will indicate the reason for failure,
     *                        including the list name and the text of the non-visible task (if applicable).
     */
    public void verifyElementsDisplayed(String listName) {
        List<WebElement> uncompletedTasks = Driver.getDriver().findElements(By.xpath("//span[@title='Symund']" +
                                            "/../../../../../following-sibling::main//ol//div/span"));
        if (uncompletedTasks.isEmpty()) {
            Assert.fail(listName + " list is empty");
            return;
        }
        for (WebElement each : uncompletedTasks) {
            Assert.assertTrue("'" + listName + "' tasks are not visible: " + each.getText(), each.isDisplayed());
        }
    }
    /**
     * Verifies the number displayed next to a task list category in the UI.
     * This method locates the element displaying the task count for a given category name,
     * retrieves the text representing the count, and asserts that this count is a number greater than 0.
     * If the count is empty or cannot be parsed as an integer, or if it's not greater than 0, the test will fail.
     * @param categoryName This name is used to locate the element displaying the task count.
     *
     * @throws AssertionError If the task count element is not found, if the text is empty,
     *                        if the text cannot be parsed into an integer, or if the parsed integer is not greater than 0.
     *                        The assertion message will specify the reason for failure,
     *                        including the category name and the problematic task count text (if applicable).
     */
    public int getCurrentTaskCount (String categoryName) {
        String xpath = "//li[contains(@id, 'collection_" + categoryName.toLowerCase()+ "')]//div[@class='app-navigation-entry__counter']";
        By taskCountElementLocator = By.xpath(xpath);
        Wait<WebDriver> wait = new FluentWait<>(Driver.getDriver())
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);

            BrowserUtils.waitFor(5);
        WebElement taskCountElement = wait.until(driver -> driver.findElement(taskCountElementLocator));

        String taskCountText = taskCountElement.getText();

        if (taskCountText == null || taskCountText.isEmpty()) {
            Assert.fail(categoryName + " task count text is empty or not found.");
            return -1;
        }
        try {
            return Integer.parseInt(taskCountText);
        } catch (NumberFormatException e) {
            Assert.fail(categoryName + " task count text could not be converted to a number: " + taskCountText);
            return -1;
        }
    }
}