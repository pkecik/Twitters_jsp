package twitter.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import twitter.validators.TwitterMessageValidator;

import static twitter.enums.ValidationErrors.EMPTY_USER_NAME;
import static twitter.enums.ValidationErrors.EMPTY_MESSAGE;



/**
 * Servlet Filter implementation class TwitterValidationFilter
 */
@WebFilter("/create")
public class TwitterValidationFilter implements Filter {
	
	private TwitterMessageValidator twitterMessageValidator = new TwitterMessageValidator();
	
    /**
     * Default constructor. 
     */
    public TwitterValidationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		
		if (httpServletRequest.getMethod().equals("POST")) {
		
			HttpServletResponse httpServletResponse = (HttpServletResponse)response;
			String userName = httpServletRequest.getParameter("userName");
	        String message = httpServletRequest.getParameter("message");
	        
	        
	        
	        List<String> errors = twitterMessageValidator.validate(userName, message);
	        
	        if (errors!=null && !errors.isEmpty()) {
	        	request.setAttribute("errors", errors);
	        	request.setAttribute("userName", userName);
	        	request.setAttribute("message", message);
	        	RequestDispatcher dispatcher = httpServletRequest.getRequestDispatcher("create.jsp");
	            dispatcher.forward(httpServletRequest, httpServletResponse);
	            return;
	        }
	        
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	private List<String> validate(String userName, String message) {
		List<String> errors = new ArrayList<String>();
		
		if (!(userName!=null && !userName.equals(""))) {
		    errors.add(EMPTY_USER_NAME.getValue());
		}
		
		if (!(message!=null && !message.equals(""))) {
			errors.add(EMPTY_MESSAGE.getValue());
		}
		return errors;
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
