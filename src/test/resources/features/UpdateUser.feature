
Feature: User Update

Background:
  Given User has Authorization to access the system with valid credentials

@UpdateUserpositive
Scenario Outline: Verifying PUT request to Update a User (Positive)
  Given User sets PUT request with valid URL, valid endpoint, and valid request body.
  When User sends PUT request with valid URL, valid endpoint, request body from Excel "<SheetName>" and row <RowNumber>
  Then User is updated successfully with Status Code 200

Examples:
  | SheetName | RowNumber |
  | Post      | 1         |
 
 @UpdateUsernegative
Scenario Outline: Update User with missing madatory fields for FirstName.
  Given  User sets Put request with  valid url and enpoints but missing madatory fields for FirstName.
  When User sends PUT request with missing madatory fields from Excel "<SheetName>" and row <RowNumber>
  Then User displayed with status code "400"

Examples:
  | SheetName | RowNumber |
  | Post      | 1         |
           