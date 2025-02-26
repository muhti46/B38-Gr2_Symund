package com.symund.step_definitions;
import com.symund.pages.ContactsPage;
import com.symund.utilities.BrowserUtils;
import com.symund.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
public class ContactsStepDefs {

    ContactsPage contactsPage = new ContactsPage();

    @When("The user clicks on the New contacts button")
    public void the_user_clicks_on_the_button() {
        BrowserUtils.waitForClickablility(contactsPage.newContactsButton, 5);
        contactsPage.newContactsButton.click();
        BrowserUtils.waitForClickablility(contactsPage.newContactsAvatar, 5);
        contactsPage.newContactsAvatar.click();
        BrowserUtils.waitForClickablility(contactsPage.fullNameField, 5);
        contactsPage.fullNameField.click();

    }

    @And("the user creates a new contact as name {string} as Phone number {string} and email {string}")
    public void theUserCreatesANewContactAsNameAsPhoneNumberAndEmail(String fullName, String phoneNumber, String email) {
        contactsPage.createContact(fullName, phoneNumber, email);
        contactsPage.clickAContactPerson(fullName);
        BrowserUtils.waitFor(2);

    }

    @Then("the contact {string} should appear in the contacts list")
    public void theContactShouldAppearInTheContactsList(String fullName) {

        BrowserUtils.waitForClickablility(contactsPage.allContactsButton, 5);
        contactsPage.allContactsButton.click();

        BrowserUtils.waitForVisibility(By.xpath("//div[contains(@id,'fmNvbnRhY3')]/div[@class='app-content-list-item-line-one'][contains(.,'" + fullName + "')]"), 15);
        Assert.assertTrue(contactsPage.isContactVisible(fullName));

        contactsPage.clickAContactPerson(fullName);

        contactsPage.printAllContacts(fullName);
    }

    @Given("there are {int} existing contacts")
    public void thereAreExistingContacts(int expectedContactCount) {
        BrowserUtils.waitForClickablility(contactsPage.allContactsButton, 5);
        contactsPage.allContactsButton.click();

        BrowserUtils.waitFor(2);

        int actualCount = contactsPage.getContactCount();
        System.out.println("Expected contacts: " + expectedContactCount);
        System.out.println("Actual contacts: " + actualCount);

        Assert.assertEquals("Contact count doesn't match", expectedContactCount, actualCount);
    }

    @When("the user clicks on the All contacts tab")
    public void theUserClicksOnTheTab() {

        contactsPage.allContactsButton.click();
        BrowserUtils.waitForClickablility(contactsPage.allContactsButton, 5);

    }

    @Then("all contacts should be listed:")
    public void allShouldBeListed(List<String> expectedNames) {
        List<String> actualContactNames = new ArrayList<>();
        for (WebElement contact : contactsPage.allContacts) {
            actualContactNames.add(contact.getText());
        }

        for (String expectedName : expectedNames) {
            Assert.assertTrue("Contact '" + expectedName + "' is not displayed in the list",
                    actualContactNames.contains(expectedName));
        }
    }

    @And("all the contact's should appear in the in the middle column:")
    public void allTheContactSShouldAppearInTheInTheMiddleColumn(List<String> expectedContacts) {
        BrowserUtils.waitFor(2);

        List<String> visibleContacts = new ArrayList<>();
        for (WebElement visiblecontact : contactsPage.allContacts) {
            if (visiblecontact.isDisplayed()) {
                visibleContacts.add(visiblecontact.getText());
            }
        }

        for (String expectedcontact : expectedContacts) {
            Assert.assertTrue("Contact '" + expectedcontact + "' is not visible in the middle column",
                    visibleContacts.contains(expectedcontact));
        }
        System.out.println("All Contacts:");
        for (WebElement contact : contactsPage.allContacts) {
            System.out.println(contact.getText());
        }
    }

    @And("the All contacts tab should display {int} total contacts")
    public void theTabShouldDisplayTotalContacts(int totalContacts) {
        BrowserUtils.waitFor(2); // Wait for all contacts to load
        int actualCount = contactsPage.getContactCount();
        Assert.assertEquals("Total contact count doesn't match", totalContacts, actualCount);
    }

    @Given("the contact {string} exists in the All contacts list")
    public void theContactExistsInTheList(String contactName) {
        contactsPage.isContactFullNameExist(contactName);
    }

    @When("the user clicks {string} profile and clicks on Choose from Files option for profile picture")
    public void theUserClicksProfileAndClicksOnOptionForProfilePicture(String contactName) {
        contactsPage.clickAContactPerson(contactName);

        BrowserUtils.waitForClickablility(contactsPage.dropdownButton, 10);
        BrowserUtils.clickWithJS(contactsPage.dropdownButton);

        BrowserUtils.waitForClickablility(contactsPage.chooseFromFilesButton, 30);
        BrowserUtils.clickWithJS(contactsPage.chooseFromFilesButton);

    }

    @Then("the user clicks Talk file and choose {string}")
    public void theUserClicksTalkFileAndChoose(String imageName) {
        String mainWindow = Driver.getDriver().getWindowHandle();
        Set<String> allWindows = Driver.getDriver().getWindowHandles();

        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(mainWindow)) {
                Driver.getDriver().switchTo().window(windowHandle);
                break;
            }
        }
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.waitForClickablility(contactsPage.talkFileButton, 30);
        BrowserUtils.clickWithJS(contactsPage.talkFileButton);
        BrowserUtils.waitForPageToLoad(10);

        WebElement pickAnAvatar = Driver.getDriver().findElement(By.xpath("//tr[@data-entryname='" + imageName + "']/td[@class='filename']"));
        BrowserUtils.waitForClickablility(pickAnAvatar, 20);
        BrowserUtils.clickWithJS(pickAnAvatar);

    }

    @And("the user clicks clicks on Choose button")
    public void theUserClicksClicksOnButton() {
        BrowserUtils.waitForClickablility(contactsPage.chooseButton, 20);
        contactsPage.chooseButton.click();
    }

    @Then("the profile picture for {string} should be updated")
    public void theProfilePictureForShouldBeUpdated(String contactName) {
        BrowserUtils.waitForPageToLoad(10);
        WebElement profilePicture = Driver.getDriver().findElement(
                By.xpath("//div[@class= 'app-content-list-item-line-one'][contains(.,'" + contactName + "')]/preceding-sibling::div/img"));

        Assert.assertTrue("The profile picture has not been uploaded.", profilePicture.isDisplayed());
    }

}

