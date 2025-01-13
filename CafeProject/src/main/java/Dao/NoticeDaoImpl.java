package Dao;

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

	
}
