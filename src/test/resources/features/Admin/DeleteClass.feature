@Tugas
Feature: Mentutor Feature Test
  @DeleteClass @Positive
  Scenario: Delete class with valid id
    Given Delete class with id_class 50
    When Send delete class request
    Then Status delete class code should be 200 OK

  @DeleteClass @Negatif
  Scenario: Delete class without id
    Given Delete class without id
    When Send delete class without id request
    Then Status delete class code should be 405 Method Not Allowed

  @DeleteClass @Negatif
  Scenario: Delete class invalid param
    Given Delete class with id_class 48
    When Send delete class with invalid param request
    Then Status delete class code should be 404 Not Found