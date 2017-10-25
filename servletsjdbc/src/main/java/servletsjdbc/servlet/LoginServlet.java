package servletsjdbc.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servletsjdbc.repository.RepositoryDAO;

public class LoginServlet {
	public void init() {
		System.out.println("Login servlet loaded");
		}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String pass = req.getParameter("password");
		String message = null;
		
		RepositoryDAO rd = new RepositoryDAO();
		
		boolean result = rd.getUserDetails(username, pass);
		if(result=true) {
			
			System.out.println("Login successsful, first login page");
		}
		else {
			
			System.out.println("you gotta try harder!");
		}
		
		req.setAttribute("info", "message");
		
		RequestDispatcher rp = req.getRequestDispatcher("result.jsp");
		rp.forward(req, res);
}
}
