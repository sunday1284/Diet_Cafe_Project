package Controller.Notice;

import java.io.IOException;

import com.fasterxml.jackson.core.util.RequestPayload;

import Service.NoticeServiceImpl;
import ServiceImpl.INoticeService;
import VO.noticeVO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/noticeInsert.do")
@MultipartConfig(
		maxFileSize = 1024 * 1024 * 1,
		maxRequestSize = 1024* 1024 * 1024 * 10
		)
public class NoticeInsertServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path ="/WEB-INF/Notice/InsertNotice.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path ="/noticeList.do";

		try {
			String saveDirectory = getServletContext().getRealPath("/Upload");
			String originalFileName = FileUtil.uploadFile(req, saveDirectory);
			String saveFileName = FileUtil.renameFile(saveDirectory, originalFileName);
			insertMyFile(req,originalFileName,saveFileName);
			resp.sendRedirect(req.getContextPath() + path);
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errorMessage", "파일 업로드 오류");
			req.getRequestDispatcher(path).forward(req, resp);
		}
		
	}
		private void insertMyFile(HttpServletRequest req, String ofile, String sfile) {
			String notice_title = req.getParameter("notice_title");
			String notice_content = req.getParameter("notice_content");
			String notice_type = req.getParameter("notice_type");
//			String ofile = req.getParameter("ofile");
			
			noticeVO noticeVo = new noticeVO();
			noticeVo.setNotice_title(notice_title);
			noticeVo.setNotice_type(notice_type);
			noticeVo.setOfile(ofile);
			noticeVo.setOfile(sfile);
			
			INoticeService service = NoticeServiceImpl.getInstance();
			System.out.println(noticeVo);
			service.insertNotice(noticeVo);
			
			
	}
}
