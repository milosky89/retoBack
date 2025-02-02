#author: Camilo Garcia

Feature: create employee

  @CreateEmployee
  Scenario:  create employee successfully
    Given "Camilo" gets the baseurl from the api
    When  create an employee
    Then I see the response code 200
    And  I see employee data

