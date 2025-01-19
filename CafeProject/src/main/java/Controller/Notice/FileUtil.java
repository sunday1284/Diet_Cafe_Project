package Controller.Notice;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.crypto.Data;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

public class FileUtil {

	
	public static String uploadFile(HttpServletRequest req, String sDirectory) throws ServletException, IOException {
		
		Part part = req.getPart("ofile"); //클라이언트가 보낸 파일 데이터 가져옴
		String partHeader = part.getHeader("content-disposition");
		System.out.println("partHeader : == " + partHeader);
		String[] phArr = partHeader.split("filename=");
		System.out.println("phArr변환후 : "+phArr);
		String ofile = phArr[1].trim().replace("\"",""); //원본 파일명 추출
		System.out.println("ofile변환후 : "+ofile);
		
		if(!ofile.isEmpty()) {
			part.write(sDirectory + File.separator + ofile);
		} else {
			return null;
		}
		return ofile;
	}
	
	public static String renameFile(String sDirectory, String fileName) {
		
		if(fileName ==null || fileName.isEmpty() || !fileName.contains(".")) {
			return null;
		}
		
		
		String ext = fileName.substring(fileName.lastIndexOf("."));
		String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
		String newFileName = now + ext;
		
		File oldFile = new File(sDirectory + File.separator + fileName);
		File newFile = new File(sDirectory + File.separator + newFileName);
		oldFile.renameTo(newFile);
		
		
		return newFileName;
	}
}
