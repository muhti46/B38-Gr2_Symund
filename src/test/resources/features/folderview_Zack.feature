@B38GR2-152_folderview
Feature: Folder View Functionality
"""
  User Story:
    As a user, I should be able to change folder view order by using Name/Size/Modified buttons
  Acceptance Criteria:
    1. User can change folder view order by Name.
    2. User can change folder view order by Size.
    3. User can change folder view order by Modified.
    4. User can select all the files at once and see the total values of all files in the first line
    when clicked on the "select all" checkbox at the left top comer of the list.
  """

  Background: User logins and navigates to Files Page
    Given the user is on the login page
    And the user logged in with username as "Employee15" and password as "Employee123"
    And the user navigates to "Files" module


  @B38GR2-152_folderview_AC04-TC01
  Scenario: Verify user should see the total number of all files/folders in the first line once
  select all checkbox is selected
    When user clicks on the select all checkbox
    Then verify user should see total numbers of files-folders as expected

  @B38GR2-152_folderview_AC04-TC02
  Scenario: Verify all check boxes should be selected once select all checkbox is selected
    When user clicks on the select all checkbox
    Then verify user should see all checkboxes as selected