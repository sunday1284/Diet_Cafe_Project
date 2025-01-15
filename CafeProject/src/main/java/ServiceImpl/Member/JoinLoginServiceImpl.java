package ServiceImpl.Member;

import Dao.Member.IJoinLoginDao;
import DaoImpl.Member.JoinLoginDaoImpl;
import Service.Member.IJoinLoginService;
import VO.MemVO;

public class JoinLoginServiceImpl implements IJoinLoginService {
	private static JoinLoginServiceImpl service;
	
	private IJoinLoginDao dao;
	
	private JoinLoginServiceImpl() {
		dao = JoinLoginDaoImpl.getInstance();
	}
	
	public static JoinLoginServiceImpl getInstance() {
		if(service == null)
			service = new JoinLoginServiceImpl();
		return service;
	}
	
	public int joinMember(MemVO memvo) {
		return dao.joinMember(memvo);
	}
	
}
