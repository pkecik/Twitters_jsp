package twitter.enums;

public enum TwitterCookieNames {
	
	FAVOURITE_TWITTS("twitts_id");
	
	private String value; 
	
	public String getValue() {
		return value;
	}

	private TwitterCookieNames(String value) {
		// TODO Auto-generated constructor stub
		this.value = value;
	}
	
	
}
