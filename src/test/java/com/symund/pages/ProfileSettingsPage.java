package com.symund.pages;

import com.symund.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfileSettingsPage {

    public ProfileSettingsPage() {
        PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(xpath="//h3//label[.='Full name']")
    public WebElement profileName;

    @FindBy(xpath="//h3//label[.='Phone number']")
    public WebElement phoneNumber;

    @FindBy(xpath="//h3//label[.='Email']")
    public WebElement profileEmail;

    @FindBy(xpath="//span[@class='user-status-menu-item__header']")
    public WebElement userItemHeader;

    @FindBy(id="displayname")
    public WebElement inputBoxDisplayName;

    @FindBy(id="phone")
    public WebElement inputBoxPhoneNumber;

//    @FindBy(xpath="//div[@class='toastify on dialogs error toastify-right toastify-top'][1]")
//    public WebElement invalidBoxPopUp;

    @FindBy(xpath="//div[@class='federation-menu']//div[@class='federationScopeMenu popovermenu bubble menu menu-center']//ul//li[1]")
    public WebElement selectPrivate;

//    @FindBy(className="primary")
//    public WebElement authenticationRequiredBoxButton;

//    @FindBy(xpath="//div[text()='Unable to set invalid phone number'][1]")
//    public WebElement invalidPhoneNumberPopUp;
}
