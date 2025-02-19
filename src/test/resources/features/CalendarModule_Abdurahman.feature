@US005_calendar
Feature: Calendar Module Functionality
  User Story:
  As a user, I should be able to see Daily-Weekly-Monthly view and create
  a new event under the Calendar module.

  Background: User is Calendar page
    Given user is on the calendar page
    When  User clicks options menu


  @US005_calendar_AC01_TC01
  Scenario: User can display daily calendar view
    And   User clicks "Day" in the options menu


  @US005_calendar_AC01_TC02
  Scenario: User can display weekly calendar view
    Then  User sees current Url contains "Week"

  @US005_calendar_AC01_TC03
  Scenario: User can display monthly calendar view
     # Given user is on the calendar page
     # When  User clicks options menu
     # And   User clicks "Month" in the options menu
    Then  User sees current Url contains "Month"

  @US005_calendar_AC01_TC04
  Scenario: User can create a new event under the calendar module and see
  it on the related day through the Monthly calendar view
     # Given user is on the calendar page
    When  User clicks + New event button
    And   user creats event and saves it
    Then  user sees it on the related day through the Monthly calendar view

@wip
  Scenario Outline: User can display calendar views

    And   User clicks "<option>" in the options menu
    Then  User sees current Url contains "<views>"

    Examples:

      | option | views |
      | Day    | Day   |
      | Week   | Week  |
      | Month  | Month |





