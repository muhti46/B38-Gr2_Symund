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
        //                                                               \src\test\resources\data\file.txt
        String basePath = System.getProperty("user.dir");
        String commonPath = "\\src\\test\\resources\\data\\file.txt";

        String filePath = basePath + commonPath;
        System.out.println("filePath = " + filePath);
        // C:\Users\User\IdeaProjects\B38-Gr2_Symund\src\test\resources\data\file.txt
        filesPage.uploadFile.sendKeys(filePath);

        System.out.println("basePath = " + basePath);
        System.out.println("commonPath = " + commonPath);

        expectedFileName= filePath.substring(filePath.lastIndexOf("\\")+1,filePath.lastIndexOf("."));
        System.out.println("expectedFileName = " + expectedFileName);
    }

    @Then("user is able to see upload file in Files page")
    public void user_is_able_to_see_upload_file_in_files_page() {
   List<String> allNames= BrowserUtils.getElementsText(filesPage.allFilesAndFolderNames);
        for (String allName : allNames) {
            if (allName.contains(expectedFileName)){
                Assert.assertTrue(allNames.contains(expectedFileName));
            }
        }
        BrowserUtils.sleep(5);

        //Deleting file which we have add
        filesPage.threDotForDeletingElement.click();

        //click on delete File
        filesPage.clickOnDeletFile.click();

        BrowserUtils.sleep(5);
    }




    @When("user is able to click on New Folder")
    public void userIsAbleToClickOnNewFolder() {
        filesPage.newFolderlink.click();
    }

    String nameFolder= "Test1";

    @Then("user is able provide the name for folder")
    public void userIsAbleProvideTheNameForFolder() {
        filesPage.provideTheNameForFolder.sendKeys(nameFolder);
        filesPage.sendTheNameFonCreateFolder.click();
    }

    @Then("user is able to see name of folder in that page")
    public void userIsAbleToSeeNameOfFolderInThatPage() {
        List<String> allNames= BrowserUtils.getElementsText(filesPage.allFilesAndFolderNames);
        for (String allName : allNames) {
            if (allName.contains(nameFolder)){
                Assert.assertTrue(allNames.contains(nameFolder));
            }
        }
        filesPage.clickOnDeletFile.click();
        filesPage.selectFileOrFolderAndDeleting(nameFolder);
    }


    @When("user is able to click on three dots")
    public void userIsAbleToClickOnThreeDots() {

    }

    @Then("user is able to delete any item")
    public void userIsAbleToDeleteAnyItem() {

    }

    @Given("user is able to see total number of files")
    public void userIsAbleToSeeTotalNumberOfFiles() {
    }

    @Then("user is able to see total numer of folders")
    public void userIsAbleToSeeTotalNumerOfFolders() {
    }
}