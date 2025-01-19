package Controller.Notice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/downloadFile.do")
public class DownloadFile extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String sfile = req.getParameter("sfile");		
		String ofile = req.getParameter("ofile");
		
		String uploadPath = getServletContext().getRealPath("/Upload"); //서버에 저장된 파일 절대경로위치
		File file = new File(uploadPath, sfile);
		
		if(!file.exists()) {
			resp.getWriter().write("파일이 존재하지 않습니다.");
			return;
		}
		
		//한글 파일명처리
		String client = req.getHeader("User-Agent");
		if(client.indexOf("WOW64") == -1) {
			ofile = new String(ofile.getBytes("UTF-8"), "ISO-8859-1");
		} else {
			ofile = new String(ofile.getBytes("KSC5601"), "ISO-8859-1");
		}
		
		resp.reset();
		resp.setContentType("application/octet-strem");
		resp.setHeader("Content-Disposition", "attachment; filename=\"" + ofile + "\"");
		resp.setHeader("Content-Length", String.valueOf(file.length()));
		
		   try (FileInputStream inStream = new FileInputStream(file);
		             OutputStream outStream = resp.getOutputStream()) {
		            byte[] buffer = new byte[4096];
		            int bytesRead;
		            while ((bytesRead = inStream.read(buffer)) != -1) {
		                outStream.write(buffer, 0, bytesRead);
		            }
		        }
		    }
		}