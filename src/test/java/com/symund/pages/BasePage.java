package com.symund.pages;
import com.symund.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='logo logo-icon']")
    public  WebElement logoIcon;


    /**This method click menu elements into navigation menu
     * @param text
     */
    public void clickMenuByText(String text){
     WebElement menuElement= Driver.getDriver().findElement
             (By.xpath("(//li[@data-id='"+text.toLowerCase()+"'])[1]"));
     menuElement.click();
    }
    public void logoClick(){
    logoIcon.click();
    }



    }

