@US006_DeletedFileTab
Feature: Deleted Files Tab Functionality

  User Story:
  As a user, I should be able to see all deleted files and delete or restore them permanently under the Deleted Files tab.

  # Background: This section sets up common steps to be executed before each scenario.
  Background:
    Given the user is logged into the application with the username "Employee92" and password "Employee123"
    And the user is on the Files page
    When the user navigates to the Deleted files tab

  # Scenario: This is the first test case, verifying sorting from newest to oldest.
  @US006_DeletedFileTab_AC01-TC01
  Scenario: Verify that the user can sort deleted files from newest to oldest
    And the user clicks on the Deleted column header to sort
    Then the deleted files should be sorted from newest to oldest

  # Scenario: This is the second test case, verifying sorting from oldest to newest.
  @US006_DeletedFileTab_AC01-TC02
  Scenario: Verify that the user can sort deleted files from oldest to newest
    And the user clicks on the Deleted column header to sort
    Then the deleted files should be sorted from oldest to newest

  @US006_DeletedFileTab_AC02-TC03
  Scenario: Permanently delete a file from the Deleted Files section
    And clicks the three dots icon next to the file
    And selects Permanently Delete and confirms
    Then the file should no longer appear in the Deleted Files section

  @US006_DeletedFileTab_AC03-TC04
  Scenario: Verify that user can restore a deleted file and see it under the 'All files' tab again
    And clicks Restore button
    And the user navigates to All Files tab
    Then verify the restored file is visible
