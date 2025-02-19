package com.symund.pages;

import com.symund.utilities.Driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilesPage {

    public FilesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

//    @FindBy(xpath = "//a[@aria-label='Files']")
//    public WebElement FilesButton;

//    @FindBy(xpath = "//span[@class='icon icon-add']")
//public WebElement addButton;

    @FindBy(xpath = "//a[@class='button new']")
    public WebElement addButton;

    //@FindBy(xpath = "//div[@class='newFileMenu popovermenu bubble menu open menu-left']/ul/li[1]")
   //@FindBy(xpath = "//label[@for='file_upload_start']")
    @FindBy(xpath = "//li/label[@data-action='upload']")
    public WebElement uploadFile;


   @FindBy(xpath = "//span[.='some-file']")
   public WebElement lastUploadFile;

//    public void addButtonClick(){
//        addButton.click();
//    }



}
