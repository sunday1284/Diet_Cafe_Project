package Util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	
private static SqlSessionFactory factory;
	
	static {
		// MyBatis의 환경 설정 파일(mybatis-config.xml)을 읽어와서
		// 그 내용을 처리한 후 SqlSessionFactory객체를 생성한다. 뭐지???
		Reader rd = null;
		
		try {
			// 1-1. 환경 설정 파일을 읽어올 스트림 객체를 생성한다.
			rd = Resources.getResourceAsReader("kr/or/ddit/mybatis/config/mybatis-config.xml");
			// 1-2 환경 설정 파일을 읽어와 환경 설정을 진행하고 환경 설정이 완료되면
			//		SqlSessionFactory 객체가 생성된다.
			factory = new SqlSessionFactoryBuilder().build(rd);
			
		} catch (Exception e) {
			System.out.println(rd);
			System.out.println("MyBatis 초기화 실패!!!");
			e.printStackTrace();
		} finally {
			// 스트림 닫기
			if(rd!=null) try { rd.close(); }catch(IOException e) {}
		}
	}
	
	// SqlSession객체를 반환하는 메서드
	public static SqlSession getSqlSession() {
		SqlSession session = factory.openSession();
		
		return session;

	}
}
