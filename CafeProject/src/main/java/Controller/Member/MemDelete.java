package Controller.Member;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        MemVO loginMember = (MemVO) session.getAttribute("loginMember"); // Cast to MemVO
        String userGrd = loginMember != null ? loginMember.getMem_grd() : null;
        String memId = req.getParameter("mem_id");

        String redirectPage = null; // 리디렉션할 페이지를 저장할 변수

        // 관리자일 경우
        if (userGrd != null && userGrd.equals("ADMIN")) {
            // 관리자 -> 회원 삭제 및 블랙리스트 등록
            int deleteResult = dao.deleteMember(memId);
            if (deleteResult > 0) {
                // 블랙리스트 등록
                Map<String, String> blacklist = (Map<String, String>) getServletContext().getAttribute("blacklist");
                if (blacklist == null) {
                    // 블랙리스트 값이 없을 때 새로운 맵 객체 생성
                    blacklist = new HashMap<>();
                }
                blacklist.put(memId, "Blacklisted");
                getServletContext().setAttribute("blacklist", blacklist);

                // 블랙리스트 목록 페이지로 이동
                redirectPage = "/view/JoinLogin/blacklist.jsp";
            } else {
                // 오류 처리
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "회원 삭제 실패");
                return;
            }
        } else if (loginMember != null && loginMember.getMem_id().equals(memId)) {
            // 로그인한 회원이 자신의 계정을 삭제하는 경우 (회원 탈퇴)
            int deleteResult = dao.deleteMember(memId);
            if (deleteResult > 0) {
                session.invalidate(); // 세션 무효화
                redirectPage = "/view/JoinLogin/MemDelete.jsp";
            } else {
                // 오류 처리
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "회원 탈퇴 실패");
                return;
            }
        } else {
            // 권한 없을 경우
            resp.sendError(HttpServletResponse.SC_FORBIDDEN, "아무 권한이 없습니다.");
            return; // 추가 코드 실행 방지
        }

        // 리디렉트 페이지로 이동
        if (redirectPage != null) {
            resp.sendRedirect(req.getContextPath() + redirectPage);
        }
    }
}