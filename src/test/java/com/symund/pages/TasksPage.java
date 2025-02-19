package com.symund.pages;

import com.symund.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TasksPage extends BasePage{



    @FindBy(xpath = "//span[@title='Add List…']")
    public WebElement addlistButton;

    @FindBy(xpath= "//input[@id='newListInput']")
    public WebElement newListBox;



    public void displayCreatedTaskListName(String taskListName) {
        WebElement createdTaskListName=Driver.getDriver().findElement(By.xpath("//span[@title='"+taskListName+"']"));
        Assert.assertEquals(taskListName, createdTaskListName.getText().trim());

    }
    public void clickOnNavigationButtons(String navigationButton) {
        WebElement navigationButtons= Driver.getDriver().findElement(By.xpath("//span[@title='"+navigationButton+"']"));
        navigationButtons.click();
    }
    public void selectCreatedTaskList(String taskListName) {

        List<WebElement> selectCreatedTaskLists=Driver.getDriver().findElements(By.xpath("//li/a/div/div"));
        for (WebElement each : selectCreatedTaskLists) {
            if (each.getText().trim().equals(taskListName)) {
                each.click();
            }
        }

    }

}
