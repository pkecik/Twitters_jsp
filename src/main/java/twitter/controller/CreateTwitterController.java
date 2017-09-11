package twitter.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import twitter.enums.ValidationErrors;
import twitter.service.TwitterService;

@WebServlet(name = "CreateTwitt", value = "/create")
public class CreateTwitterController extends HttpServlet {


    private TwitterService service = new TwitterService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
        RequestDispatcher dispatcher = req.getRequestDispatcher("create.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String message = req.getParameter("message");
        service.createTwitterMessage(userName,message);
        resp.sendRedirect("/com.firstjsp/all?userMessage=TWITT_ADDED");
    }

}
