package Controller.Member;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//회원 가입 관련 서블릿
@WebServlet("/join.do")
public class JoinServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String join = req.getParameter("join");
		
		
		//회원가입 관련 Attribute 생성 
		req.setAttribute("joinCode", join);
//		String path = "/WEB-INF/";
//		req.getRequestDispatcher(path).forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
}
