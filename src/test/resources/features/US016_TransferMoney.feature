Feature:Money Transfer should be available

  Scenario: User does every step to transfer money between user's accounts
    Given User on the "homepage_url"
    When User navigates to sign in page
    And User provide a valid username "session_customer_username"
    And User provide a valid password "session_customer_password"
    And User click on the sign in button
    Then User navigates My Accounts Page
    And User gets the info about Users accounts balances
    Then User navigates to Transfer Money Page
    And User does the money transfer
    Then User navigates My Accounts Page
    Then User validates that User s money transferred successfully