package Controller.Member;

import java.io.IOException;

import Dao.Member.IJoinLoginDao;
import DaoImpl.Member.JoinLoginDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/unblacklistMember.do")
public class UnblacklistMember extends HttpServlet {

    private IJoinLoginDao dao = JoinLoginDaoImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String memId = req.getParameter("mem_id");

        // 블랙리스트 해제 (데이터베이스 업데이트)
        int result = dao.unblacklistMember(memId);
        if (result > 0) {
            req.setAttribute("message", "회원이 블랙리스트에서 해제되었습니다.");
        } else {
            req.setAttribute("message", "회원 블랙리스트 해제 실패.");
        }

        // 블랙리스트 페이지로 리디렉션
        resp.sendRedirect(req.getContextPath() + "/blacklistView.do");
    }
}