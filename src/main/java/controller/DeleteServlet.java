package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException
	{
		int id=Integer.parseInt(req.getParameter("id"));
		StudentDao dao=new StudentDao();
		dao.delete(id);
		
		resp.getWriter().print("<h1> DELETED SUCCESSFULLY</h1>");
		req.getRequestDispatcher("Home.html").include(req, resp);
	}
	
	
	

}
