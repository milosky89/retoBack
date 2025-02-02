#author: Camilo Garcia

Feature: Delete employee

  @DeleteEmployee
  Scenario: delete Employee existing in the list
    Given "Camilo" gets the baseurl from the api
    When delete employee by id "16"
    Then I see the response code 200
    And I validate the response message is correct "Successfully! Record has been deleted"