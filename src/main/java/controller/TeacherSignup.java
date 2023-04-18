package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TeacherDao;
import dto.Student;
import dto.Teacher;

@WebServlet("/teachersignup1")
public class TeacherSignup extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String email=req.getParameter("email");
	 long mobile=Long.parseLong(req.getParameter("pno"));
	 TeacherDao dao2=new TeacherDao();
	 if(dao2.find(email)==null && dao2.find(mobile)==null){
	Teacher teacher=new Teacher();
	teacher.setName(req.getParameter("name"));
	teacher.setEmail(email);
	teacher.setP_no(mobile);
	teacher.setSubject(req.getParameter("subject"));
	teacher.setPassword(req.getParameter("psw"));
	
	
	dao2.Teacher1(teacher);
	
	
	Teacher teacher2=dao2.find(teacher.getEmail());
	
	int id=teacher2.getEmployeeid();
	
	resp.getWriter().print("<h1>Account is created and your register number is "+id+"</h1>");
	req.getRequestDispatcher("login.html").include(req, resp);
	}
	 else{

			resp.getWriter().print("<h1>Account is already exsist</h1>");
			req.getRequestDispatcher("login.html").include(req, resp);
		}
}
}
