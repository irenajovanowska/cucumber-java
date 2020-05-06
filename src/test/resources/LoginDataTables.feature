Feature: Login Functionality Feature

  Scenario: Login Successful

    Given I am in the login page of the App
    When I enter user and pass
      |autotester|password|
    Then I should land to Overview Page