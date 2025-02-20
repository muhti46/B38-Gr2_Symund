
Feature: Tasks Module Functionality

  As a user, I want to manage tasks effectively by creating task lists, adding tasks,
  marking tasks as completed or important, and viewing the count of uncompleted tasks.

  Background:User is already in the log in page
    Given the user is on the login page
    When the user logged in with username as "Employee62" and password as "Employee123"
    And the user clicks "Tasks" menu

  @task
  Scenario: Create a new list of tasks
    When the user clicks on "Add List..."
    And enters "Planing group study" as the name of the new task list and hits the enter
    Then a new task list named "Planing group study" should be created and displayed in the sidebar

  Scenario: Create a new task
    Given the user has selected the "Symund" task list
    When the user enters "Grooming meeting" in the Add a task to field and hits the enter
    Then "Grooming meeting" should be added to the "Symund" task list

  Scenario: Add a task to the completed tasks list
    Given "Grooming meeting" exists in the "Personal" task list
    When the user clicks on the checkbox next to "Grooming meeting" task
    Then "Grooming meeting" task should be moved to the "Completed Tasks" section
    Then the user clicks on "Completed Tasks" and sees the "Grooming meeting" task checked

  Scenario: Add a task to the important tasks list
    Given "click cucumber report in target file" exists in the "Take the reports" task list
    When the user clicks on the star icon next to "click cucumber report in target file"
    Then "click cucumber report in target file" should appear in the list of important tasks

  Scenario: View number of uncompleted tasks
    Given there are uncompleted tasks in the "Writing step definitions" task list
    When the user navigates to the "Current" tab
    Then they should see a number indicating the total count of uncompleted tasks next to "Current"











