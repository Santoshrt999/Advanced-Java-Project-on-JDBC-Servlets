package servletsjdbc.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servletsjdbc.model.Registration;
import servletsjdbc.repository.RepositoryDAO;

public class RegistrationServlet extends HttpServlet {
	
	private String admin_email = null;
    private String City = null;
	public void init() {
		System.out.println("Register servlet loaded");
		ServletConfig sc = getServletConfig();
				ServletContext sctx = sc.getServletContext();
				City = getServletConfig().getInitParameter("city");
			admin_email = 	sctx.getInitParameter("admin-email");
		}
public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
	
	
	String name = req.getParameter("fullname");
	String email = req.getParameter("email");
	String uname = req.getParameter("username");
	String pass = req.getParameter("password");
	String congf = req.getParameter("confirm passcode");

	String validation = null;
	if(!pass.equals(congf)) {
		
		validation = "Password's dont match";
		
	}

if(validation != null) {
	req.setAttribute("validationInfo", validation);
}else {	
	Registration rd = new Registration();
	rd.setFullname(name);
	rd.setEmail(email);
	rd.setUsername(uname);
	rd.setPassword(pass);

	
	RepositoryDAO repdao = new RepositoryDAO();
	int result = repdao.saveRegistrationDetails(rd);
if(result == 1) {
		req.setAttribute("validationInfo", "Successful");
		req.setAttribute("City","city");
		req.setAttribute("ADMIN-DETAILS", "admin_email");
		
	}else {
		req.setAttribute("validationInfo", "failed to store!, try later");
		req.setAttribute("City","city");
		req.setAttribute("ADMIN-DETAILS", "admin_email");
		
	}
}


RequestDispatcher rd = req.getRequestDispatcher("RegistartionStatus.jsp");
rd.forward(req,res);
}	
}
