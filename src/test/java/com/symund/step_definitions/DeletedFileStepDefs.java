package com.symund.step_definitions;

import com.symund.pages.DeletedFilePage;
import com.symund.pages.LoginPage;
import com.symund.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DeletedFileStepDefs {

    LoginPage loginPage = new LoginPage();
    DeletedFilePage deletedFilePage = new DeletedFilePage();

    @Given("the user is logged into the application with the username {string} and password {string}")
    public void theUserIsOnTheLoginPage(String username, String password) {
        System.out.println("Step 1: Logging in with username: " + username);
        loginPage.login(username, password);
    }

    @And("the user is on the Files page")
    public void theUserIsOnTheFilesPage() {
        System.out.println("Step 2: Navigating to 'Files' page.");
        deletedFilePage.clickMenuByText("Files");
    }

    @When("the user navigates to the Deleted files tab")
    public void theUserNavigatesToTheDeletedFilesTab() {
        System.out.println("Step 3: Navigating to the 'Deleted files' tab.");
        deletedFilePage.deletedFiles.click();
    }

    @And("the user clicks on the Deleted column header to sort")
    public void theUserClicksOnTheDeletedColumnHeader() {
        System.out.println("Step 4: Clicking the 'Deleted' column header to sort.");
        deletedFilePage.sortingArrow.click();
    }

    @Then("the deleted files should be sorted from newest to oldest")
    public void theDeletedFilesShouldBeSortedFromNewestToOldest() {
        System.out.println("Step 5: Verifying that files are sorted from newest to oldest.");
        String arrowClass = deletedFilePage.sortingArrow.getAttribute("class");
        Assert.assertTrue("Sorting is incorrect! Expected descending order.", arrowClass.contains("icon-triangle-s"));
    }

    @Then("the deleted files should be sorted from oldest to newest")
    public void theDeletedFilesShouldBeSortedFromOldestToNewest() {
        System.out.println("Step 6: Verifying that files are sorted from oldest to newest.");
        deletedFilePage.sortingArrow.click();
        String arrowClass = deletedFilePage.sortingArrow.getAttribute("class");
        Assert.assertTrue("Sorting is incorrect! Expected ascending order.", arrowClass.contains("icon-triangle-n"));
    }

    @And("clicks the three dots icon next to the file")
    public void clicksTheThreeDotsIconNextToTheFile() {
        System.out.println("Step 7: Clicking the three dots icon next to the file.");
        System.out.println("File to delete: " + deletedFilePage.fileName.getText());
        deletedFilePage.threeDotsIcon.click();

    }

    @And("selects Permanently Delete and confirms")
    public void selectsAndConfirms() {
        System.out.println("Step 8: Selecting 'Delete permanently' and confirming.");
        deletedFilePage.deletePermanently.click();
    }

    @Then("the file should no longer appear in the Deleted Files section")
    public void theFileShouldNoLongerAppearInTheDeletedFilesSection() {
        System.out.println("Step 9: Verifying the file no longer appears in the 'Deleted files' section.");
        boolean isFileDeletedAfterRefresh = deletedFilePage.fileName.isDisplayed();
        Assert.assertTrue("File still exists after refresh!", isFileDeletedAfterRefresh);
    }

    String restoredFileName;

    @When("clicks Restore button")
    public void clicks_restore_button() {
        System.out.println("Step 10: Clicking 'Restore' button for the file.");
        restoredFileName = deletedFilePage.fileName.getText();
        System.out.println("Restoring file: " + restoredFileName);
        deletedFilePage.restoreBtn.click();
    }

    @When("the user navigates to All Files tab")
    public void the_user_navigates_to_all_files_tab() {
        System.out.println("Step 11: Navigating to the 'All files' tab.");
        deletedFilePage.allFilesTab.click();
    }

    @Then("verify the restored file is visible")
    public void verify_the_restored_file_is_visible() {
        System.out.println("Step 12: Verifying the restored file is visible under 'All files'.");
        Driver.getDriver().navigate().refresh();
        Assert.assertTrue("Restored file is not visible under 'All Files'!", deletedFilePage.isFilePresent(restoredFileName));
    }
}