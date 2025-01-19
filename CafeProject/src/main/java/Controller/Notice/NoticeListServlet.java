package Controller.Notice;

import java.io.IOException;
import java.util.List;

import Service.Notice.NoticeServiceImpl;
import ServiceImpl.Notice.INoticeService;
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
		
		
		List<noticeVO> noticeList = service.getAllNotice();
		req.setAttribute("noticeList", noticeList);
		
		System.out.println("게시판조회 서블릿:" + noticeList);
		
		
		
		String path="/WEB-INF/Notice/noticeList.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	
	}

	
	
}
