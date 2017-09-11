package twitter.service;

import twitter.dto.TwitterMessageDto;
import twitter.mappers.TwitterDtoMapper;
import twitter.mappers.impl.TwitterDtoMapperImpl;
import twitter.model.TwitterMessage;
import twitter.repository.TwitterRepository;
import twitter.repository.impl.TwitterRepositoryImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Rafal on 2017-08-31.
 */

public class TwitterService {

    private TwitterRepository twitterRepositoryImpl = new TwitterRepositoryImpl();
    
    private TwitterDtoMapper twitterDtoMapper = new TwitterDtoMapperImpl();
    
    public List<TwitterMessageDto> getAllTwitts() {
    	List<TwitterMessage> allTwitts=twitterRepositoryImpl.getAllTwitts();
    	List<TwitterMessageDto> twitterMessages = new ArrayList<TwitterMessageDto>();
    	if (allTwitts!=null) {
	        for (TwitterMessage twitterMessage : allTwitts) {
	        	TwitterMessageDto twitterMessageDto=twitterDtoMapper.map(twitterMessage);
	        	twitterMessages.add(twitterMessageDto);
	        }
    	}
    	return twitterMessages;
    }

    public void createTwitterMessage(String userName, String message){
        TwitterMessage twitterMessage = new TwitterMessage(message, new Date(), userName);
        
        twitterRepositoryImpl.persistTwitterMessage(twitterMessage);
    }
    
    public TwitterMessageDto getTweet(long id) {
    	TwitterMessage twitterMessage = twitterRepositoryImpl.getTweet(id);
    	TwitterMessageDto twitterMessageDto = twitterDtoMapper.map(twitterMessage);
    	return twitterMessageDto;
    }
    
    public List<TwitterMessageDto> getFavouriteTwitts(String twittsId) {
    	if (twittsId!=null) {
	    	String [] twittIds = twittsId.split("#");
			
			List<TwitterMessageDto> favouriteTwitts = new ArrayList<TwitterMessageDto>();
			
			for (String twittIdString : twittIds) {
				try {
					long twittId=Long.valueOf(twittIdString);
					TwitterMessageDto twitterMessageDto=this.getTweet(twittId);
					favouriteTwitts.add(twitterMessageDto);
				} catch (Exception e) {
					System.out.println("Exception during parsing twitt"+e.toString());
				}
				
			}
			
			return favouriteTwitts;
    	} else {
    		return null;
    	}
    }



}
