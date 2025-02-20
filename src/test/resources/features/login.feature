@login
Feature: Users should be able to login

  Background: User is already in the log in page
    Given the user is on the login page


  Scenario: Verify login with different user types
    #Given the user logged in as "<userType>"
    When the user logged in with username as "Employee62" and password as "Employee123"
    Then the user is on the "notifications" module page






