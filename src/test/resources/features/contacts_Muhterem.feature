@US003_contacts
Feature: US-003 Contacts Module Functionality
  As a user, I should be able to create a new contact, view all contacts,
  edit the profile picture, and delete any contact in the Contacts module.

  Background:User is already in the log in page
    Given the user is on the login page
    When the user logged in with username as "Employee82" and password as "Employee123"
    And the user clicks "Contacts" menu

  Scenario: Create a new contact
    When The user clicks on the New contacts button
    And the user creates a new contact as name "Harry Kane"
    Then the contact "Harry Kane" should appear in the contacts list

  Scenario: Verify contacts list and count
    Given there are 1 existing contact
    When the user clicks on the All contacts tab
    Then "Harry Kane" should be listed:
    And "Harry Kane" should appear in the in the middle column:
    And the All contacts tab should display 1 total contacts

  Scenario: Change contact profile picture
    Given the contact "Harry Kane" exists in the All contacts list
    When the user clicks "Harry Kane" profile and clicks on Choose from Files option for profile picture
    Then the user clicks Talk file and choose "images.jpg"
    And the user clicks clicks on Choose button
    Then the profile picture for "Harry Kane" should be updated

  Scenario: Delete a contact
    Given the contact "Harry Kane" exists in the All contacts list
    When the user clicks "Harry Kane" contact
    Then the user clicks three dot sign sees Delete option
    Then the user clicks Delete option
    Then the contact "Harry Kane" should be removed from the list


