package com.symund.pages;
import com.symund.utilities.BrowserUtils;
import com.symund.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.List;

public class ContactsPage extends BasePage {

    @FindBy(xpath = "//button[@id='new-contact-button'][contains(.,'New contact')]")
    public WebElement newContactsButton;

    @FindBy(xpath = "//*[contains(@placeholder,'Name') and @type='text']")
    public WebElement fullNameField;

    @FindBy(xpath = "//span[@title='All contacts'][contains(.,'All contacts')]")
    public WebElement allContactsButton;

    @FindBy(xpath = "//div[contains(@class,'app-content-list-item-line-one')]")
    public List<WebElement> allContacts;

    @FindBy(xpath = "//*[@id='app-content-wrapper']/div[2]/header/div[1]/div/div[2]/div/div/button")
    public WebElement dropdownButton;

    @FindBy(xpath = "//div[contains(@class, 'modal') or contains(@id, 'picker')]//tr[.//span[text()='Talk'] or @data-entryname='Talk']")
    public WebElement talkFileButton;

    @FindBy(xpath = "//button[text()='Choose']")
    public WebElement chooseButton;

    @FindBy(xpath = "//span[@class='action-button__text'][contains(.,'Choose from Files')]")
    public WebElement chooseFromFilesButton;

    @FindBy(xpath = "//div[@class='action-item header-menu']//button")
    public WebElement threeDotButton;

    @FindBy(xpath = "//div[@class='popover__inner']//span[text()='Delete']")
    public WebElement deleteContactButton;

    /**
     * fills in the required fields, and waits briefly between actions.
     * @param fullName the full name of the contact to create
     */
    public void createContact(String fullName) {

        fullNameField.sendKeys(fullName);
        BrowserUtils.waitForPresenceOfElement(By.xpath("//div[contains(@id,'fmNvbnRhY3')]/div[@class='app-content-list-item-line-one'][contains(.,'" + fullName + "')]"), 15);

    }

    /**
     * Checks whether a contact with the specified full name is visible in the contact list.
     * @param fullName the full name of the contact to check
     * @return true if the contact element is displayed, false if not found or not visible
     */
    public boolean isContactVisible(String fullName) {
        try {
            WebElement contactElement = Driver.getDriver().findElement(
                    By.xpath("//div[contains(@id,'fmNvbnRhY3')]/div[@class='app-content-list-item-line-one'][contains(.,'" + fullName + "')]")
            );
            return contactElement.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * This method iterates through the list of contacts and prints their names.
     */
    public void printAllContacts() {
        System.out.println("All contacts: ");
        for (WebElement each : allContacts) {
            System.out.println(each.getText());
        }
    }

    /**
     * Retrieves the names of all contacts.
     * @return a list of strings, each representing the full name of a contact
     */
    public List<String> getAllContactsName() {
        List<String> contactNames = new ArrayList<>();
        for (WebElement element : allContacts) {
            contactNames.add(element.getText());
        }
        return contactNames;
    }

    /**
     * Determines whether a contact with the specified full name exists in the contact list.
     * @param contactName the full name of the contact to check for existence
     * @return true if the contact exists; false otherwise
     */
    public boolean isContactFullNameExist(String contactName) {

        if (getAllContactsName().contains(contactName)) {

            return true;
        }
        return false;
    }

    /**
     * This method iterates through the list of contacts and clicks on the first contact
     * that matches the provided full name.
     */
    public void clickAContactPerson(String fullName) {
        for (WebElement each : allContacts) {
            if (each.getText().equals(fullName)) {
                each.click();
                break;
            }

        }
    }

    /**
     * Retrieves the total count of contacts.
     * @return the number of contacts available in the list
     */
    public int getContactCount() {
        BrowserUtils.waitFor(1);
        return allContacts.size();
    }

}
