Feature: Testing DeleteUser 
@Deleteuserbyuserid_positive
Scenario Outline: Verifying Delete request to GET User by userid
  Given Authorized User creates the Delete request with valid baseUrl, valid endpoint 
  When User sends Delete request for Delete User by userid with valid credentials from Excel "<SheetName>" and row <RowNumber>
  Then User receives  Delete User by userid 200 OK Status in response body
  Examples:
  | SheetName | RowNumber |
  | Post       | 1        |
@Deleteuserbyuserid_negative
Scenario Outline: Verifying Delete request to GET User by userid
  Given Authorized User creates the Delete request with valid baseUrl,non existing userid
  When User sends Delete request for Delete User by userid with valid credentials non existing userid from Excel "<SheetName>" and row <RowNumber>
  Then User receives Delete User by userid 404 Not Found Status in response body of for non existing userid
  Examples:
  | SheetName | RowNumber |
  | Post       | 1        |