Feature:US002 System should not allow anyone to register with invalid credentials

  Background: User navigates to register page of gmi bank application
    Given User on the registration page


  Scenario: TC_001 Any blank field on the registration page should give the error
    When User clicks on Register button without filling blanks
    Then User should see all error message

    @wipE
  Scenario:TC_002 Any field on the registration page should not be left blank
    When User fill in the blanks with valid credentials
    Then User should not see any feedback error


  Scenario Outline: TC_003, TC_004, TC_005 Mobile phone number cannot be of any chars nor spec chars except "-"
    Then User clicks on Mobile Phone Number textboxD
    Then User provide invalid Mobile Phone Number "<invalid_mpns>" and click tabD
    And User should see the Mobile Phone Number error message "mobile_phone_number_error_message2"D
    Examples:Invalid mobile phone numbers
      | invalid_mpns |
      | invalid_mpn1 |
      | invalid_mpn2 |
      | invalid_mpn3 |

