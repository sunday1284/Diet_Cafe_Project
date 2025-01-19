package Controller.Member;

import java.io.IOException;

import Dao.Member.IJoinLoginDao;
import DaoImpl.Member.JoinLoginDaoImpl;
import VO.MemVO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/memDelete.do")
public class MemDelete extends HttpServlet {

	private IJoinLoginDao dao = JoinLoginDaoImpl.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		MemVO loginMember = (MemVO) session.getAttribute("loginMember");
		String userGrd = loginMember != null ? loginMember.getMem_grd() : null;
		String memId = req.getParameter("mem_id");

		String redirectPage = null;

		// 관리자일 경우
		if (userGrd != null && userGrd.equals("ADMIN")) {

			// 블랙리스트 등록 (데이터베이스 업데이트)
			int blacklistResult = dao.blacklistMember(memId);
			if (blacklistResult > 0) {
				// 블랙리스트 목록 페이지로 이동
				redirectPage = "/view/JoinLogin/blacklist.jsp";
			} else {
				resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "블랙리스트 등록 실패");
				return;
			}

		} else if (loginMember != null && loginMember.getMem_id().equals(memId)) {
			// 로그인한 회원이 자신의 계정을 삭제하는 경우 (회원 탈퇴)
			int deleteResult = dao.deleteMember(memId);
			if (deleteResult > 0) {
				session.invalidate();
				redirectPage = "/view/JoinLogin/MemDelete.jsp";
			} else {
				resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "회원 탈퇴 실패");
				return;
			}
		} else {
			resp.sendError(HttpServletResponse.SC_FORBIDDEN, "아무 권한이 없습니다.");
			return;
		}

		if (redirectPage != null) {
			resp.sendRedirect(req.getContextPath() + redirectPage);
		}
	}
}