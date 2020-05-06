Feature: Login Functionality Feature Dependency

  Scenario Outline: Login Successful Dependency

    Given I am on login page
    When I enter <username> and <password> with <userFullName>
    Then I should be reverted to the Overview Page

    Examples:
    |username|password|userFullName|
    |"autotester"|"password"|"Auto Tester"|
    |"tautester"|"password"|"TAU Tester"|