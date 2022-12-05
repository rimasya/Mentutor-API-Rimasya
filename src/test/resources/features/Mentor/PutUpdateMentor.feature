@Tugas
Feature: Admin Update User

  @PutMentor @positive
  Scenario: Update user mentor with authorization
    Given Update user mentor with authorization
    When Send update user mentor request
    Then Status code update user mentor should be 201 Created

  @PutMentor @Negative
  Scenario: Update user mentor without data
    Given Put user mentor without data
    When Send update user mentor request
    Then Status code update user mentor should be 400 Bad Request

  @PutMentor @Negative
  Scenario: Update user mentor invalid param
    Given Put user mentor invalid param
    When Send put user mentor invalid param request
    Then Status code update user mentor should be 404 Bad Not Found


