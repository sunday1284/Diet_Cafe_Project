package Dao.Notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import DaoImpl.Notice.INoticeDao;
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
			System.out.println("(다오)공지조회 실패");
		} finally {
			if(session != null) session.close();
		}
		
		return noticeList;
		
	}

	@Override
	public noticeVO DetailNotice(String notice_no) {
		SqlSession session = MybatisUtil.getSqlSession();
		noticeVO detailNotice = null;
		
		try {
			detailNotice = session.selectOne("Board.DetailNotice", notice_no);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("(다오)상세조회 실패");
		}finally {
			if(session != null) session.close();
		}
		
		return detailNotice;
	}

	@Override
	public int CountViewNotice(String notice_no) {
		SqlSession session = MybatisUtil.getSqlSession();
		int CountVieCnt = 0;
		
		try {
			CountVieCnt = session.update("Board.CountViewNotice",notice_no);
			if(CountVieCnt>0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("(다오)조회수 증가 실패");
		} finally {
			if(session != null) session.close();
		}
		
		return CountVieCnt;
	}

	
}
