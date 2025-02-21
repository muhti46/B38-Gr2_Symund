@US014_tasks
Feature: Tasks Module Functionality
  As a user, I want to manage tasks effectively by creating task lists, adding tasks,
  marking tasks as completed or important, and viewing the count of uncompleted tasks.

  Background:User is already in the log in page
    Given the user is on the login page
    When the user logged in with username as "Employee62" and password as "Employee123"
    And the user clicks "Tasks" menu

@US-014_tasks_AC01-TC01
  Scenario: Create a new list of tasks
    When the user clicks on "Add List..."
    And enters "interview" as the name of the new list and hits the enter
    Then a new task list named "interview" should be created and displayed in the sidebar

@US-014_tasks_AC02-TC01
  Scenario: Create a new task
    Given the user has selected the "interview" list
    When the user enters "mock" in the Add a task to field and hits the enter
    Then "mock" should be added to the "interview" task list

@US-014_tasks_AC03-TC01
  Scenario: Add a task to the completed tasks list
    Given "Grooming meeting" exists in the "Symund" task list
    When the user clicks on the checkbox next to "Grooming meeting" task
    Then sees the "Grooming meeting" task checked

@US-014_tasks_AC04-TC01
  Scenario: Add a task to the important tasks list
    Given "demo" exists in the "Symund" task list
    When the user clicks on the star icon next to "demo" task
    Then "demo" should appear in the list of important tasks