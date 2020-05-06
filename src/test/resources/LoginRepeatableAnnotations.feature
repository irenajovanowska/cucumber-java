Feature: Login Functionality Feature Repeatable Annotations

  Scenario: Login Successful Repeatable Annotations

    Given I am in the login page of Para Bank Application
    When I enter valid username and password
    Then I should land on the Overview Page


  Scenario: Login Successful Repeatable Annotations

    Given I am in the login page
    When I enter valid username and password
    Then I should land on the Overview Page