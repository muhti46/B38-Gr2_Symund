package com.symund.pages;

import com.symund.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TasksPage extends BasePage {


    @FindBy(xpath = "//span[@title='Add List…']")
    public WebElement addlistButton;

    @FindBy(xpath = "//input[@id='newListInput']")
    public WebElement newListBox;

    @FindBy(xpath = "//input[@id='target']")
    public WebElement addingTaskBox;

    @FindBy(xpath = "//div[@class='title']/span")
    public List<WebElement> tasksList;

    @FindBy(xpath = "//ol[contains(@class, 'completed')]//div[@class='title']")
    public List<WebElement> completedTasks;

    public void displayCreatedTaskListName(String taskListName) {
        WebElement createdTaskList = Driver.getDriver().findElement(By.xpath("//span[@title='" + taskListName + "']"));
        Assert.assertEquals(taskListName, createdTaskList.getText().trim());

    }

    public void clickOnNavigationButtons(String navigationButton) {
        WebElement navigationButtons = Driver.getDriver().findElement(By.xpath("//a[@href='#/collections/"+navigationButton.toLowerCase()+"']"));
        navigationButtons.click();
    }

    public void clickOnSelectedList(String nameOfTheList) {
       WebElement selectedList=Driver.getDriver().findElement(By.xpath("//span[@title='"+nameOfTheList+"']"));
        selectedList.click();

    }

    public void addingTask(String taskName) {
        addingTaskBox.sendKeys(taskName + Keys.ENTER);
    }

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

    public WebElement getCheckboxForTask(String taskName) {
        return Driver.getDriver().findElement(
                By.xpath("//span[.='"+taskName+"']/../../preceding-sibling::div/label")
        );
    }

    public boolean isTaskCompleted(String taskName) {
        try {
            WebElement taskDiv = Driver.getDriver().findElement(
                    By.xpath("//ol[contains(@class,'completed')]//span[normalize-space(text())='"+taskName+"']")
            );

            return taskDiv.getAttribute("class").contains("completed");
        } catch (Exception e) {
            return false;
        }
    }
 }


