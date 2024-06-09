package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String date = req.getParameter("dob");
	    Date dob =Date.valueOf(date);
	    int status = 0;
		String role = "voter";
		
		
		try(UserDao userDao = new UserDaoImpl()){
			User u1 = new User(firstName, lastName,email, password,dob,status,role);
			
			int save = userDao.save(u1);
			if(save != 0) {
				resp.setContentType("text/html");
				PrintWriter out=resp.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Successful registration</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("Registration done successfully!!</br></br>");
				out.println("<a href = 'index.html'>Login Again</a>");
				out.println("</body>");
				out.println("</html>");
				
			}
			else {
				resp.setContentType("text/html");
				PrintWriter out = resp.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Registration failed<title>");
				out.println("</head>");
				out.println("<body>");
				out.println("Please fill all information</br></br>");
				out.println("<a href = 'index.html'>Login Again</a>");
				out.println("</body>");
				out.println("</html>");
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		
	}

}
