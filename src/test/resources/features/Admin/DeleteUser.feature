@Tugas
Feature: Mentutor Feature Test

  @DeleteUser @Positive
  Scenario: Delete user with valid id
    Given Delete user with id_user 1005
    When Send delete users request
    Then Status delete user code should be 200 OK

  @DeleteClass @Negative
  Scenario: Delete user without id
    Given Delete user without id
    When Send delete users without id request
    Then Status delete user code should be 405 Method Not Allowed

  @DeleteClass @Negative
  Scenario: Delete user invalid param
    Given Delete user with id_user 4
    When Send delete users with invalid param request
    Then Status delete user code should be 404 Not Found


