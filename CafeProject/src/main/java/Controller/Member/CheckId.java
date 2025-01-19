package Controller.Member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import ServiceImpl.Member.JoinLoginServiceImpl;



/**
 * Id중복체크 서블릿 -> 비동기
 */
@WebServlet("/CheckId.do")
public class CheckId extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memId = request.getParameter("mem_id");
		JoinLoginServiceImpl service = JoinLoginServiceImpl.getInstance();
		
		int IdCheck = service.CheckId(memId);
		
		if(IdCheck>0) {
			response.getWriter().write("duplicate");//중복
		}else {
			response.getWriter().write("available"); //사용 가능 
		}
	}

}
