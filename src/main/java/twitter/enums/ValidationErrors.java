package twitter.enums;

public enum ValidationErrors {
	
	EMPTY_USER_NAME("User name shouldn't be empty"),
	EMPTY_MESSAGE("Message shouldn't be empty");
	
	private String value; 
	
	public String getValue() {
		return value;
	}
	
	private ValidationErrors(String value) {
		// TODO Auto-generated constructor stub
		this.value = value;
	}
	
	 
}
