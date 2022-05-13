Feature: 2134 Create an account validation

  Background:
    When user navigated to Sign In page
    And user sees information message "Please enter your email address to create an account."

  @test5
  Scenario: Create user account
    And user enters valid email
    And user clicks Create an account button
    And fill in all required fields with valid credentials
    Then account successfully created

  @test3 @negativeTest @examplesTable @scenarioOutline
  Scenario Outline: Create user account invalid email
    And user enters invalid "<email>"
    And user clicks Create an account button
    Then user sees error "<message>" on the screen
    Examples:
      | email            |message|
      |                  |Invalid email address.|
      | email.gmail.com  |Invalid email address.|
      | reused@email.com |An account using this email address has already been registered. Please enter a valid password or request a new one.|
