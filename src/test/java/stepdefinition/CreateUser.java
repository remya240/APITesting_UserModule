package stepdefinition;

import java.io.IOException;

import org.junit.Assert;

import api.endpoints.Routes;
import api.endpoints.UserEndpoints;
import api.test.UserTests;
import api.payload.User;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utility.ExcelReader;

public class CreateUser {
	private UserTests userTests;
	private Response response;
	private ExcelReader excel;
	private String username;
	private String password;

	public CreateUser() {
		this.userTests = new UserTests(); 
		this.excel = new ExcelReader(Routes.EXCEL_FILE_PATH); 

	}

	@Given("User has Authorization to access the system with valid credentials")
	public void user_has_authorization_to_access_the_system_with_valid_credentials() throws IOException {

		RestAssured.authentication = RestAssured.basic(username, password);

	}

	@Given("User sets Post request with valid URL, valid endpoint, and valid request body.")
	public void user_sets_post_request_with_valid_url_valid_endpoint_and_valid_request_body() {
		RestAssured.authentication = RestAssured.basic(username, password);

	}

	@When("User sends POST request with valid URL, valid endpoint, request body from Excel {string} and row {int}")
	public void user_sends_post_request_with_valid_url_valid_endpoint_request_body_from_excel_and_row(String sheetName,
			Integer rowNumber) throws IOException {
		User userFromExcel = userTests.getUserFromExcel(sheetName, rowNumber);
		System.out.println("User from Excel: " + userFromExcel);
		String username = excel.getCellData(sheetName, rowNumber, 0);
		String password = excel.getCellData(sheetName, rowNumber, 1);
		RestAssured.authentication = RestAssured.basic(username, password);
		System.out.println("Username received When+++++" + username);
		System.out.println("password received When +++++++" + password);

		Response response = UserEndpoints.createUserhashmap(userFromExcel.toHashMap());

		String responseBody = response.asString();
		System.out.println("##########Response" + responseBody);
		// Store the response for later use if needed
		this.response = response;

	}

	@Then("User is created successfully with Status Code {int}")
	public void user_is_created_successfully_with_status_code(Integer expectedStatusCode) {
		int actualStatusCode = response.getStatusCode();

		Assert.assertEquals("Status code assertion failed", expectedStatusCode.intValue(), actualStatusCode);
	}

	@Given("User sets Post request with valid URL, valid endpoint, and valid request body\\(hashmap).")
	public void user_sets_post_request_with_valid_url_valid_endpoint_and_valid_request_body_hashmap() {
		RestAssured.authentication = RestAssured.basic(username, password);

	}

	@When("User sends Post request with \\(hashmap) valid URL, valid endpoint, request body from Excel {string} and row {int}")
	public void user_sends_post_request_with_hashmap_valid_url_valid_endpoint_request_body_from_excel_and_row(
			String sheetName, Integer rowNumber) throws IOException {
		String username = excel.getCellData(sheetName, rowNumber, 0);
		String password = excel.getCellData(sheetName, rowNumber, 1);
		RestAssured.authentication = RestAssured.basic(username, password);
		System.out.println("Username received When+++++" + username);
		System.out.println("password received When +++++++" + password);
		 UserEndpoints userEndpoints = new UserEndpoints(); // Create an instance of UserEndpoints
	        Response response = userEndpoints.postUserManual(); 
	}

	@Then("User is created successfully with Status Code {int}\\(hashmap)")
	public void user_is_created_successfully_with_status_code_hashmap(Integer expectedStatusCode) {
		Assert.assertNotNull("Response object is null", response);

		int actualStatusCode = response.getStatusCode();
		System.out.println("actualStatusCode Is getting " + actualStatusCode);

		Assert.assertEquals("Status code assertion failed", expectedStatusCode.intValue(), actualStatusCode);
	}
}
