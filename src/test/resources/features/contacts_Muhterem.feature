@US003_contacts
Feature: US-003 Contacts Module Functionality
  As a user, I should be able to create a new contact, view all contacts,
  edit the profile picture, and delete any contact in the Contacts module.

  Background:User is already in the log in page
    Given the user is on the login page
    When the user logged in with username as "Employee82" and password as "Employee123"
    And the user clicks "Contacts" menu

  Scenario Outline: Create a new contact
    When The user clicks on the New contacts button
    And the user creates a new contact as name "<fullName>" as Phone number "<phone>" and email "<email>"
    Then the contact "<fullName>" should appear in the contacts list

    Examples:
      | fullName   | phone    | email               |
      | Harry Kane | 555-1234 | harry.kane@test.com |
      | Adam Smith | 555-2345 | adam.smith@test.com |
      | John Doe   | 555-3456 | john.doe@test.com   |
      | Mike Braun | 555-4567 | mike.braun@test.com |

  Scenario: Verify contacts list and count
    Given there are 4 existing contacts
    When the user clicks on the All contacts tab
    Then all contacts should be listed:
      | Ali   |
      | Belly |
      | Kerry |
      | Veli  |

    And all the contact's should appear in the in the middle column:
      | Ali   |
      | Belly |
      | Kerry |
      | Veli  |

    And the All contacts tab should display 4 total contacts

  @edit-contact-picture
  Scenario: Change contact profile picture
    Given the contact "Veli" exists in the All contacts list
    When the user clicks "Veli" profile and clicks on Choose from Files option for profile picture
    Then the user clicks Talk file and choose "profile.jpg"
    And the user clicks clicks on Choose button
    Then the profile picture for "Veli" should be updated




