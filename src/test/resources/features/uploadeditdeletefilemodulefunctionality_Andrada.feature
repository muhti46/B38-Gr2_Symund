
Feature:Upload/Edit/Delete File Module Functionality
  As a user, I should be able to upload a file, move or delete any
  selected file under the Files module

  Background:user is already on the login page
    Given user is on the login page
    When the user logged in with username as "Employee52" and password as "Employee123"
    Then the user clicks "file" menu

  @US-JIRA-ID_tasks_AC01-TC01
  Scenario:User can upload a file
    Given user is on the Files page
    When user is on the File page muss be able to upload a file
    Then user is able to see upload file in Files page



  Scenario: User can create a new folder


  Scenario: User can delete any selected item from its three dots menu


  Scenario: User can see the total number of files and folders under the files list table