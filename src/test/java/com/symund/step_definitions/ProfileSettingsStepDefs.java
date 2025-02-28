package com.symund.step_definitions;


import com.symund.pages.ProfileSettingsPage;
import com.symund.utilities.BrowserUtils;
import com.symund.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProfileSettingsStepDefs {

    // navigate to the menubar on the right corner method
    @And("User clicks Profile Settings on the right corner of website")
    public void user_clicks_profile_settings_on_the_right_corner_of_website() {
        WebElement profileSettings = Driver.getDriver().findElement(By.id("expand"));
        profileSettings.click();
    }

    //clicking settings button on menubar method
    @And("User clicks Settings")
    public void user_clicks_settings() {
        Driver.getDriver().findElement(By.xpath("//nav[@class='settings-menu menu']//ul//li[2]")).click();

    }


    ProfileSettingsPage profileSettingsPage = new ProfileSettingsPage();

    //checking if actual value is equal to expected value method
    @Then("User sees Full name\\/Email\\/Phone Number titles inside Personal Info")
    public void user_sees_full_name_email_phone_number_titles_inside_personal_info() {

        String actualFullNameHeader = profileSettingsPage.profileName.getText();
        String actualEmailHeader = profileSettingsPage.profileEmail.getText();
        String actualPhoneNumberHeader = profileSettingsPage.phoneNumber.getText();

        assertEquals(actualFullNameHeader, "Full name");
        assertEquals(actualEmailHeader, "Email");
        assertEquals(actualPhoneNumberHeader, "Phone Number");
    }

    //checking if both given values are equal
    @Then("User sees in the Settings field the same name as in Full name input box")
    public void userSeesInTheSettingsFieldTheSameNameAsInFullNameInputBox() {
        String actualFullNameHeader = profileSettingsPage.userItemHeader.getText();
        String inputBoxDisplay = profileSettingsPage.inputBoxDisplayName.getText();

        assertEquals(actualFullNameHeader, inputBoxDisplay);
    }



    @And("User clicks selects private on the button next to the Phone number")
    public void userClicksSelectsPrivateOnTheButtonNextToThePhoneNumber() {
        List<WebElement> element = Driver.getDriver().findElements(By.className("federation-menu"));
        element.get(3).click();
        //BrowserUtils.sleep(3);
        profileSettingsPage.selectPrivate.click();

        //BrowserUtils.sleep(3);

//     try {
//            BrowserUtils.sleep(3);
//            Alert alert = Driver.getDriver().switchTo().alert();
//            String text = alert.getText();
//            System.out.println(text);
//            assertEquals(text, "This action requires you to confirm your password");
//            alert.sendKeys("Employee123");
//            alert.accept();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        String alertMessage = Driver.getDriver().switchTo().alert().getText();
//        System.out.println(alertMessage);


    }


    @Then("User type only {string}into the Phone Number input box")
    public void userTypeOnlyIntoThePhoneNumberInputBox(String phoneNumber) {
        profileSettingsPage.inputBoxPhoneNumber.clear();

        profileSettingsPage.inputBoxPhoneNumber.sendKeys(phoneNumber);

        BrowserUtils.sleep(3);
        Assert.assertEquals(profileSettingsPage.inputBoxPhoneNumber.isDisplayed(), true);
        Assert.assertNotEquals(profileSettingsPage.inputBoxPhoneNumber.getAttribute("value"), phoneNumber);

    }


}
