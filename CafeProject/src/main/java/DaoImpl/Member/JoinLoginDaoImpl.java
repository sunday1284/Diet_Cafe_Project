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

}
