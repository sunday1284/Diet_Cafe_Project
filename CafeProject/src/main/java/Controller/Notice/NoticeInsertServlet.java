package Controller.Notice;

import java.io.File;
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
import jakarta.servlet.http.Part;

@WebServlet("/notice.do")
public class NoticeInsertServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path ="/WEB-INF/Notice/notice.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		INoticeService service = NoticeServiceImpl.getInstance();
		
		//파일이 저장될 서버 경로
		String uploadPath = "D:/Webcafe";
		
		File uploadDir = new File(uploadPath);
		if(!uploadDir.exists()) {
			uploadDir.mkdirs();
		}
		
		//공지사항 제목, 내용, 카테고리
		String notice_title = req.getParameter("notice_title");
		String notice_content = req.getParameter("notice_content");
		String notice_type = req.getParameter("notice_type");
		String ofile = req.getParameter("ofile");
		
		noticeVO noticeVo = new noticeVO();
		noticeVo.setNotice_title(notice_title);
		noticeVo.setNotice_content(notice_content);
		noticeVo.setNotice_type(notice_type);
		noticeVo.setOfile(ofile);
		
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
		
		//파일넘길 파라미터값
		Part part = req.getPart("ofile");
		
		if(part!=null) {
			String fileName = extractFilename(part);
			try {
				part.write(uploadPath + File.separator + fileName);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
		if(cnt >0) {
			String path="/WEB-INF/Notice/notice.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
		} else {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "등록에 실패하였습니다.");
		}
		
		req.setAttribute("notice_title", notice_title);
		req.setAttribute("notice_content", notice_content);
		req.setAttribute("notice_type", notice_type);
	}
	
	
	private String extractFilename(Part part) {
		String fileName="";
		
		String contentDisposition = part.getHeader("content-disposition");
		String[] items = contentDisposition.split(";");
		
		for(String item : items) {
			if(item.trim().startsWith("fileName")) {
				fileName = item.substring(item.indexOf("=")+2, item.length()-1);
			}
		}
		
		return fileName;
	}
}
