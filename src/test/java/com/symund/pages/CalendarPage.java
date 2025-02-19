package com.symund.pages;

import com.symund.utilities.BrowserUtils;
import com.symund.utilities.Driver;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalendarPage extends BasePage{

    @FindBy(xpath = "//button[@aria-controls='menu-knfah']")
    public WebElement menuOption;


    public void clickCalendarViewByText(String text){

        Driver.getDriver().findElement
                (By.xpath("//button[@class='icon action-item__menutoggle icon-view-module']")).click();
        Driver.getDriver().findElement
                (By.xpath("//span[.='"+text+"']")).click();
    }
}
