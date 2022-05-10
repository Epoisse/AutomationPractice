Feature: 239847 Validation of login scenarios

  Background:
    When user navigated to Sign In page

  @test
  Scenario: User login
    And user enter valid credentials
    And user clicks Sign In button
    Then user successfully signed in

  @negativeTest @test
  Scenario: Invalid login
    And user enter invalid username and password
    And user clicks Sign In button
    Then user see error message on the screen