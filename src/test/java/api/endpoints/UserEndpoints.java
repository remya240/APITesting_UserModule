package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoints {
	 static int   user_id;
	public static Response createUser(User payload) {
        System.out.println("User payload: " + payload);
        System.out.println("Routes.CREATE_USER_URL: " + Routes.CREATE_USER_URL);
        Response response = given()
                .log().all()
                .contentType("application/json")
                .accept("application/json")
                .body(payload)
            .when()
                .post(Routes.CREATE_USER_URL);
        String responseBody = response.asString();
        System.out.println("Response body inside request: " + responseBody);
        return response;
	}
	public static Response createUserhashmap(Map<String, Object> payload) {
	    System.out.println("User payload: " + payload);
	    System.out.println("Routes.CREATE_USER_URL: " + Routes.CREATE_USER_URL);
	    Response response = given()
	            .log().all()
	            .contentType("application/json")
	            .accept("application/json")
	            .body(payload)
	        .when()
	            .post(Routes.CREATE_USER_URL).then()
                .extract().response();
        
        // Extracting user_id from the response
        int userId = response.jsonPath().getInt("user_id");
        System.out.println("User ID extracted from response: " + userId);

	    String responseBody = response.asString();
	    System.out.println("Response body inside request: " + responseBody);

	    return response;
	}

	 public static Response getAllUsers() {
		    System.out.println("URL&&&&&&&&:" + Routes.GET_ALL_USERS_URL);
		    Response response = given()
		        .when()
		        .get(Routes.GET_ALL_USERS_URL);

		    System.out.println("Response status code getallusers: " + response.getStatusCode());

		    return response;
		}
	 public static Response getAllUsersInvalidurl() {
		    System.out.println("URL&&&&&&&&:" + Routes.GET_ALL_USERS_INVALID_URL);
		    Response response = given()
		        .when()
		        .get(Routes.GET_ALL_USERS_INVALID_URL);

		    System.out.println("Response status code getallusers: " + response.getStatusCode());

		    return response;
		}

	public static Response getbyuserid(int userId)
	{
		Response response= given().pathParam("userId",userId)
			.when()
				.post(Routes.GET_USER_BY_ID_URL+user_id);
				
		
		return response;
		
	}
	public static Response getbyuseridManual(int userId) {
	    System.out.println("URL userid&&&&&&&&:" + Routes.GET_USER_BY_ID_URL);

	    Response response = given()
	                            .pathParam("userId", userId)
	                       .when()
	                            .get(Routes.GET_USER_BY_ID_URL);
	        
	    return response;
	}
	public static Response DeletebyuseridManual(int userId) {
	    System.out.println("URL DELETE_USER_BY_ID_URL&&&&&&&&:" + Routes.DELETE_USER_BY_ID_URL);

	    Response response = given()
	                            .pathParam("userId", userId)
	                       .when()
	                            .delete(Routes.DELETE_USER_BY_ID_URL);
	        
	    return response;
	}
	public static Response getUserFirstname(String userFirstName)
	{
		Response response=given()
					.when()
				.get(Routes.GET_USER_BY_USERNAME_URL);
		
		return response;
	}
	public static Response putUser(String userId, User payload)
	{
		Response response=given()
				.contentType(ContentType.JSON) 
				.accept(ContentType.JSON)
				.body(payload)
				.pathParam("userId",userId)
			.when()
			.put(Routes.UPDATE_USER_URL);
		
		return response;				
	}
	public static Response deleteUserFirstname(String userfirstname)
	{
		Response response=given()
						.pathParam("userFirstname",userfirstname)
				.when()
				.delete(Routes.DELETE_USER_BY_USERNAME_URL);
		
		return response;
		
	}

	public static Response deleteUser(String userId)
	{
		Response response=given()
						.pathParam("userId",userId)
				.when()
				.delete(Routes.DELETE_USER_BY_USERNAME_URL);
		
		return response;
		
	}
	
	 public static Response putUserManual(int userId) {
	        Map<String, Object> payload = new HashMap<>();
	        payload.put("user_first_name", "Remyateamopthlasttwo");
	        payload.put("user_last_name", "Fivenighlasttwo");
	        payload.put("user_contact_number", "9908809879");
	        payload.put("user_email_id", "pyybu4@gmail.com");

	        Map<String, String> userAddress = new HashMap<>();
	        userAddress.put("plotNumber", "o9-6m");
	        userAddress.put("street", "bircha");
	        userAddress.put("state", "CA");
	        userAddress.put("country", "USA");
	        userAddress.put("zipCode", "92821");

	        payload.put("userAddress", userAddress);

	        Response response = given()
	                .contentType("application/json")
	                .accept("application/json")
	                .body(payload)
	                .pathParam("userId", userId)
	            .when()
	                .put(Routes.UPDATE_USER_URL);
	        return response;
	    }
	 public static Response  postUserManual() {
		 
	        Map<String, Object> payload = new HashMap<>();
	        payload.put("user_first_name", "Remyateamopthrnew");
	        payload.put("user_last_name", "Fivenightnew");
	        payload.put("user_contact_number", "9908832879");
	        payload.put("user_email_id", "pyymm4@gmail.com");

	        Map<String, String> userAddress = new HashMap<>();
	        userAddress.put("plotNumber", "o9-6m");
	        userAddress.put("street", "birkar");
	        userAddress.put("state", "CA");
	        userAddress.put("country", "USA");
	        userAddress.put("zipCode", "92821");

	        payload.put("userAddress", userAddress);

	        Response response= given()
	                .contentType("application/json")
	                .accept("application/json")
	                .body(payload)
	            .when()
	                .post(Routes.CREATE_USER_URL);
	        user_id = response.jsonPath().getInt("user_id");

	       return response;
	    }
	 public static Response putUserManualMissingField(int userId) {
	        Map<String, Object> payload = new HashMap<>();
	        payload.put("user_first_name", "");
	        payload.put("user_last_name", "Fivenighlasttwo");
	        payload.put("user_contact_number", "9908809879");
	        payload.put("user_email_id", "pyybu4@gmail.com");

	        Map<String, String> userAddress = new HashMap<>();
	        userAddress.put("plotNumber", "o9-6m");
	        userAddress.put("street", "bircha");
	        userAddress.put("state", "CA");
	        userAddress.put("country", "USA");
	        userAddress.put("zipCode", "92821");

	        payload.put("userAddress", userAddress);

	        Response response = given()
	                .contentType("application/json")
	                .accept("application/json")
	                .body(payload)
	                .pathParam("userId", userId)
	            .when()
	                .put(Routes.UPDATE_USER_URL+user_id);
	        return response;
	    }
	
	
	
}
