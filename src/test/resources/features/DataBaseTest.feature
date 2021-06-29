Feature: database testing ders
  Background: create connection ders
    Given Uders user creates a connection with db using "jdbc:postgresql://157.230.48.97:5432/gmibank_db" , "techprodb_user" and "Techpro_@126"
  Scenario Outline: read and validate created data using with ssn
    And Uders user creates a Country data using "INSERT INTO tp_country(id, name) VALUES(53698452,'Huzur Ulkesi')"
    And Uders user reads the Country data using "<query>" and "<columnName>"
    Then Uders validate customers data
    Examples: demo read the data
      |query|columnName|
      |Select * from tp_country|id|
