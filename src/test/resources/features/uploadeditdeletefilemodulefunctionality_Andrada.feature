@FilesFeatures
Feature:Upload/Edit/Delete File Module Functionality
  As a user, I should be able to upload a file, move or delete any
  selected file under the Files module

  Background:user is already on the login page
    Given user is on the login page
    Then the user is able to login username as "Employee52" and password as "Employee123"
    Given the user clicks "Files" menu
    Given user is on the Files page

  @US-JIRA-ID_tasks_AC01-TC01
  Scenario:User can upload a file
    Then user is able to click on + icon
    When user is on the File page muss be able to upload a file
    Then user is able to see upload file in Files page
    Then user is able to see deleted File in Deleted Files page


  @US-JIRA-ID_tasks_AC02-TC01
    Scenario: user is able to create a New Folder
     When user is able to click on + icon
    When user is able to click on New Folder
    Then user is able provide the name for folder
    Then user is able to see name of folder in that page

  @US-JIRA-ID_tasks_AC03-TC01
  Scenario: User can delete any selected item from its three dots menu
    When user is able to click on three dots
    Then user is able to delete any item

  @US-JIRA-ID_tasks_AC04-TC01
  Scenario: User can see the total number of files and folders under the files list table
    Given user is able to see total number of files
    Then user is able to see total number of folders