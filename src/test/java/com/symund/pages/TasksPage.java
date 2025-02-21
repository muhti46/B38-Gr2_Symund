package com.symund.pages;
import com.symund.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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
     * {@code tasksList} List of WebElements representing all task titles displayed in the currently selected task list.
     * Each WebElement in this list corresponds to a task title.
     */
    @FindBy(xpath = "//div[@class='title']/span")
    public List<WebElement> tasksList;

    /**
     * {@code completedTasks} List of WebElements representing the titles of tasks that are marked as completed.
     * These tasks are typically displayed under a "Completed" section or with a different visual style.
     */
    @FindBy(xpath = "//ol[contains(@class, 'completed')]//div[@class='title']")
    public List<WebElement> completedTasks;

    /**
     * {@code completedTaskCheckbox} List of WebElements representing checkboxes of tasks that are marked as completed.
     * This might be used to interact with checkboxes specifically within the completed tasks section,
     * although the current XPath is incomplete and likely incorrect.
     * **Note:** The current XPath `//li[contains(@class, 'task-item') and
     * contains(@class, 'done')]//span[normalize-space(text())='']/../../preceding-sibling::div/label`
     * is likely to have issues as it's looking for a task name with empty text `''`. This XPath might need to be reviewed
     * and corrected based on the actual HTML structure to find checkboxes of completed tasks effectively.
     */
    @FindBy(xpath = "//li[contains(@class, 'task-item') and contains(@class, 'done')]//span[normalize-space(text())='']/../../preceding-sibling::div/label")
    public List<WebElement> completedTaskCheckbox;

    /**
     * {@code completedButton} WebElement represents the "Completed" navigation button in the sidebar.
     * Clicking this button usually navigates the user to the "Completed" tasks view.
     */
    @FindBy(xpath = "//li[@id='collection_completed']")
    public WebElement completedButton;

    /**
     * Verifies if a newly created task list name is correctly displayed in the sidebar.
     * It finds the created task list element by its title and asserts if the displayed name matches the expected name.
     *
     * @param taskListName The name of the task list that is expected to be displayed.
     */
    public void displayCreatedTaskListName(String taskListName) {
        WebElement createdTaskList = Driver.getDriver().findElement(By.xpath("//span[@title='" + taskListName + "']"));
        Assert.assertEquals(taskListName, createdTaskList.getText().trim());
    }

    /**
     * Clicks on the navigation buttons in the sidebar, such as "Important", "All", "Current", or "Completed".
     * This method is used to navigate to different task views.
     * @param navigationButton The name of the navigation button to click (e.g., "Important", "All", "Current", "Completed").
     */
    public void clickOnNavigationButtons(String navigationButton) {
        WebElement navigationButtons = Driver.getDriver().findElement(By.xpath("//a[@href='#/collections/"+navigationButton.toLowerCase()+"']"));
        navigationButtons.click();
    }

    /**
     * Clicks on a specific task list in the sidebar to select and view tasks within that list.
     * @param nameOfTheList The name of the task list to be selected and clicked.
     */
    public void clickOnSelectedList(String nameOfTheList) {
        WebElement selectedList=Driver.getDriver().findElement(By.xpath("//span[@title='"+nameOfTheList+"']"));
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
     * Retrieves the checkbox WebElement for a given task name.
     * This method finds the checkbox element that is associated with a task name.
     *
     * @param taskName The name of the task whose checkbox is to be retrieved.
     * @return WebElement representing the checkbox of the specified task.
     */
    public WebElement getCheckboxForTask(String taskName) {
        return Driver.getDriver().findElement(
                By.xpath("//span[.='"+taskName+"']/../../preceding-sibling::div/label")
        );
    }
}