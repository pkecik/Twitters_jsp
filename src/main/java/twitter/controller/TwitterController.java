package twitter.controller;

import sun.swing.StringUIClientPropertyKey;
import twitter.cookies.CookieHelper;
import twitter.dto.TwitterMessageDto;
import twitter.enums.TwitterCookieNames;
import twitter.enums.TwitterMessages;
import twitter.model.TwitterMessage;
import twitter.service.TwitterService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import static twitter.enums.TwitterCookieNames.FAVOURITE_TWITTS;

/**
 * Created by Rafal on 2017-08-31.
 */

@WebServlet(name = "TwitterController", value = "/all")
public class TwitterController extends HttpServlet {

    private TwitterService service = new TwitterService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userMessage = req.getParameter("userMassage")

        if (userMessage !=null ) {
            if (userMessage.equals(TwitterMessages.TWITT_ADDED.name())){
                req.setAttribute("message", TwitterMessages.TWITT_ADDED.getValue());
            }
        }

    	String cookieValue=CookieHelper.getCookieValue(req.getCookies(), FAVOURITE_TWITTS.getValue());
    	
        List<TwitterMessageDto> allTwitts = service.getAllTwitts();
        
        if (cookieValue!=null) {
	        List<TwitterMessageDto> favouriteTwitts = service.getFavouriteTwitts(cookieValue);
	        for (TwitterMessageDto twitterMessageDto : allTwitts) {
	        	for (TwitterMessageDto favouriteMessageDto : favouriteTwitts) {
	        		if (twitterMessageDto.getId()==favouriteMessageDto.getId()) {
	        			twitterMessageDto.setFavouriteTweet(true);
	        			break;
	        		}
	        	}
	        }
        }
        req.setAttribute("twitters", allTwitts);
        RequestDispatcher dispatcher = req.getRequestDispatcher("twitters.jsp");
        dispatcher.forward(req, resp);
    }
}