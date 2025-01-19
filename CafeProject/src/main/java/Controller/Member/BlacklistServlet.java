package Controller.Member;

import java.io.IOException;
import java.util.List;

import Dao.Member.IJoinLoginDao;
import DaoImpl.Member.JoinLoginDaoImpl;
import VO.MemVO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/blacklistView.do")
public class BlacklistServlet extends HttpServlet {
	
	private IJoinLoginDao dao = JoinLoginDaoImpl.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//블랙 리스트 회원 정보 조회 
		List<MemVO> blacklist = dao.getBlacklistedMembers();
		
		//블랙 리스트 회원 정보를 담아줌
		req.setAttribute("blacklist", blacklist);
		
		//jsp로 포워딩
		req.getRequestDispatcher("/view/JoinLogin/blacklist.jsp").forward(req, resp);
	}
}
