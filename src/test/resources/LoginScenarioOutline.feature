Feature: Login Functionality Feature

  Scenario Outline: Login Successful

    Given I am in the login page of the Para Bank App
    When I enter valid <username> and <password>
    Then I should be taken to Overview Page

    Examples:
    |username|password|
    |"autotester"|"password"|
    |"tautester"|"password"|