package twitter.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import twitter.model.TwitterMessage;


public class TwitterMessageDto {

	private long id;
    private String message;
    private Date dateOfCreation;
    private String userName;
	
    private boolean favouriteTweet;
    
	public boolean isFavouriteTweet() {
		return favouriteTweet;
	}

	public void setFavouriteTweet(boolean favouriteTweet) {
		this.favouriteTweet = favouriteTweet;
	}

	public TwitterMessageDto() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	

	

}
