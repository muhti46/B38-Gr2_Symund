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

    @FindBy(xpath = "//div[@class='app-content-list-item-line-one'][contains(.,'New contact')]")
    public WebElement newContactsAvatar;

    @FindBy(xpath = "//h2/input[@id='contact-fullname' and @placeholder='Name']")
    public WebElement fullNameField;

    @FindBy(xpath = "//div[@class='property property--last property-tel']//input[@inputmode='tel']")
    public WebElement phoneNumberField;

    @FindBy(xpath = "//div[@class='property property--last property-email']//input[@inputmode='email']")
    public WebElement emailAddressField;

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

    /**
     * This method clears the full name field before entering the provided name,
     * fills in the required fields, clicks the new contacts avatar, and waits briefly between actions.
     *
     * @param fullName    the full name of the contact to create
     * @param phoneNumber the phone number of the contact
     * @param email       the email address of the contact
     */
    public void createContact(String fullName, String phoneNumber, String email) {
        fullNameField.clear();
        fullNameField.sendKeys(fullName);
        BrowserUtils.waitFor(2);
        newContactsAvatar.click();

        phoneNumberField.sendKeys(phoneNumber);
        BrowserUtils.waitFor(2);

        emailAddressField.sendKeys(email);
        BrowserUtils.waitFor(2);
    }

    /**
     * Checks whether a contact with the specified full name is visible in the contact list.
     *
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
     * If a contact's name matches the provided full name, it prints an additional message
     * to highlight that the contact was newly created.
     *
     * @param fullName the full name to highlight as the newly created contact
     */
    public void printAllContacts(String fullName) {
        for (WebElement element : allContacts) {
            if (element.getText().equals(fullName)) {
                System.out.println("New created person is " + element.getText());
            }
            System.out.println("All contacts are = " + element.getText());
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
     Determines whether a contact with the specified full name exists in the contact list.
     @param contactName the full name of the contact to check for existence
     @return true if the contact exists; false otherwise
     */
    public boolean isContactFullNameExist(String contactName) {

        if (getAllContactsName().contains(contactName)) {

            return true;
        }
        return false;
    }

    /**
     Clicks on a contact that matches the specified full name.
     This method iterates through the list of contacts and clicks on the first contact
     that matches the provided full name.
     @param fullName the full name of the contact to click
     */
    public void clickAContactPerson(String fullName) {
        for (WebElement each : allContacts) {
            if (each.getText().equals(fullName)) {
                each.click();
            }
        }
    }

    /**
     Retrieves the total count of contacts.
     @return the number of contacts available in the list
     */
    public int getContactCount() {
        BrowserUtils.waitFor(1);
        return allContacts.size();
    }

}
