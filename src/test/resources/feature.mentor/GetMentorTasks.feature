@Tugas
Feature: Mentutor Feature Test

  @GetMentor @Positive
  Scenario: Get mentor tasks with authorization
    Given Get mentor tasks with authorization
    When Send get mentor tasks request
    Then Status code get mentor tasks should be 200 OK

  @GetMentor @Negative
  Scenario: Get mentor tasks without authorization
    Given Get mentor tasks without authorization
    When Send get mentor tasks request
    Then Status code mentor tasks should be 400 Bad Request

  @GetMentor @Negative
  Scenario: Get mentor tasks invalid parameter
    Given Get mentor tasks with invalid parameter
    When Send mentor tasks users invalid request
    Then Status code mentor tasks should be 404 Not Found

