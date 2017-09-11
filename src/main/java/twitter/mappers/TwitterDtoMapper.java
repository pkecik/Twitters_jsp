package twitter.mappers;

import twitter.dto.TwitterMessageDto;
import twitter.model.TwitterMessage;

public interface TwitterDtoMapper  {

	public TwitterMessageDto map(TwitterMessage twitterMessage);
}
