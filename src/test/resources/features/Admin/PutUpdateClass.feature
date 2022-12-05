@Tugas
Feature: Admin Update User

  @PutClass @Positive
  Scenario: Update class with valid id_class
    Given Update class with valid id_class 14
    When Send update class request
    Then Status code should update class be 201 Created

  @PutClass @Negetive
  Scenario: Update class with invalid id_user
    Given Update class with invalid id_class 7
    When Send update class request
    Then Status code update class should be 400 Bad Request

  @PutClass @Negative
  Scenario: Update class without data
    Given Update user with invalid id_class 2 without data
    When Send update class request
    Then Status code update class without body should be 400 Bad Request