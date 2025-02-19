package com.symund.step_definitions;


import com.symund.pages.FilesPage;
import com.symund.utilities.BrowserUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class Files_StepDefinitions {
    LoginStepDefs loginStepDefs = new LoginStepDefs();
    FilesPage filesPage = new FilesPage();

    @Given("user is on the login page")
    public void userIsOnTheLoginPage() {
        loginStepDefs.loginPage.login("Employee52", "Employee123");

    }

    @Given("user is on the Files page")
    public void user_is_on_the_files_page() {
        BrowserUtils.sleep(5);
        loginStepDefs.theUserClicksMenu("Files");
        BrowserUtils.sleep(5);
    }

    @When("user is on the File page muss be able to upload a file")
    public void user_is_on_the_file_page_muss_be_able_to_upload_a_file() {
        filesPage.addButton.click();
        // filesPage.uploadFile.click();
        BrowserUtils.sleep(5);
        //String path = "C:\\Users\\User\\OneDrive\\Desktop\\some-file.txt";
        String path = "C://Users//User//OneDrive//Desktop//some-file.txt";
       // filesPage.uploadFile.sendKeys("C:\\Users\\User\\OneDrive\\Desktop\\some-file.txt");
     filesPage.uploadFile.sendKeys(path);
        //   filesPage.clickUploadFile(path);
        // Select select = new Select(filesPage.allOptionsFromAddButton);
//        select.selectByVisibleText("Upload file");
//filesPage.addButton.sendKeys("Upload file"+ Keys.ENTER);
        BrowserUtils.sleep(5);
       // filesPage.uploadFile.click();

    }

    @Then("user is able to see upload file in Files page")
    public void user_is_able_to_see_upload_file_in_files_page() {
      //  String path = "C:\\Users\\User\\OneDrive\\Desktop\\some-file.txt";
        BrowserUtils.sleep(5);
   // Assert.assertTrue(filesPage.lastUploadFile.isDisplayed());
    }


}
