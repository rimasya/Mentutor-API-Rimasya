@Tugas
Feature: Mentutor Feature Test

  @GetAllUser @Positive
  Scenario: Get all users with authorization
    Given Get all users with authorization
    When Send get all users request
    Then Status code should be 200 OK

  @GetAllUser @Negative
  Scenario: Get all users without authorization
    Given Get all users without authorization
    When Send get all users request
    Then Status code should be 400 Bad Request

  @GetAllUser @Negative
  Scenario: Get all user invalid parameter
    Given Get all user with invalid parameter
    When Send get all users invalid request
    Then Status code should be 404 Not Found

