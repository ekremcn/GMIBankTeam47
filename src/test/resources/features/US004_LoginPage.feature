Feature: US004 Login page should accessible with valid credentials

  Background:
    Given User access to main page
    And User click to icon
    And User click to Sign in button


     Scenario Outline: TC001 There should be a valid username and password validating the success message to login
#      Given User access to main page
#      And User click to icon
#      And User clicks to Sign in button
      Then User provides a valid username "<username>"
      And User provides a valid  password "<password>"
      And User click on sign in button
      And User verifies that user logined successfully
      Examples:
        | username  | password |
        |team47admin|Team47admin.|
        |team47customer|Team47customer.|
        |team47manager|Team47manager.|
        |team47employee|Team47employee.|
        |team47user|Team47user.|


      Scenario Outline: TC002 There should be an option to cancel login
#        Given User access to main page
#        And User click to icon
#        And User clicks to Sign in button
        When User provides valid username "<username>" and password "<password>"
        And User click on cancel button
        And User should be back to Main page
        Examples:
          | username  | password |
          |team47admin|Team47admin.|
          |team47customer|Team47customer.|
          |team47manager|Team47manager.|
          |team47employee|Team47employee.|
          |team47user|Team47user.|

