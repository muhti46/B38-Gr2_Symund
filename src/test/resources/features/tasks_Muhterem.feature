@US014_tasks
Feature: Tasks Module Functionality
  As a user, I want to manage tasks effectively by creating task lists, adding tasks,
  marking tasks as completed or important, and viewing the count of uncompleted tasks.

  Background:User is already in the log in page
    Given the user is on the login page
    When the user logged in with username as "Employee62" and password as "Employee123"
    And the user clicks "Tasks" menu

  @US-014_tasks_AC01-TC01
  Scenario Outline: Create a new list of tasks
    When the user clicks on "Add List..."
    And enters "<listName>" as the name of the new list and hits the enter
    Then a new task list named "<listName>" should be created and displayed in the sidebar
    Examples:
      | listName        |
      | Marketing Tasks |
      | Project Tasks   |
      | Private Tasks   |

  @US-014_tasks_AC02-TC01
  Scenario Outline: Create a new task
    Given the user has selected the "<listName>" list
    When the user enters "<TaskName>" in the Add a task to field and hits the enter
    Then "<TaskName>" should be added to the "<listName>" task list
    Examples:
      | listName        | TaskName                  |
      | Marketing Tasks | Meeting with stakeholders |
      | Project Tasks   | Planing                   |
      | Private Tasks   | Walking alone             |

  @US-014_tasks_AC03-TC01
  Scenario: Add a task to the completed tasks list
    Given "Planing" exists in the "Project Tasks" task list
    When the user clicks on the checkbox next to "Planing" task
    Then sees the "Planing" task checked

  @US-014_tasks_AC04-TC01
  Scenario: Add a task to the important tasks list
    Given "demo" exists in the "Symund" task list
    When the user clicks on the star icon next to "demo" task
    Then "demo" should appear in the list of important tasks

  @US-014_tasks_AC05-TC01
  Scenario: View number of uncompleted tasks
    Given there are uncompleted tasks in the "java" task list
    When the user navigates to the "Current" tab
    Then they should see a number indicating the total count of uncompleted tasks next to "Current"