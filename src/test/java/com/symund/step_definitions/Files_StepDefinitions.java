package com.symund.step_definitions;

import com.symund.pages.FilesPage;
import com.symund.pages.LoginPage;
import com.symund.utilities.BrowserUtils;

import com.symund.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import java.util.List;


public class Files_StepDefinitions {
    FilesPage filesPage = new FilesPage();
    LoginPage loginPage = new LoginPage();


    @Given("user is on the login page")
    public void userIsOnTheLoginPage() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("https://qa.symund.com/"));
    }

    @Then("the user is able to login username as {string} and password as {string}")
    public void theUserIsAbleToLoginUsernameAsAndPasswordAs(String username, String password) {
        loginPage.login(username, password);
    }


    @Given("the user clicks {string} menu")
    public void the_user_clicks_menu(String string) {
        filesPage.clickMenuByText(string);
    }


    @Given("user is on the Files page")
    public void user_is_on_the_files_page() {
        BrowserUtils.sleep(5);
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Files"));
    }

    @Then("user is able to click on + icon")
    public void userIsAbleToClickOnIcon() {
        filesPage.addButton.click();
    }

    String expectedFileName;
    @When("user is on the File page muss be able to upload a file")
    public void user_is_on_the_file_page_muss_be_able_to_upload_a_file() {
        BrowserUtils.sleep(4);
        // String filePath = "C:\\Users\\User\\IdeaProjects\\B38-Gr2_Symund\\src\\test\\resources\\data\\file.txt";
        //                    C:\Users\User\IdeaProjects\B38-Gr2_Symund
        //                                   \\IdeaProjects\B38-Gr2_Symund\src\test\resources\data\file.txt

        String basePath = System.getProperty("user.dir");
        String commonPath = "\\src\\test\\resources\\data\\file.txt";

        String filePath = basePath + commonPath;
        System.out.println("filePath = " + filePath);
        // C:\Users\User\IdeaProjects\B38-Gr2_Symund\src\test\resources\data\file.txt
        filesPage.uploadFile.sendKeys(filePath);

        
        expectedFileName= filePath.substring(filePath.lastIndexOf("\\"), filePath.lastIndexOf("."));
        System.out.println("expectedFileName = " + expectedFileName);
    }

    @Then("user is able to see upload file in Files page")
    public void user_is_able_to_see_upload_file_in_files_page() {
   List<String> allNames= BrowserUtils.getElementsText(filesPage.allFilesAndFolderNames);
         Assert.assertTrue(allNames.contains(expectedFileName));
        BrowserUtils.sleep(5);


        //Deleting file which we have add
        filesPage.threDotForDeletingElement.click();

        filesPage.clickOnDeletFile.click();


    }


}