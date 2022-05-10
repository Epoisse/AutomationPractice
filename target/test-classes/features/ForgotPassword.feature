Feature: 12324 Forgot password functionality

  Background:
    When user navigated to Sign In page
    And user clicks to Forgot password link

  @test2
  Scenario: Password recovery with valid email
    And user enters valid email address
    And user clicks Retrieve Password button
    Then new password successfully sent to email

  @test2
  Scenario: Password recovery with invalid email
    And user enters invalid email address
    And user clicks Retrieve Password button
    Then user see error message on the screen