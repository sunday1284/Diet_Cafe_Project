package Controller.Member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import Service.Member.IJoinLoginService;
import ServiceImpl.Member.JoinLoginServiceImpl;
import VO.MemVO;

@WebServlet("/memUpdate.do")
public class MemUpdate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        
        // 세션에서 로그인된 회원 정보 가져오기
        HttpSession session = req.getSession();
        MemVO loginMember = (MemVO) session.getAttribute("loginMember");

        if (loginMember != null) {
            // 운영자인 경우 특정 회원의 ID를 통해 해당 회원의 정보를 가져옴
            String memId = req.getParameter("mem_id");
            if ("ADMIN".equals(loginMember.getMem_grd()) && memId != null) {
                IJoinLoginService service = JoinLoginServiceImpl.getInstance();
                MemVO member = service.getMemberById(memId);
                if (member != null) {
                    req.setAttribute("member", member);
                } else {
                    req.setAttribute("error", "존재하지 않는 회원입니다.");
                }
            } else {
                // 일반 회원인 경우 자신의 정보를 가져옴
                req.setAttribute("member", loginMember);
            }
            req.getRequestDispatcher("/view/JoinLogin/MemUpdate.jsp").forward(req, resp); // JSP 페이지로 포워딩
        } else {
            resp.sendRedirect(req.getContextPath() + "/view/JoinLogin/LoginForm.jsp"); // 로그인 페이지로 리다이렉트
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        // 입력값 가져오기
        String memId = req.getParameter("mem_id");
        String memPw = req.getParameter("mem_pw");
        String memName = req.getParameter("mem_name");
        String memTel = req.getParameter("mem_tel");
        String memAddr1 = req.getParameter("mem_addr1");
        String memAddr2 = req.getParameter("mem_addr2");

        // 기존 값 유지 로직
        IJoinLoginService service = JoinLoginServiceImpl.getInstance();
        MemVO existingMember = service.getMemberById(memId); // 기존 회원 정보 가져오기

        if (existingMember != null) {
            // 업데이트 값 셋팅
            Map<String, String> member = new HashMap<>();
            member.put("mem_id", memId);
            member.put("mem_pw", memPw);
            member.put("mem_name", memName);
            member.put("mem_tel", memTel);
            member.put("mem_addr1", memAddr1);
            member.put("mem_addr2", memAddr2);

            // 업데이트 수행
            int result = service.updateMember(member);

            if (result > 0) {
                resp.sendRedirect(req.getContextPath() + "/memList.do"); // 성공 시 회원 목록으로 리다이렉트
            } else {
                req.setAttribute("error", "회원 정보 업데이트에 실패했습니다.");
                req.getRequestDispatcher("/view/JoinLogin/MemUpdate.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("error", "존재하지 않는 회원입니다.");
            req.getRequestDispatcher("/view/JoinLogin/MemUpdate.jsp").forward(req, resp);
        }
    }
}