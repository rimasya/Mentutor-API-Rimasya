@Tugas
Feature: Mentutor mentor faeture

  @PostTasks @Positive
  Scenario: Post mentor tasks with valid data
    Given Post mentor tasks with valid data
    When Send post section request
    Then Status code should be 201 CREATED

  @PostTasks @Negative
  Scenario: Post mentor tasks without authorazation
    Given Post mentor tasks without authorazation
    When Send post section request
    Then Status code should be 400 Bad Request