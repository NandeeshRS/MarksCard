package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MarksCardDao;
import dto.MarksCard;

@WebServlet("/changestatus")
public class ChangeStatus extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	
	MarksCardDao carddao=new MarksCardDao();
	MarksCard  card=carddao.find(id);
	if(card.isStatus()){
		card.setStatus(false);
	}else{
		card.setStatus(true);
	}
	
	carddao.update(card);
	resp.getWriter().print("<h1>Status Updated</h1>");
	req.getRequestDispatcher("ApproveMarks.jsp").include(req, resp);
}
}
