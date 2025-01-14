package Dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import DaoImpl.INoticeDao;
import Util.MybatisUtil;
import VO.noticeVO;

public class NoticeDaoImpl implements INoticeDao {
	
	private static NoticeDaoImpl dao;
	private NoticeDaoImpl() {}
	
	public static NoticeDaoImpl getInstance() {
		if(dao==null) dao = new NoticeDaoImpl();
		
		return dao;
	}

	@Override
	public int insertNotice(noticeVO noticeVO) {
		SqlSession session = MybatisUtil.getSqlSession();
		
		int cnt =0;
		
		try {
			cnt = session.insert("Board.noticeInsert",noticeVO);
			if(cnt>0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("공지사항 등록에 실패했습니다.");
		} finally {
			if(session != null) session.close();
		}
		return cnt;
	}

	@Override
	public List<noticeVO> getAllNotice() {
		SqlSession session = MybatisUtil.getSqlSession();
		
		List<noticeVO>noticeList = null;
		
		try {
		
			noticeList = session.selectList("Board.getAllNotice");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("공지조회 실패");
		} finally {
			if(session != null) session.close();
		}
		
		return noticeList;
		
	}

	
}
