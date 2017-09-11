package twitter.repository;

import twitter.model.TwitterMessage;

import java.util.List;

/**
 * Created by Rafal on 2017-09-01.
 */
public interface TwitterRepository {

    List<TwitterMessage> getAllTwitts();
    TwitterMessage persistTwitterMessage(TwitterMessage twitterMessage);
    
    TwitterMessage getTweet(long id);


}
