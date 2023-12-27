package com.servletlogin;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/userlogin", "/users"})
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getRequestURI().endsWith("/userlogin")) {
			doPost(request, response);
		}else {
			doGet(request, response);
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println("username: "+username);
		LoginDao login = new LoginDao();
		
		if(login.checkUser(username, password)) {
			
			HttpSession session = request.getSession();
			session.setAttribute("user", username);
			response.sendRedirect("home.jsp");
		}else {
			response.sendRedirect("login.jsp");
		}
		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		LoginDao data = new LoginDao();
		List<Person> users = data.getUsers();
		request.setAttribute("users", users);
		request.getRequestDispatcher("users.jsp").forward(request, response);
		
	}

}
