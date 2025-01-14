package Controller;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;

import Dao.NoticeDaoImpl;
import Service.NoticeServiceImpl;
import ServiceImpl.INoticeService;
import VO.noticeVO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/notice.do")
public class NoticeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path ="/WEB-INF/notice.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		INoticeService service = NoticeServiceImpl.getInstance();
		
		//공지사항 제목, 내용, 카테고리
		String notice_title = req.getParameter("notice_title");
		String notice_content = req.getParameter("notice_content");
		String notice_type = req.getParameter("notice_type");
		
		noticeVO noticeVo = new noticeVO();
		noticeVo.setNotice_title(notice_title);
		noticeVo.setNotice_content(notice_content);
		noticeVo.setNotice_type(notice_type);
		
		int cnt = service.insertNotice(noticeVo);
		
		System.out.println(noticeVo);
		System.out.println(notice_title);
		System.out.println(notice_content);
		System.out.println(notice_type);
		
		
		if(StringUtils.isBlank(notice_title) ||
		   StringUtils.isBlank(notice_content) ||
		   StringUtils.isBlank(notice_type) ) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "필수입력값 누락");
		}
		
		
		if(cnt >0) {
			String path="/WEB-INF/notice.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
		} else {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "등록에 실패하였습니다.");
		}
		
		req.setAttribute("notice_title", notice_title);
		req.setAttribute("notice_content", notice_content);
		req.setAttribute("notice_type", notice_type);
		
		
	}
}
