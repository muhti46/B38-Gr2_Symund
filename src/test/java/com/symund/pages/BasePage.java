package com.symund.pages;
import com.symund.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    /**
     * Navigates to given module page on the App     *
     * @param moduleName String
     */
    public void clickMenuByText(String moduleName){
     WebElement menuElement= Driver.getDriver().findElement(By.xpath("(//li[@data-id='"+moduleName.toLowerCase()+"'])[1]"));
     menuElement.click();
    }
    }

