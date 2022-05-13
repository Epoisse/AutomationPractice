Feature: 239847 Validation of login scenarios

  Background:
    When user navigated to Sign In page

  @test
  Scenario: User sign in
    And user enters valid credentials
    And user clicks Sign In button
    Then user successfully signed in

  #@negativeTest @test
  #Scenario: Invalid sign in
   # And user enters invalid username and password
    #And user clicks Sign In button
    #Then user sees error message on the screen

  @dataTable @negativeTest @test4
  Scenario: Invalid sign in
    And user provides invalid credentials
      | email             | password        | errorMessage               |
      |                   |                 | An email address required. |
      | invalidEmail      |                 | Invalid email address.     |
      |                   | lol1234         | An email address required. |
      | invalidEmail      | lol1234         | Invalid email address.     |
      | lol1234@gmail.com |                 | Password is required.      |
      | lol1234@gmail.com | invalidPassword | Authentication failed.     |
