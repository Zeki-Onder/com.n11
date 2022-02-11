@N11Login
Feature: System should allow that user to login

  Background: Common steps
    Given User goes to "N11Url" page
    Then  Opens the Login page

    @positiveLoginTest @tc101
  Scenario:System should allow login with correct username and password
    Given User enters "test_onder@outlook.com" and "Qwerty654321"
    Then  User clicks login button
    And   User verifies login
    Then  User closes the page

    @negativeLoginTests @tc102
  Scenario Outline:System should not allow login with incorrect username or password
    Given User enters "<email>" and "<password>"
    Then  User clicks login button
    And   User verifies login failed
    Then  User closes the page

    Examples:
      |email                  |password     |
      |asdf@asfasf.com        |Qwerty654321 |
      |test_onder@outlook.com |125412541254 |
      |asdf@asfasf.com        |125412541254 |

    @tc103
  Scenario:Warning messages should be displayed when logging in with an invalid email or password
    Given User enters "test" at the email textbox and verifies that invalid email warning message is displayed
    Then  User enters "123" at the password textbox and verifies that invalid password warning message is displayed
    Then  User closes the page

    @tc104-tc105
  Scenario:If user logs in successfully, the home page should open and username should be displayed on the Homepage.
    Given User enters "test_onder@outlook.com" and "Qwerty654321"
    Then  User clicks login button
    Then  User verifies that the homepage is opened and the username is displayed
    And   User closes the page

