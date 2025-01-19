package Controller.Member;

import java.io.IOException;

import com.google.gson.Gson;

import VO.MemVO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//로그인 했을때 해당 회원의 정보가 ~~님으로 보임 ->비동기 
@WebServlet("/getLoginMemberInfo.do")
public class GetLoginMemberInfo extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		MemVO loginMember =(MemVO) session.getAttribute("loginMember");
		//json 파싱 작업
		resp.setContentType("application/json");
		resp.setCharacterEncoding("utf-8");
		//로그인을 하면 해당 회원 정보를 json객체에 담음
		if(loginMember != null) {
			Gson gson = new Gson();
			String json = gson.toJson(loginMember);
			resp.getWriter().write(json);
		}else {
			//로그인 실패시
			resp.getWriter().write("{}");
		}
	}
}
