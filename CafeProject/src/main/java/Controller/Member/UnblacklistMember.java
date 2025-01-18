package Controller.Member;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/unblacklistMember.do")
public class UnblacklistMember extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String memId = req.getParameter("mem_id");

        // ServletContext에서 블랙리스트 가져오기
        Map<String, String> blacklist = (Map<String, String>) getServletContext().getAttribute("blacklist");
        if (blacklist != null && blacklist.containsKey(memId)) {
            // 블랙리스트에서 회원 제거
            blacklist.remove(memId);
            getServletContext().setAttribute("blacklist", blacklist);
        }

        // 블랙리스트 페이지로 리디렉션
        resp.sendRedirect(req.getContextPath() + "/view/JoinLogin/blacklist.jsp");
    }
}