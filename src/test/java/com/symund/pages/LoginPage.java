package com.symund.pages;


import com.symund.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id="user")
    public WebElement userName;

    @FindBy(id="password")
    public WebElement password;

    @FindBy(id = "submit-form")
    public WebElement submit;

    /**
     * Logins with valid credentials as username and password
     *
     * @param userNameStr
     * @param passwordStr
     */
    public void login(String userNameStr, String passwordStr) {
        userName.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
        submit.click();
    }

}
