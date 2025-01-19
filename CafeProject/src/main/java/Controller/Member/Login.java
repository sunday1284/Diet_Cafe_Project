package Controller.Member;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import Service.Member.IJoinLoginService;
import ServiceImpl.Member.JoinLoginServiceImpl;
import VO.MemVO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Login.do")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        
        // 로그인 폼 페이지로 포워딩
        req.getRequestDispatcher("/view/JoinLogin/LoginForm.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String userId = req.getParameter("mem_id");
        String userPw = req.getParameter("mem_pw");
        
        System.out.println("UserID: " + userId); // 디버깅 라인 
        System.out.println("UserPW: " + userPw); // 디버깅 라인

        Map<String, String> map = new HashMap<>();
        map.put("mem_id", userId);
        map.put("mem_pw", userPw);
        IJoinLoginService service = JoinLoginServiceImpl.getInstance();

        MemVO loginMemberVO = service.getLoginMember(map);

        // 세션 초기값 생성
        HttpSession session = req.getSession();

        if (loginMemberVO != null) {
            // 세션에 로그인 할 회원 정보 저장
            session.setAttribute("loginMember", loginMemberVO);
            
            //운영자 조건 확인 
            if("ADMIN".equals(loginMemberVO.getMem_grd())) {          	
                //운영자 페이지
                resp.sendRedirect(req.getContextPath() + "/memList.do");
                return;
            } else {
                //운영자가 아닐때 
                resp.sendRedirect(req.getContextPath() + "/memList.do");
                return;
            }
        } else {
            // 로그인 실패 -> 리다이렉트 경로 확인
            System.out.println("로그인 실패: 아이디 또는 비밀번호가 올바르지 않습니다."); // 디버깅 라인
            resp.sendRedirect(req.getContextPath() + "/Login.do");
        }
    }
}