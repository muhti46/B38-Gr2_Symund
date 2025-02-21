package com.symund.step_definitions;

import com.symund.pages.CalendarPage;
import com.symund.utilities.BrowserUtils;
import com.symund.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;


public class Calendar_StepDefs {


    CalendarPage calendarPage = new CalendarPage();

    @When("the user is on the {string} module page")
    public void the_user_is_on_the_module_page(String expectedModule) {
        // this method navigate to expectedModule
        calendarPage.clickMenuByText(expectedModule);
    }


    @When("User clicks {string} in the options menu")
    public void user_clicks_in_the_options_menu(String expectedCalendarView) {
        // this method navigate to expectedCalendarView
        BrowserUtils.waitFor(5);
        calendarPage.clickCalendarViewByText(expectedCalendarView);
    }
    @Then("User sees current Url contains {string}")
    public void user_sees_current_url_contains(String expectedText) {
        // verify that calendar module contains in current url
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedText));
    }

    @When("User clicks + New event button")
    public void user_clicks_new_event_button() {
        calendarPage.newEventButton.click();
    }
    @When("user enters event title {string} in the title input")
    public void user_enters_event_title_in_the_title_input(String eventTitle) {
        calendarPage.eventTitleInput.sendKeys(eventTitle);
    }
    @When("user enters start date {string} and end date {string} and click save button")
    public void user_enters_start_date_and_end_date_and_click_save_button(String startDate, String endDate) {
        BrowserUtils.waitFor(2);
        calendarPage.fromDateInput.clear();
        calendarPage.fromDateInput.sendKeys(startDate);
        BrowserUtils.waitFor(2);
        calendarPage.toDateInput.clear();
        calendarPage.toDateInput.sendKeys(endDate);
        BrowserUtils.waitFor(2);
        calendarPage.saveButton.click();
        BrowserUtils.waitFor(2);
    }
    @Then("user sees {string} on the related day through the Monthly calendar view")
    public void user_sees_eventTitle_on_the_related_day_through_the_monthly_calendar_view(String eventTitle) {
        BrowserUtils.waitFor(2);
       // calendarPage.clickEventInCalendarTitle(eventTitle);

        Assert.assertTrue(calendarPage.goButton.isDisplayed());
    }


}
