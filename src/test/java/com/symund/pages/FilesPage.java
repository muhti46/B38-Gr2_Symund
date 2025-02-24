package com.symund.pages;

import com.symund.utilities.BrowserUtils;
import com.symund.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
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

    @FindBy(xpath = "(//input[@type='text'])[2]")
    public WebElement provideTheNameForFolder;

    @FindBy(xpath = "//input[@class='icon-confirm']")
    public WebElement sendTheNameFonCreateFolder;

    @FindBy(xpath = "//span[@class='info']")
    public WebElement totalNumberOfFileAndFolder;

public void seeAllFilesAndFolderNames(String nameOfFolder){
    List<String> allNames= BrowserUtils.getElementsText(allFilesAndFolderNames);
    for (String allName : allNames) {
        if (allName.contains(nameOfFolder)){
            Assert.assertTrue(allNames.contains(nameOfFolder));
        }
    }
}

public void selectAnyFolderOrFileAndClikOnDot(String nameOfFileOrFolderWhichYouWantToDelet){
 WebElement allFileAndFolder  =Driver.getDriver().findElement
         (By.xpath("//tr//span[contains(text(),'"+nameOfFileOrFolderWhichYouWantToDelet+"')]/../..//span[@class='icon icon-more']"));
 allFileAndFolder.click();
}

public void totalNumberOfFile(){
   String allFilesAndFolderName = totalNumberOfFileAndFolder.getText();
    String numberOfFile= allFilesAndFolderName.substring(allFilesAndFolderName.lastIndexOf("d")+1, allFilesAndFolderName.lastIndexOf("e")+1);
    System.out.println("numberOdFiles = " + numberOfFile);
}


public void totalNumberOfFolders(){
    String allFilesAndFolderName =totalNumberOfFileAndFolder.getText();
    String numberOfFolder= allFilesAndFolderName.substring(0, allFilesAndFolderName.indexOf("s")+1);
    System.out.println("numberOfFolder = " + numberOfFolder);
}




}




