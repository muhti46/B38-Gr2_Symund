package com.symund.step_definitions;

import com.symund.pages.FilesPage;
import com.symund.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FolderViewStepDefs {

    FilesPage filesPage = new FilesPage();

    @When("user clicks on the select all checkbox")
    public void user_clicks_on_the_select_all_checkbox() {
        BrowserUtils.waitFor(2);
        filesPage.selectAllCheckbox.click();
    }

    @Then("verify user should see total numbers of files-folders as expected")
    public void verify_user_should_see_total_numbers_of_files_folders_as_expected() {
        // 3 folder and 3 file
        String totalNumbers = filesPage.totalNumberOfFoldersFiles.getText();
        System.out.println("totalNumbers = " + totalNumbers);

        // actual number values => I get from the string on UI which appeared above the list of folders/files
        String actualNumberOfFolders = totalNumbers.substring(0,totalNumbers.indexOf(" "));
        System.out.println("actualNumberOfFolders = " + actualNumberOfFolders);

        int emptySpaceBeforeFilesNumber = totalNumbers.indexOf(" ", totalNumbers.indexOf("and"));
        String actualNumberOfFiles = totalNumbers.substring(emptySpaceBeforeFilesNumber+1, totalNumbers.lastIndexOf(" "));
        System.out.println("actualNumberOfFiles = " + actualNumberOfFiles);

        // expected number values => I get from the HTML structure of Files page according to web elements' attribute
        //   data-type = dir  => it is a folder on the UI
        //   data-type = file => it is a file on the UI
        int expectedNumberOfFolders = filesPage.folders.size();
        System.out.println("expectedNumberOfFolders = " + expectedNumberOfFolders);
        int expectedNumberOfFiles = filesPage.files.size();
        System.out.println("expectedNumberOfFiles = " + expectedNumberOfFiles);

        Assert.assertEquals(Integer.parseInt(actualNumberOfFolders), expectedNumberOfFolders);
        Assert.assertEquals(Integer.parseInt(actualNumberOfFiles), expectedNumberOfFiles);

    }

}
