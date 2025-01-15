package Controller.Member;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import ServiceImpl.Member.JoinLoginServiceImpl;
import VO.MemVO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//회원 가입 관련 서블릿
@WebServlet("/join.do")
public class JoinServlet extends HttpServlet {
	
	private Map<String, MemVO> memtable = new HashMap<>();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String join = req.getParameter("join");
	
		//회원가입 관련 Attribute 생성 
//		req.setAttribute("joinCode", join);
		String path = "/WEB-INF/JoinLogin/join.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    MemVO memvo = new MemVO();
	    Map<String, String[]> parameterMap = req.getParameterMap();
	    try {
	        BeanUtils.populate(memvo, parameterMap);
	    } catch (IllegalAccessException | InvocationTargetException e) {
	        e.printStackTrace();
	        resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "데이터 처리 중 오류 발생");
	        return;
	    }
	    
	    memtable.put(memvo.getMem_id(), memvo);
	    memtable.put(memvo.getMem_pw(), memvo);
	    memtable.put(memvo.getMem_name(), memvo);
	    memtable.put(memvo.getMem_tel(), memvo);
	    memtable.put(memvo.getMem_bir(), memvo);
	    memtable.put(memvo.getMem_addr1(), memvo);
	    memtable.put(memvo.getMem_addr2(), memvo);
	    memtable.put(memvo.getMem_create(), memvo);
	    memtable.put(memvo.getMem_grd(), memvo);
	    
	    System.out.println(memvo);
	    JoinLoginServiceImpl service = JoinLoginServiceImpl.getInstance();
	    int cnt = service.joinMember(memvo);
	    
	    if (cnt > 0) {
	        resp.sendRedirect(req.getContextPath() + "/Login.do"); // 성공 시 이동할 페이지 -> 로그인 화면으로 이동
	    } else {
	        req.getRequestDispatcher("/WEB-INF/JoinLogin/join.jsp").forward(req, resp);
	    }
	}

}
