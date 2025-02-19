package com.symund.step_definitions;

import com.symund.pages.CalendarPage;
import com.symund.pages.LoginPage;
import com.symund.utilities.ConfigurationReader;
import com.symund.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;


public class Calendar_StepDefs {

    LoginPage loginPage = new LoginPage();
    CalendarPage calendarPage = new CalendarPage();

    @Given("user is on the calendar page")
    public void user_is_on_the_calendar_page() {
        loginPage.login(ConfigurationReader.getProperty("username"),
                ConfigurationReader.getProperty("password"));

    }
    @When("User clicks options menu")
    public void user_clicks_options_menu() {
        calendarPage.clickMenuByText("calendar");
    }
    @When("User clicks {string} in the options menu")
    public void user_clicks_in_the_options_menu(String Day) {
        calendarPage.clickCalendarViewByText(Day);
    }


    @Then("User sees current Url contains {string}")
    public void user_sees_current_url_contains(String expectedText) {
        String currentUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(expectedText));
    }


    @When("User clicks + New event button")
    public void userClicksNewEventButton() {
    }

    @And("user creats event and saves it")
    public void userCreatsEventAndSavesIt() {
    }

    @Then("user sees it on the related day through the Monthly calendar view")
    public void userSeesItOnTheRelatedDayThroughTheMonthlyCalendarView() {
    }
}
