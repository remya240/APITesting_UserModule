Feature: Testing GetUser 
@Getalluser_positive
Scenario Outline: Verifying Get request to GET All Users 
  Given Authorized User creates the GET request with valid baseUrl, valid endpoint 
  When User sends GET request for valid credentials from Excel "<SheetName>" and row <RowNumber>
  Then User receives 200 OK Status in response body

Examples:
  | SheetName | RowNumber |
  | Post       | 1        |
@Getalluser_invalid_baseUrl
Scenario Outline: Verifying Get request to GET All Users 
  Given Authorized User creates the GET request with invalid baseUrl, valid endpoint 
  When User sends GET request for invalid baseUrlcredentials from Excel "<SheetName>" and row <RowNumber>
  Then User receives 404 Not Found Status in response body

Examples:
  | SheetName | RowNumber |
  | Post       | 1        |
  
  @Getuserbyuserid_positive
Scenario Outline: Verifying Get request to GET User by userid
  Given Authorized User creates the GET request with valid baseUrl, valid endpoint 
  When User sends GET request for GET User by userid with valid credentials from Excel "<SheetName>" and row <RowNumber>
  Then User receives 200 OK Status in response body
  Examples:
  | SheetName | RowNumber |
  | Post       | 1        |
    @Getuserbyuserid_negative
Scenario Outline: Verifying Get request to GET User by userid
  Given Authorized User creates the GET request with valid baseUrl,non existing userid
  When User sends GET request for GET User by userid with valid credentials non existing userid from Excel "<SheetName>" and row <RowNumber>
  Then User receives 404 Not Found Status in response body of for non existing userid
  Examples:
  | SheetName | RowNumber |
  | Post       | 1        |