Feature:US002 System should not allow anyone to register with invalid credentials

  Background: User navigates to register page of gmi bank application
    Given User on the registration page

    @wipE
  Scenario: TC_001 Any field on the registration page should not be left blank
    When User fills in the blanks
    Then User doesn't should see any error message

  Scenario Outline: TC_002, TC_003, TC_004 Mobile phone number cannot be of any chars nor spec chars except "-"
    Then User clicks on Mobile Phone Number textboxD
    Then User provide invalid Mobile Phone Number "<invalid_mpns>" and click tabD
    And User should see the Mobile Phone Number error message "mobile_phone_number_error_message2"D
    Examples:Invalid mobile phone numbers
      | invalid_mpns |
      | invalid_mpn1 |
      | invalid_mpn2 |
      | invalid_mpn3 |
