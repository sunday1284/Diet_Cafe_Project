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

        String userId = req.getParameter("mem_id");
        String userPw = req.getParameter("mem_pw");
        
        System.out.println("UserID: " + userId); // 디버깅 라인 
        System.out.println("UserPW: " + userPw); // 디버깅 라인
        //MemVO에서 받아왔었는데 자꾸 오류나서 삽질 
        //map으로 다오 서비스 바꿔주고 파라미터로 받고,
        // 서블릿에서 put으로 입력한 값을 지정해줘야 로그인이 성공함!
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
        } 
        // 로그인  실패 -> 리다이렉트
        resp.sendRedirect(req.getContextPath() + "/view/JoinLogin/LoginForm.jsp");
    }
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	//get으로 데이터를 요청한것을 post에다가 담아주고, jsp에서 post로 요청하면 
    	//로그인 로그아웃 둘다 가능한 상태가 된다.
    	doGet(req, resp);
    }
}
