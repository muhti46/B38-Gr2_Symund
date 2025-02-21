package com.symund.pages;

import com.symund.utilities.BrowserUtils;
import com.symund.utilities.Driver;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalendarPage extends BasePage{

    @FindBy(xpath = "//button[@class='icon action-item__menutoggle icon-view-module']")
    public WebElement menuOption;

    @FindBy(xpath = "//button[normalize-space(text())='+ New event']")
    public WebElement newEventButton;

    @FindBy(xpath = "//input[@placeholder='Event title']")
    public WebElement eventTitleInput;

    @FindBy(xpath = "(//input[@class='mx-input'])[2]")
    public WebElement fromDateInput;
    @FindBy(xpath = "(//input[@class='mx-input'])[3]")
    public WebElement toDateInput;
    @FindBy(xpath = "//button[normalize-space(text())='Save']")
    public WebElement saveButton;


    @FindBy(xpath = "(//div[.='Go GYM'])[1]")
    public WebElement goButton;





    /**
     * clicks given text in the calendar view options
     *
     * @param text
     *
     */
    public void clickCalendarViewByText(String text){

        Driver.getDriver().findElement
                (By.xpath("//button[@class='icon action-item__menutoggle icon-view-day']")).click();
        Driver.getDriver().findElement
                (By.xpath("//span[.='"+text+"']")).click();
    }
    /**
     * if given event title is displayed return true
     *
     * @param eventTitle
     *
     */

    public boolean clickEventInCalendarTitle(String eventTitle){

        Driver.getDriver().findElement
                (By.xpath(
                        "//div[.='" + eventTitle + "']")
                ).isDisplayed();

        return true;
    }

}
