@Tugas
Feature: Mentutor Feature Test

  @GetAllClass @Positive
  Scenario: Get all class with authorization
    Given Get all class with authorization
    When Send get class users request
    Then Status get class code should be 200 OK

  @GetAllClass @Negative
  Scenario: Get all class without authorization
    Given Get all class without authorization
    When Send get all class request
    Then Status code get all class should be 400 Bad Request

  @GetAllClass @Negative
  Scenario: Get all class invalid parameter
    Given Get all class with invalid parameter
    When Send get all class invalid request
    Then Status code get all class should be 404 Not Found