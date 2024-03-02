package api.test;

import utility.ExcelReader;
import api.endpoints.Routes;
import api.payload.User;

import java.io.IOException;
import io.restassured.response.Response;

public class UserTests {
	Response response, getresponse, putresponse;

	ExcelReader excelReader;

	public UserTests() {
		this.excelReader = new ExcelReader(Routes.EXCEL_FILE_PATH);
	}

	public UserTests(String filePath) {
		excelReader = new ExcelReader(filePath);
	}

	public User getUserFromExcel(String sheetName, int rowNumber) throws IOException {
		// Read data from Excel using the ExcelReader class
		String username = excelReader.getCellData(sheetName, rowNumber, 0);
		System.out.println("*****" + username);
		String password = excelReader.getCellData(sheetName, rowNumber, 1);
		System.out.println("*****" + password);

		String userFirstName = excelReader.getCellData(sheetName, rowNumber, 2);
		String userLastName = excelReader.getCellData(sheetName, rowNumber, 3);
		String userContactNumber = excelReader.getCellData(sheetName, rowNumber, 4);
		String userEmail = excelReader.getCellData(sheetName, rowNumber, 5);
		String plotNumber = excelReader.getCellData(sheetName, rowNumber, 6);
		String street = excelReader.getCellData(sheetName, rowNumber, 7);
		String state = excelReader.getCellData(sheetName, rowNumber, 8);
		String country = excelReader.getCellData(sheetName, rowNumber, 9);
		String zipCode = excelReader.getCellData(sheetName, rowNumber, 10);

		User user = new User();

		user.setUser_first_name(userFirstName);
		user.setUser_last_name(userLastName);
		user.setUser_contact_number(userContactNumber);
		user.setUser_email_id(userEmail);
		user.setPlotNumber(plotNumber);
		user.setStreet(street);
		user.setState(state);
		user.setCountry(country);
		user.setZipCode(zipCode);
		System.out.println("***** Returning user object: " + user.toString());

		return user;
	}

	// Method to send the request with the constructed payload
	public void sendRequest(User user) {
		// Send the request using your API client (e.g., RestAssured)
		// Example:
		// response = YourApiClient.sendPostRequest("/user", user);
	}
}
