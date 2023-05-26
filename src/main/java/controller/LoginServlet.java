
package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.border.Border;

import dao.StudentDao;
import dto.Student;
import java.util.List;


	@WebServlet(urlPatterns="/login",loadOnStartup=1)
	public class LoginServlet extends HttpServlet{
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String email=req.getParameter("email");
			String password=req.getParameter("password");
			
			StudentDao dao= new StudentDao();
			Student student;
			
			try{
				long mobile=Long.parseLong(email);
				student =dao.fetch(mobile);
			}
			catch(NumberFormatException e){
				student =dao.fetch(email);
			}
			if(student==null)
			{
				resp.getWriter().print("<h1>invalid password");
				req.getRequestDispatcher("Login.html").include(req, resp);
			}
			else{
				if(student.getPassword().equals(password))
				{
					resp.getWriter().print("<h1>login success</h1>");
					req.setAttribute("student", student);
					req.setAttribute("list", dao.fetch());
					req.getRequestDispatcher("Success.jsp").include(req, resp);
					
					
//					resp.getWriter().print("<div>");
//					
//					resp.getWriter().print("<table Border='1'>"
//					+"<tr>"
//					+"<th>Id</th>"
//					+"<th>Name</th>"
//					+"<th>Email</th>"
//					+"<th>Mobile</th>"
//					+"<th>Password</th>"
//					+"</tr>"
//							
//                   +"<tr>"
//                   +"<th>"+student.getId()+"</th>"
//                   +"<th>"+student.getName()+"</th>"
//                   +"<th>"+student.getEmail()+"</th>"
//                   +"<th>"+student.getPhone()+"</th>"
//                   +"<th>"+student.getPassword()+"</th>"
//                   +"</tr>"
//                   +"</table>");
					
			}
				else{
					resp.getWriter().print("<h1>invalid password</h1>");
					req.getRequestDispatcher("Login.html").include(req, resp);
				}
			
		}
		
		}
	}


