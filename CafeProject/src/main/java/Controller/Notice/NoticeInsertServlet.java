package Controller.Notice;

import java.io.IOException;

import com.fasterxml.jackson.core.util.RequestPayload;

import Service.Notice.NoticeServiceImpl;
import ServiceImpl.Notice.INoticeService;
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
		String path ="/WEB-INF/Notice/noticeInsert.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path ="/noticeList.do";

		try {
			//getServletContext().getRealPath= Upload폴더의 절대경로 검색
			String savefile = getServletContext().getRealPath("/Upload");
			System.out.println(getServletContext().getRealPath("/Upload"));
			System.out.println(getServletContext().getRealPath("/uploads"));
			
			//파일명이 20252424.jpg로 반환
			String ofile = FileUtil.uploadFile(req, savefile);
			System.out.println("ofile 값확인 == " + ofile);
			String sfile = FileUtil.renameFile(savefile, ofile);
			System.out.println("sfile 값확인 ==" + sfile);
			
			
			insertMyFile(req,ofile,sfile);
			
			resp.sendRedirect(req.getContextPath() + path);
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errorMessage", "파일 업로드 오류");
			req.getRequestDispatcher(path).forward(req, resp);
			
		}
		
	}
		private void insertMyFile(HttpServletRequest req, String ofile, String sfile) {
			INoticeService service = NoticeServiceImpl.getInstance();
			noticeVO noticeVo = new noticeVO();
			
			String notice_title = req.getParameter("notice_title");
			String notice_content = req.getParameter("notice_content");
			String notice_type = req.getParameter("notice_type");
			
			if(ofile ==null || ofile.isEmpty()) {
				noticeVo.setNotice_title(notice_title);
				noticeVo.setNotice_content(notice_content);
				noticeVo.setNotice_type(notice_type);
			} else {
				noticeVo.setNotice_title(notice_title);
				noticeVo.setNotice_content(notice_content);
				noticeVo.setNotice_type(notice_type);
				noticeVo.setOfile(ofile); //원본파일저장 (흰둥이)
				noticeVo.setSfile(sfile);
				
			}
			System.out.println(noticeVo);
			service.insertNotice(noticeVo);
			
	}
}
