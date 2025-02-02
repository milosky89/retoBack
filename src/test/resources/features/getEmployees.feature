#author: Camilo Garcia

  Feature: consult employees

    Background:
      Given "Camilo" gets the baseurl from the api

      @GetallEmployees
      Scenario: consult employee data
        When I get all employees
        Then I see the response code 200
        And I body of the response is not empty

      @GetEmployeeById
      Scenario: consult employee data by id
        When I get employee by id "9"
        Then I see the response code 200
        And I body of the response is not empty

