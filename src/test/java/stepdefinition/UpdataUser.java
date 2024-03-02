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

public class UpdataUser {
	private String username;
	private String password;
	private ExcelReader excel;
	private Response response;
private int user_id;
	public UpdataUser() {
		this.excel = new ExcelReader(Routes.EXCEL_FILE_PATH); // Initialize ExcelReader object in constructor

	}

	@Given("User sets PUT request with valid URL, valid endpoint, and valid request body.")
	public void user_sets_put_request_with_valid_url_valid_endpoint_and_valid_request_body() {
		RestAssured.authentication = RestAssured.basic(username, password);

	}

	@When("User sends PUT request with valid URL, valid endpoint, request body from Excel {string} and row {int}")
	public void user_sends_put_request_with_valid_url_valid_endpoint_request_body_from_excel_and_row(String sheetName,
			Integer rowNumber) throws IOException {
		String username = excel.getCellData(sheetName, rowNumber, 0); // Assuming username is in column 0 (A)
		String password = excel.getCellData(sheetName, rowNumber, 1);
		RestAssured.authentication = RestAssured.basic(username, password);
		System.out.println("Username received When+++++" + username);
		System.out.println("password received When +++++++" + password);
		response = UserEndpoints.putUserManual(user_id);

	}

	@Then("User is updated successfully with Status Code {int}")
	public void user_is_updated_successfully_with_status_code(Integer expectedStatusCode) {
		Assert.assertNotNull("Response object is null", response);

		int actualStatusCode = response.getStatusCode();

		Assert.assertEquals("Status code assertion failed", expectedStatusCode.intValue(), actualStatusCode);

	}

	@Given("User sets Put request with  valid url and enpoints but missing madatory fields for FirstName.")
	public void user_sets_put_request_with_valid_url_and_enpoints_but_missing_madatory_fields_for_first_name() {
		RestAssured.authentication = RestAssured.basic(username, password);

	}

	@When("User sends PUT request with missing madatory fields from Excel {string} and row {int}")
	public void user_sends_put_request_with_missing_madatory_fields_from_excel_and_row(String sheetName,
			Integer rowNumber) throws IOException {
		String username = excel.getCellData(sheetName, rowNumber, 0); // Assuming username is in column 0 (A)
		String password = excel.getCellData(sheetName, rowNumber, 1);
		RestAssured.authentication = RestAssured.basic(username, password);
		System.out.println("Username received When+++++" + username);
		System.out.println("password received When +++++++" + password);
		response = UserEndpoints.putUserManualMissingField(14209);

	}

	@Then("User displayed with status code {string}")
	public void user_displayed_with_status_code(String expectedStatusCode) {
		int expectedCode = Integer.parseInt(expectedStatusCode);

		int actualStatusCode = response.getStatusCode();

		Assert.assertEquals("Status code assertion failed", expectedCode, actualStatusCode);

	}

}
