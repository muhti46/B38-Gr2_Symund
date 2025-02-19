package com.symund.pages;
import com.symund.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void clickMenuByText(String text){
     WebElement menuElement= Driver.getDriver().findElement
             (By.xpath("(//li[@data-id='"+text.toLowerCase()+"'])[1]"));
     menuElement.click();
    }
    }

