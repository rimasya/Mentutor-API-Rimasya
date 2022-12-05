@Tugas
Feature: Admin Update User

  @PutUser @positive
  Scenario: Update user with valid id_user
    Given Update user with valid id_user 2
    When Send update user request
    And Status code should be 201 Created

  @PutUser @Negetive
  Scenario: Update user with invalid id_user
    Given Update user with invalid id_user 7
    When Send update user request
    Then Status code update user should be 404 Not Found

  @PutUser @Negative
  Scenario: Update user with without body
    Given Update user with invalid id_user 2 without body
    When Send update user request
    Then Status code update user without body should be 400 Bad Request