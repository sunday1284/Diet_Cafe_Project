package Controller.Notice;

import java.io.IOException;
import java.util.List;

import Service.NoticeServiceImpl;
import ServiceImpl.INoticeService;
import VO.noticeVO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/noticeList.do")
public class NoticeListServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		INoticeService service = NoticeServiceImpl.getInstance();
		
		String notice_no = req.getParameter("notice_no");
		
		List<noticeVO> noticeList = service.getAllNotice();
		req.setAttribute("noticeList", noticeList);
		
		System.out.println("회원조회 서블릿:" + noticeList);
		System.out.println("회원조회 notice_no:" + notice_no);
		
		
		
		String path="/WEB-INF/Notice/getAllNotice.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	
	}

	
	
}
