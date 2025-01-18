package Controller.Member;

import java.io.IOException;
import java.util.List;

import Service.Member.IJoinLoginService;
import ServiceImpl.Member.JoinLoginServiceImpl;
import VO.MemVO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/memList.do")
public class MemList extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		//회원 리스트 
		IJoinLoginService service = JoinLoginServiceImpl.getInstance();
		//서비스에서 회원 리스트를 가져옴
		List<MemVO> memList = service.getAllMember();
		
		//회원 리스트를 attribute에 저장
		req.setAttribute("memList", memList);
		
		//forward로 보내줌
		String path = "/view/JoinLogin/MemberBoard.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}
}
