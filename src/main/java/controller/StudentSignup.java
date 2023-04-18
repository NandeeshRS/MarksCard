package controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.StudentDao;
import dao.TeacherDao;
import dto.Student;
import dto.Teacher;


@WebServlet("/studentsignup")
@MultipartConfig
public class StudentSignup extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String email=req.getParameter("email");
	long mobile=Long.parseLong(req.getParameter("pno"));
	StudentDao dao=new StudentDao();
	if(dao.find(email)==null && dao.find(mobile)==null){
	Student student=new Student();
	student.setPassword(req.getParameter("password"));
	student.setEmail(email);
	student.setMobile(mobile);
	student.setName(req.getParameter("name"));
	student.setStandard(Integer.parseInt(req.getParameter("std")));
	
	byte[] pic = null;
	Part filepart = req.getPart("pic");
	if (filepart != null) {
		InputStream inputStream = filepart.getInputStream();
		pic = new byte[inputStream.available()];
		inputStream.read(pic);
	}
	student.setPicture(pic);
	
	
	dao.Student1(student);
	
	Student student2=dao.find(student.getEmail());
	
	int reg=student2.getRegno();
	
	resp.getWriter().print("<h1>Account is created and your register number is "+reg+"</h1>");
	req.getRequestDispatcher("login.html").include(req, resp);
	}
	else{

		resp.getWriter().print("<h1>Account is already exsist</h1>");
		req.getRequestDispatcher("login.html").include(req, resp);
	}
		
}
}
