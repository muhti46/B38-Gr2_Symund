
Feature: Calendar Module Functionality
  User Story:
  As a user, I should be able to see Daily-Weekly-Monthly view and create
  a new event under the Calendar module.

  Background:User is already in the log in page
    Given the user is on the login page
    When the user logged in with username as "Employee12" and password as "Employee123"
    And  the user is on the "calendar" module page

  @US005_calendar
  Scenario Outline: User can display calendar views


   # And  the user clicks "calendar" view menu
    And   User clicks "<option>" in the options menu
    Then  User sees current Url contains "<views>"

    Examples:

      | option | views |
      | Day    | Day   |
      | Week   | Week  |
      | Month  | Month |


  @US005_calendar_AC01_TC01
  Scenario: User can create a new event under the calendar module and see
  it on the related day through the Monthly calendar view

    When  User clicks + New event button
    And   user enters event title "Go GYM" in the title input
    And   user enters start date "from 02/21/2025 at 9:00 AM" and end date "to 02/21/2025 at 10:00 AM" and click save button
    Then  user sees "eventTitle" on the related day through the Monthly calendar view





