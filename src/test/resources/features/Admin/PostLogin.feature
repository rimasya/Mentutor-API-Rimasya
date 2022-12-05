@Tugas
Feature: Post Login
  @login @Positive
  Scenario: Post login admin with valid value
    Given Post login with all valid value as admin
    When Send request post login
    Then Should return 200 OK

  @login @Positive
  Scenario: Post login admin with invalid value
    Given Post login with invalid value as admin
    When Send request post login
    Then Should return 404 Not Found

#    And Validate post login valid value json schema
#  @positive
#  Scenario Outline: Login admin with valid data
#    Given User login with email "<email>" and password "<password>"
#    When User send request post login user
#    Then Should return 200 OK
#    And Response body massage is "login successful"
#    Examples:
#      |email                    |password   |
#      |admin.mentutor@gmail.com |Admin123$  |
#  @login
#  Scenario: Post login with valid value
#    Given Post login with all valid value as admin
#    When Send request post login
#    Then Should return 200 OK
#    And Validate post login valid value json schema
#
#  Scenario: Post login with valid value
#    Given Post login with all valid value as mentor
#    When Send request post login
#    Then Should return 200 OK
#    And Validate post login valid value json schema
#
#  Scenario: Post login with valid value
#    Given Post login with all valid value as mentee
#    When Send request post login
#    Then Should return 200 OK
#    And Validate post login valid value json schema
