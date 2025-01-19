<%@page import="java.io.FileNotFoundException"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String sDirectory = application.getRealPath("/Upload"); //서버 업로드 폴더 경로
	String sfileName = request.getParameter("sfile"); // 저장파일명 (서버에저장된)
	String ofileName = request.getParameter("ofile"); // 원본파일명 (사용자가 업로드한 파일명)
	
	try{
		File file = new File(sDirectory,sfileName);
		InputStream inStream = new FileInputStream(file); //파일을 읽기 위한 입력스트림
		
		//한글깨짐 방지
		String client = request.getHeader("User-Agent");
		if(client.indexOf("WOW64")== -1) {
			ofileName = new String(ofileName.getBytes("UTF-8"), "ISO-8859-1");
		} else {
			ofileName = new String(ofileName.getBytes("KSC5601"), "ISO-8859-1");
		}
		
		response.reset(); //기존응답초기화
		response.setContentType("application/octet-stream"); //파일다운로드 응답설정
		response.setHeader("Content-Disposition", "attachment; filename=\"" +ofileName + "\"");//파일명설정,  filename="파일명"
		response.setHeader("Content-Length",""+ file.length());//파일크기 설정
		
		//출력 스트림 초기화
		out.clear();
		
		OutputStream outStream = response.getOutputStream(); //사용자에게 보낼 출력 스트림 생성
		
		byte b[] = new byte[(int)file.length()]; //파일데이터 담을 버퍼 생성
		int readBuffer =0;
		while ((readBuffer = inStream.read(b)) > 0) { //파일데이터 읽기
			outStream.write(b,0,readBuffer); //데이터를 클라이언트로 전송
		}
		
		//입,출력 스트림  off
		inStream.close();
		outStream.close();
	}
	
	catch (FileNotFoundException e) {
// 		JSFunction.alertBack("파일을 찾을수 없습니다.", out);
	} 
	
	catch (Exception e) {
// 		JSFunction.alertBack("예외발생", out);
	}
%>

</body>
</html>