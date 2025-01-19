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

@WebServlet("/detailNotice.do")
public class NoticeDetailServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/WEB-INF/Notice/detailNotice.jsp";
		
		INoticeService service = NoticeServiceImpl.getInstance();
		
        // 공지사항 번호를 요청 파라미터에서 가져오기
        String notice_no = req.getParameter("notice_no");
        System.out.println("디테일서블릿 notice_no : " + notice_no);
        
        // notice_no가 없으면 오류 처리
        if (notice_no == null || notice_no.isEmpty()) {
            resp.sendRedirect(req.getContextPath() +"/noticeList.do");
            System.out.println("여기들어오나..?");
            return;
        }
        // 서비스 객체 가져오기

        // notice_no를 기반으로 공지사항 상세 조회
//        noticeVO detailNotice = (noticeVO) service.DetailNotice(notice_no);
        noticeVO detailNotice = service.DetailNotice(notice_no); 
        
//        noticeVO detailNotice = new noticeVO();
//        detailNotice.setNotice_no(notice_no);
//        detailNotice = service.DetailNotice(notice_no);
        System.out.println("디테일서블릿(VO확인) detailNotice : " + detailNotice);

        // 조회 결과를 JSP에 전달
        req.setAttribute("detailNotice", detailNotice);
        System.out.println("디테일서블릿(VO확인) detailNotice : " + detailNotice);

        // 상세보기 JSP로 포워딩
        req.getRequestDispatcher(path).forward(req, resp);
		
		
	}

}
