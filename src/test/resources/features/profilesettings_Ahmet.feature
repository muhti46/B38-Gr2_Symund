@B38G2-249_profileSettings
Feature: ProUser Story:
"""
  As a user, I should be able to change profile info settings under the Profile module.
  Acceptance Criteria:
  1. User can see at least following titles inside "Personal Info" under Profile Settings page;
  => Full name/Email/Phone Number
  2. Name of the user in the Settings field should be the same with Full Name input box
  3. User cannot pass any characters except numbers into the "Phone Number" input box.
  file Settings Functionality
"""

  Background: User logins and lands on the Dashboard Page
    Given the user is on the login page
    And the user logged in with username as "Employee22" and password as "Employee123"
    And User clicks Profile Settings on the right corner of website
    And User clicks Settings

  @JIRA-ID_profileSettings_AC01-TC01
  Scenario: Verify user see the following title:
  Full name/Email/Phone Number inside Personal Info under Profile Settings page
    Then User sees Full name/Email/Phone Number titles inside Personal Info

  @JIRA-ID_profileSettings_AC02-TC01
  Scenario: Name in the Settings field is the same with Full Name input box
    Then User sees in the Settings field the same name as in Full name input box

  @JIRA-ID_profileSettings_AC03-TC01
  Scenario Outline: User cannot pass any characters except numbers into the "Phone Number" input box.
  file Settings Functionality
    And User clicks selects private on the button next to the Phone number
    Then User type only "<numbers>"into the Phone Number input box
    Examples:
      | numbers |
     # | +4942314234255675  |
      #| +4942314267355687 |
      #| +4946514234255600  |
      | f4948714234255676 |
