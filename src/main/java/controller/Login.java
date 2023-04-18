package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import dao.TeacherDao;
import dto.Student;
import dto.Teacher;

@WebServlet("/login1")
public class Login extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int empreg= Integer.parseInt(req.getParameter("emph"));
	String password=req.getParameter("password");
	RequestDispatcher dispatcher=req.getRequestDispatcher("login.html");
	
	StudentDao dao=new StudentDao();
	TeacherDao dao2=new TeacherDao();
	
	Teacher teacher=dao2.find(empreg);
	
	if(teacher==null){
		Student student=dao.find(empreg);
		if(student==null){
			resp.getWriter().print("<h1> Incorrect Regnumber or Employee Number</h1>");
			dispatcher.include(req, resp);
		}else{
			if(student.getPassword().equals(password)){
				req.getSession().setAttribute("student", student);
				resp.getWriter().print("<h1>Student login successfull</h1>");
				req.getRequestDispatcher("StudentHome.jsp").include(req, resp);
			}else{
				resp.getWriter().print("<h1>Incorrect Password</h1>");
				dispatcher.include(req, resp);
			}
		}
	}else{
		if(teacher.getPassword().equals(password)){
			resp.getWriter().print("<h1>Teacher login successfull</h1>");
			req.getRequestDispatcher("TeacherHome.jsp").include(req, resp);
		}else{
			resp.getWriter().print("<h1>Incorrect Password</h1>");
			dispatcher.include(req, resp);
		}
	}
}
}
