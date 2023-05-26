package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import dto.Student;

public class SignupServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
//		int id;
//		String name;
//		String email;
//		long phone;
//		String password;
//		String Gender;
		
	Student student=new Student();
	student.setEmail(req.getParameter("email"));
	student.setGender(req.getParameter("gender"));
	student.setName(req.getParameter("name"));
	student.setPassword(req.getParameter("password"));
	student.setPhone(Long.parseLong(req.getParameter("phone")));
	
	StudentDao dao=new StudentDao();
	dao.save(student);
	
	resp.getWriter().print("<h1>data saved successfully </h1>");
	req.getRequestDispatcher("Login.html").include(req, resp);
	}

}
