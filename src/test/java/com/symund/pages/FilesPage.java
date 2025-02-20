package com.symund.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FilesPage extends BasePage {

    @FindBy(xpath = "//label[@for='select_all_files']")
    public WebElement selectAllCheckbox;

    @FindBy(xpath = "//input[contains(@id,'select-files')]")
    public List<WebElement> allCheckBoxes;

    @FindBy(xpath = "(//div[@id='headerName-container']//span)[1]")
    public WebElement totalNumberOfFoldersFiles;

    @FindBy(xpath = "//tr[@data-type='file']")
    public List<WebElement> files;

    @FindBy(xpath = "//tr[@data-type='dir']")
    public List<WebElement> folders;

}
