package Controller.Member;

import java.io.IOException;
import java.util.List;
import java.util.Collections;

import Service.Member.IJoinLoginService;
import ServiceImpl.Member.JoinLoginServiceImpl;
import VO.MemVO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/memList.do")
public class MemList extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        
        // 세션에서 로그인된 회원 정보 가져오기
        HttpSession session = req.getSession();
        MemVO loginMember = (MemVO) session.getAttribute("loginMember");
        
        // 서비스 객체 생성
        IJoinLoginService service = JoinLoginServiceImpl.getInstance();
        
        if (loginMember != null) {
            List<MemVO> memList;
            // 관리자인 경우
            if ("ADMIN".equals(loginMember.getMem_grd())) {
                // 전체 회원 리스트를 가져옴
                memList = service.getAllMember();
            } else {
                // 본인의 정보만 리스트에 추가
                memList = Collections.singletonList(loginMember);
            }
            
            // 회원 리스트를 attribute에 저장
            req.setAttribute("memList", memList);
            
            // forward로 보내줌
            String path = "/view/JoinLogin/MemberBoard.jsp";
            req.getRequestDispatcher(path).forward(req, resp);
        } else {
            // 로그인 정보가 없을 경우 로그인 페이지로 리다이렉트
            resp.sendRedirect(req.getContextPath() + "/view/JoinLogin/LoginForm.jsp");
        }
    }
}