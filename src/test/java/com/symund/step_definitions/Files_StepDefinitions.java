package com.symund.step_definitions;


import com.symund.pages.BasePage;
import com.symund.pages.FilesPage;
import com.symund.utilities.BrowserUtils;

import com.symund.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;





public class Files_StepDefinitions {
    LoginStepDefs loginStepDefs = new LoginStepDefs();
    FilesPage filesPage = new FilesPage();
    BasePage basePage = new BasePage() {
    };

    @Given("user is on the login page")
    public void userIsOnTheLoginPage() {
        loginStepDefs.loginPage.login("Employee52", "Employee123");

    }

    @Given("the user clicks {string} menu")
    public void the_user_clicks_menu(String string) {
        basePage.clickMenuByText(string);
    }

    @Given("user is on the Files page")
    public void user_is_on_the_files_page() {
        BrowserUtils.sleep(5);
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Files"));
        BrowserUtils.sleep(5);
    }

    @Then("user is able to click on + icon")
    public void userIsAbleToClickOnIcon() {
        filesPage.addButton.click();
    }

    @When("user is on the File page muss be able to upload a file")
    public void user_is_on_the_file_page_muss_be_able_to_upload_a_file() {
        BrowserUtils.sleep(10);
        //String path = "C:\\Users\\User\\OneDrive\\Desktop\\some-file.txt";
        filesPage.uploadFile.sendKeys("C:\\Users\\User\\OneDrive\\Desktop\\some-file.txt");

        // filesPage.uploadFile.click();
        System.out.println("Driver.getDriver().getTitle() = " + Driver.getDriver().getTitle());

    }

    @Then("user is able to see upload file in Files page")
    public void user_is_able_to_see_upload_file_in_files_page() {
        //  String path = "C:\\Users\\User\\OneDrive\\Desktop\\some-file.txt";
        BrowserUtils.sleep(5);
         //Assert.assertTrue(filesPage.lastUploadFile.isDisplayed());
    }


}