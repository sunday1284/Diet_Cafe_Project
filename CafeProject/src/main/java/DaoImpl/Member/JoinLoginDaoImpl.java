package DaoImpl.Member;

import org.apache.ibatis.session.SqlSession;

import Dao.Member.IJoinLoginDao;
import Util.MybatisUtil;
import VO.MemVO;

public class JoinLoginDaoImpl implements IJoinLoginDao {
	
	private static JoinLoginDaoImpl dao;
	
	private JoinLoginDaoImpl() {
		
	}

	public static JoinLoginDaoImpl getInstance() {
		if(dao == null) 
			dao = new JoinLoginDaoImpl();
		return dao;
		
	}
	
	@Override
	public int joinMember(MemVO memvo) {
		int cnt = 0;
		SqlSession session = null;
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.insert("Member.joinMember", memvo);
			if(cnt>0) 
				session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
			session.close();
		}
		
		
		return cnt;
	}
	
}
