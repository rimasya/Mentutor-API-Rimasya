@Tugas
Feature: Mentutor Feature Test

  @GetSingleUser @Positive
  Scenario: Get user profile with valid id
    Given Get user profile with valid id_user 12
    When Send get user profile request
    Then Status get user profile code should be 200 OK

#  Scenario: Get user profile without id
#    Given Get user profile without id
#    When Send get user profile request
#    Then Status get user profile code should be 200 OK

  @GetSingleUser @Positive
  Scenario: Get user profile with invalid id
    Given Get user Get user profile with invalid id_user 11
    When Send get user profile request
    Then Status get user profile code should be 400 Bad Request

  @GetSingleUser @Positive @Rimasya
  Scenario: Get user profile invalid param
    Given Get user Get user profile invalid param with id_user 10
    When Send get user profile invalid param request
    Then Status get user profile code should be 404 Not Found

