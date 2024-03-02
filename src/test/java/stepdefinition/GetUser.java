package stepdefinition;

import java.io.IOException;

import org.junit.Assert;

import api.endpoints.Routes;
import api.endpoints.UserEndpoints;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utility.ExcelReader;

public class GetUser {
	private Response response;
	private ExcelReader excel;
	private String username;
	private String password;

	public GetUser() {
		this.excel = new ExcelReader(Routes.EXCEL_FILE_PATH); // Initialize ExcelReader object in constructor

	}

	@Given("Authorized User creates the GET request with valid baseUrl, valid endpoint")
	public void authorized_user_creates_the_get_request_with_valid_base_url_valid_endpoint() throws IOException {

		RestAssured.authentication = RestAssured.basic(username, password);

	}

	@When("User sends GET request for valid credentials from Excel {string} and row {int}")
	public void user_sends_get_request_for_valid_credentials_from_excel_and_row(String sheetName, Integer rowNumber)
			throws IOException {
		// Extract username and password from the Excel sheet
		String username = excel.getCellData(sheetName, rowNumber, 0);
		String password = excel.getCellData(sheetName, rowNumber, 1);
		RestAssured.authentication = RestAssured.basic(username, password);
		System.out.println("Username received when: ++++" + username);
		System.out.println("Password received: +++" + password);

		response = UserEndpoints.getAllUsers();
	}

	@Then("User receives {int} OK Status in response body")
	public void user_receives_ok_status_in_response_body(int expectedStatusCode) {
		int actualStatusCode = response.getStatusCode();
		Assert.assertEquals("Status code assertion failed", expectedStatusCode, actualStatusCode);
	}

	@Given("Authorized User creates the GET request with invalid baseUrl, valid endpoint")
	public void authorized_user_creates_the_get_request_with_invalid_base_url_valid_endpoint() {
		RestAssured.authentication = RestAssured.basic(username, password);

	}

	@When("User sends GET request for invalid baseUrlcredentials from Excel {string} and row {int}")
	public void user_sends_get_request_for_invalid_base_urlcredentials_from_excel_and_row(String sheetName,
			Integer rowNumber) throws IOException {
		String username = excel.getCellData(sheetName, rowNumber, 0);
		String password = excel.getCellData(sheetName, rowNumber, 1);
		RestAssured.authentication = RestAssured.basic(username, password);
		System.out.println("Username received when: ++++" + username);
		System.out.println("Password received: +++" + password);

		response = UserEndpoints.getAllUsersInvalidurl();

	}

	@Then("User receives {int} Not Found Status in response body")
	public void user_receives_not_found_status_in_response_body(Integer expectedStatusCode) {
		int actualStatusCode = response.getStatusCode();
		Assert.assertEquals("Status code assertion failed", expectedStatusCode.intValue(), actualStatusCode);
	}

	@When("User sends GET request for GET User by userid with valid credentials from Excel {string} and row {int}")
	public void user_sends_get_request_for_get_user_by_userid_with_valid_credentials_from_excel_and_row(
			String sheetName, Integer rowNumber) throws IOException {
		String username = excel.getCellData(sheetName, rowNumber, 0);
		String password = excel.getCellData(sheetName, rowNumber, 1);
		RestAssured.authentication = RestAssured.basic(username, password);
		System.out.println("Username received when:GET User by userid  ++++" + username);
		System.out.println("Password received: GET User by userid  +++" + password);
		// response = UserEndpoints. getbyuserid(user_id);
		response = UserEndpoints.getbyuseridManual(14563);
		int actualStatusCode = response.getStatusCode();
		System.out.println("******pRint" + actualStatusCode);
		Assert.assertEquals("Status code ", 200, actualStatusCode);
	}

	@Given("Authorized User creates the GET request with valid baseUrl,non existing userid")
	public void authorized_user_creates_the_get_request_with_valid_base_url_non_existing_userid() {
		RestAssured.authentication = RestAssured.basic(username, password);

	}

	@When("User sends GET request for GET User by userid with valid credentials non existing userid from Excel {string} and row {int}")
	public void user_sends_get_request_for_get_user_by_userid_with_valid_credentials_non_existing_userid_from_excel_and_row(
			String sheetName, Integer rowNumber) throws IOException {
		String username = excel.getCellData(sheetName, rowNumber, 0);
		String password = excel.getCellData(sheetName, rowNumber, 1);
		RestAssured.authentication = RestAssured.basic(username, password);
		System.out.println("Username received when:GET User by userid  ++++" + username);
		System.out.println("Password received: GET User by userid  +++" + password);

		response = UserEndpoints.getbyuseridManual(11);

	}

	@Then("User receives {int} Not Found Status in response body of for non existing userid")
	public void user_receives_not_found_status_in_response_body_of_for_non_existing_userid(Integer expectedStatusCode) {
		int actualStatusCode = response.getStatusCode();
		Assert.assertEquals("Status code assertion failed", expectedStatusCode.intValue(), actualStatusCode);
	}

}
