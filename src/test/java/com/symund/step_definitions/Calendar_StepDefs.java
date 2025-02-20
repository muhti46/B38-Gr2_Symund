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

    @When("the user is on the {string} module page")
    public void the_user_is_on_the_module_page(String expectedModule) {
        // this method navigate to expectedModule
        loginPage.clickMenuByText(expectedModule);
    }
    @When("User clicks {string} in the options menu")
    public void user_clicks_in_the_options_menu(String expectedCalendarView) {
        // this method navigate to expectedCalendarView
        calendarPage.clickCalendarViewByText(expectedCalendarView);
    }
    @Then("User sees current Url contains {string}")
    public void user_sees_current_url_contains(String expectedText) {
        // verify that calendar module contains in current url
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedText));
    }

}
