package twitter.mappers.impl;

import java.util.function.Function;

import twitter.dto.TwitterMessageDto;
import twitter.mappers.TwitterDtoMapper;
import twitter.model.TwitterMessage;

public class TwitterDtoMapperImpl implements TwitterDtoMapper {
	
	public TwitterMessageDto map(TwitterMessage twitterMessage) {
		TwitterMessageDto twitterMessageDto = new TwitterMessageDto();
		twitterMessageDto.setId(twitterMessage.getId());
		twitterMessageDto.setMessage(twitterMessage.getMessage());
		twitterMessageDto.setDateOfCreation(twitterMessage.getDateOfCreation());
		twitterMessageDto.setUserName(twitterMessage.getUserName());
		return twitterMessageDto;
	}
}
