Feature: To Perform Crud Opeations

  Scenario: To Perform the GET Operation on Employe DB
    Given The base URI is "http://localhost:3000/employees"
    When I perform the Get Operation
    Then Response code should be 200

  Scenario Outline: To Perform the POST Operation to create Employee
    Given The base URI is "http://localhost:3000/employees"
    When I enter the name as "<Name>" and salary as "<Salary>"
    And I perform Post operation
    Then Response code should be 201

    Examples: 
      | Name   | Salary |
      | Justin |   5000 |
      | Leesa  |   7000 |
