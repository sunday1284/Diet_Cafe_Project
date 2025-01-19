package Controller.Member;

import java.io.IOException;

import Dao.Member.IJoinLoginDao;
import DaoImpl.Member.JoinLoginDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//운영자 -> 회원 블랙리스트 추가 
@WebServlet("/blacklistMember.do")
public class BlacklistMemberServlet extends HttpServlet{
	
	private IJoinLoginDao dao = JoinLoginDaoImpl.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String memId = req.getParameter("mem_id");
		
		//블랙리스트 등록
		int result = dao.blacklistMember(memId);
		if (result > 0) {
			req.setAttribute("message", "회원이 블랙리스트에 추가되었습니다.");
		}else {
			req.setAttribute("message", "회원 블랙리스트 추가 실패");
		}
		
		 // 블랙리스트 페이지로 리디렉션
        resp.sendRedirect(req.getContextPath() + "/blacklistView.do");
	}
}
