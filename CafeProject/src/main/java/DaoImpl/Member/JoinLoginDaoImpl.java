package DaoImpl.Member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import Dao.Member.IJoinLoginDao;
import Util.MybatisUtil;
import VO.MemVO;

public class JoinLoginDaoImpl implements IJoinLoginDao {

	private static JoinLoginDaoImpl dao;

	private JoinLoginDaoImpl() {

	}

	public static JoinLoginDaoImpl getInstance() {
		if (dao == null)
			dao = new JoinLoginDaoImpl();
		return dao;

	}

	/**
	 * 회원가입
	 */
	@Override
	public int joinMember(MemVO memvo) {
		int cnt = 0;
		SqlSession session = null;
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.insert("Member.joinMember", memvo);
			if (cnt > 0)
				session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}

		return cnt;
	}

	/**
	 * id 중복체크
	 */
	@Override
	public int CheckId(String mem_id) {
		int cnt = 0;
		SqlSession session = null;
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.selectOne("Member.checkId", mem_id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return cnt;

	}

	/**
	 * 로그인
	 */
	@Override
	public MemVO getLoginMember(Map<String, String> map) {
		SqlSession session = null;
		MemVO loginmemVO = null;
		try {
			session = MybatisUtil.getSqlSession();
			loginmemVO = session.selectOne("Member.getLoginMember", map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return loginmemVO;
	}
	
	/**
	 * 회원 리스트 -> 운영자일 경우는 출력X
	 */
	@Override
	public List<MemVO> getAllMember() {
		SqlSession session = null;
		List<MemVO> memList = null;
		try {
			session = MybatisUtil.getSqlSession();
			memList = session.selectList("Member.getAllMember");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}

		return memList;

	}
	@Override
	public MemVO getMemberById(String memId) {
		SqlSession session = null;
		MemVO memvo = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			memvo = session.selectOne("Member.getMemberById",memId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null)
				session.close();
		}
		
		return memvo;
		
	}
	
	@Override
	public int updateMember(Map<String, String> member) {
		SqlSession session = null;
		int result = 0;
		
		try {
			session = MybatisUtil.getSqlSession();
			result = session.update("Member.updateMember", member);
			if(result>0)
				session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null)
				session.close();
		}
		
		
		return result;
		
	}
	
	@Override
	public int deleteMember(String mem_id) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.delete("Member.deleteMember", mem_id);
			if(cnt>0)
				session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("회원 삭제 실패 오류~");
		}finally {
			if(session != null)
				session.close();
		}
		
		return cnt;
		
	}
	
	/**
	 * 운영자가 블랙리스트 추가 
	 * @param memId
	 * @return
	 */
	@Override
	public int blacklistMember(String memId) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.update("Member.blacklistMember", memId);
			if(cnt > 0)
				session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (session != null)
				session.close();
		}
		
		return cnt;
		
	}
	
	/**
	 * 운영자가 블랙리스트 해제
	 */
	@Override
	public int unblacklistMember(String memId) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.update("Member.unblacklistMember", memId);
			if(cnt > 0)
				session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (session != null)
				session.close();
		}
		
		return cnt;
	}
	
	/**
     * 블랙리스트된 회원 정보 조회
     */
    @Override
    public List<MemVO> getBlacklistedMembers() {
    	List<MemVO> list = null;
    	SqlSession session = null;
    	try {
			session = MybatisUtil.getSqlSession();
			list = session.selectList("Member.getBlacklistedMembers");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (session != null)
				session.close();
		}
    	
		return list;
    	
    }

}
