Feature: User Creation

Background:
  Given User has Authorization to access the system with valid credentials

@CreateUserpositive
Scenario Outline: Verifying POST request to create a User (Positive)
  Given User sets Post request with valid URL, valid endpoint, and valid request body.
  When User sends POST request with valid URL, valid endpoint, request body from Excel "<SheetName>" and row <RowNumber>
  Then User is created successfully with Status Code 201

Examples:
  | SheetName | RowNumber |
  | Post      | 1         |

  @CreateUserpositivehashmap
Scenario Outline: Verifying POst request to Update a User (hashmap)
  Given User sets Post request with valid URL, valid endpoint, and valid request body(hashmap).
  When User sends Post request with (hashmap) valid URL, valid endpoint, request body from Excel "<SheetName>" and row <RowNumber>
  Then User is created successfully with Status Code 201(hashmap)

Examples:
  | SheetName | RowNumber |
  | Post      | 1         |
      