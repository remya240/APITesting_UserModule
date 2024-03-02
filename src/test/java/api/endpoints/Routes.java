package api.endpoints;

public  class Routes {
    public static String BASE_URL = "https://userapi-8877aadaae71.herokuapp.com/uap";

    // User URLs
    public static String CREATE_USER_URL = BASE_URL + "/createusers";
    public static String GET_ALL_USERS_URL = BASE_URL + "/users";
    public static String GET_USER_BY_ID_URL = BASE_URL + "/user/{userId}";
    public static String GET_USER_BY_USERNAME_URL = BASE_URL + "/users/username/{userFirstName}";
    public static String UPDATE_USER_URL = BASE_URL + "/updateuser/{userId}";
    public static String DELETE_USER_BY_USERNAME_URL = BASE_URL + "/deleteuser/username/{userFirstName}";
    public static String DELETE_USER_BY_ID_URL = BASE_URL + "/deleteuser/{userId}";
    public static final String EXCEL_FILE_PATH =  "C:\\Users\\ajith\\Desktop\\workspace\\Team5_UserAPITesting\\src\\test\\resources\\TestData\\Post.xlsx";

    //invalid URLS
    public static String GET_ALL_USERS_INVALID_URL = BASE_URL + "/user";
 public static final String JSON_TEST_DATA="C:\\Users\\ajith\\Desktop\\workspace\\Team5_UserAPITesting\\src\\test\\resources\\TestData\\testdatajson.json";

    
}
