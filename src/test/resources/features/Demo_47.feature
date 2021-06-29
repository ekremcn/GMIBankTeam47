Feature: Demo presentation
  Scenario Outline: Steps for money transfer
    Given User is on main page
#    And User access to registration page
#    And User provides information for registration
#    Then Admin user clicks sign in button
#    And Admin provide valid "<adminusername>" and "<adminpswd>"
#    Then Admin activates the account of the user
#    And Admin sign out from the account
#    Then Employee login to account with valid "<employeeusername>" and "<employeepassword>"
#    And Employee integrates accounts for the user
#    Then Employee sign out from account
    Then Demo customer sign in the own account
    And Demo customer navigates to My Operations
    And Demo customer gets the info about own accounts balance
    Then Demo customer makes money transfer
    And Demo customer verifies their money transfer

    Examples:
      |adminusername|adminpswd   |employeeusername|employeepassword|
      |team47admin  |Team47admin.|team47employee  |Team47employee.|