package com.symund.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.symund.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


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

    @FindBy(xpath = "//a[@class='button new']")
    public WebElement addButton;

    @FindBy(xpath = "//input[@type='file']")
    public WebElement uploadFile;

    @FindBy(xpath = "//tr//span[@class='innernametext']")
    public List<WebElement> allFilesAndFolderNames;

    @FindBy(xpath = "//tbody[@id='fileList'][1]//tr[3]/td[2]//span[@class='icon icon-more']")
    public WebElement threDotForDeletingElement;

    @FindBy(xpath = "//a[@data-action='Delete']")
    public WebElement clickOnDeletFile;

    @FindBy(xpath = "//div[@class='newFileMenu popovermenu bubble menu open menu-left']//li[2]")
    public WebElement newFolderlink;
//   @FindBy(xpath = "//tbody[@id='fileList'][1]//tr//a[@class='action action-menu permanent']")
//   public List<WebElement> threeDotForAllFileAndFolder;



}
