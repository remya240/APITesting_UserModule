package api.payload;

import java.util.HashMap;
import java.util.Map;

public class User {
	private String user_first_name;
    private String user_last_name;
    private String user_contact_number;
    private String user_email_id;
    private String plotNumber;
    private String street;
    private String state;
    private String country;
    private String zipCode;
   
    public String getUser_first_name() {
		return user_first_name;
	}
	public void setUser_first_name(String user_first_name) {
		this.user_first_name = user_first_name;
	}
	public String getUser_last_name() {
		return user_last_name;
	}
	public void setUser_last_name(String user_last_name) {
		this.user_last_name = user_last_name;
	}
	public String getUser_contact_number() {
		return user_contact_number;
	}
	public void setUser_contact_number(String user_contact_number) {
		this.user_contact_number = user_contact_number;
	}
	public String getUser_email_id() {
		return user_email_id;
	}
	public void setUser_email_id(String user_email_id) {
		this.user_email_id = user_email_id;
	}
	public String getPlotNumber() {
		return plotNumber;
	}
	public void setPlotNumber(String plotNumber) {
		this.plotNumber = plotNumber;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
    @Override
    public String toString() {
        return "{\n" +
                "  \"user_first_name\": \"" + user_first_name + "\",\n" +
                "  \"user_last_name\": \"" + user_last_name + "\",\n" +
                "  \"user_contact_number\": \"" + user_contact_number + "\",\n" +
                "  \"user_email_id\": \"" + user_email_id + "\",\n" +
                "  \"userAddress\": {\n" +
                "    \"plotNumber\": \"" + getPlotNumber() + "\",\n" +
                "    \"street\": \"" + getStreet() + "\",\n" +
                "    \"state\": \"" + getState() + "\",\n" +
                "    \"country\": \"" + getCountry() + "\",\n" +
                "    \"zipCode\": \"" + getZipCode() + "\"\n" +
                "  }\n" +
                "}";
    }
    public Map<String, Object> toHashMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("user_first_name", this.user_first_name);
        map.put("user_last_name", this.user_last_name);
        map.put("user_contact_number", this.user_contact_number);
        map.put("user_email_id", this.user_email_id);

        Map<String, String> userAddress = new HashMap<>();
        userAddress.put("plotNumber", this.plotNumber);
        userAddress.put("street", this.street);
        userAddress.put("state", this.state);
        userAddress.put("country", this.country);
        userAddress.put("zipCode", this.zipCode);

        map.put("userAddress", userAddress);

        return map;
    }

}
