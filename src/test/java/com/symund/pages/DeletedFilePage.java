package com.symund.pages;

import com.symund.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DeletedFilePage extends BasePage {

    public DeletedFilePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Deleted files locator
    @FindBy(xpath = "//a[.= 'Deleted files']")
    public WebElement deletedFiles;

    // "Deleted" column header
    @FindBy(xpath = "//a[@id='modified']/span[. = 'Deleted']")
    public WebElement deletedColumnHeader;

    // Sorting arrow
    @FindBy(xpath = "//a[@id='modified']/span[. = 'Deleted']/following-sibling::span")
    public WebElement sortingArrow;

    // Deleted file name locator
    @FindBy(xpath = "(//span[@class= 'nametext extra-data'])[1]")
    public WebElement fileName;

    // Three dots icon -first
    @FindBy(xpath = "(//a[@data-action='menu'])[2]")
    public WebElement threeDotsIcon;

    // Delete permanently
    @FindBy(xpath = "//a[@data-action = 'Delete']")
    public WebElement deletePermanently;

    @FindBy(xpath = "(//a[@data-action = 'Restore'])[1]")
    public WebElement restoreBtn;

    @FindBy(xpath = "//*[@id=\"app-navigation\"]/ul/li[1]")
    public WebElement allFilesTab;

    public boolean isFilePresent(String fileName) {
        // Locate all file elements in the list
        List<WebElement> allFiles = Driver.getDriver().findElements(By.xpath("//span[@class='nametext']"));

        // Loop through each file name and check if it matches the restored file
        for (WebElement file : allFiles) {
            if (file.getText().trim().equalsIgnoreCase(fileName.trim())) {
                return true; // File found
            }
        }
        return false; // File not found
    }


}