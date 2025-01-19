package ServiceImpl.Member;

import java.util.List;
import java.util.Map;

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
	@Override
	public int joinMember(MemVO memvo) {
		return dao.joinMember(memvo);
	}
	@Override
	public int CheckId(String mem_id) {
		return dao.CheckId(mem_id);
	}
	@Override
	public MemVO getLoginMember(Map<String, String> map) {
		return dao.getLoginMember(map);
		
	}
	@Override
	public List<MemVO> getAllMember(){
		return dao.getAllMember();	
	}
	@Override
	public int updateMember(Map<String, String> member) {
		return dao.updateMember(member);
	}
	@Override
	public MemVO getMemberById(String memId) {
		return dao.getMemberById(memId);
	}
	@Override
	public int deleteMember(String mem_id) {
		return dao.deleteMember(mem_id);
	}
	@Override
	public int blacklistMember(String memId) {
		return dao.blacklistMember(memId);
	}
	@Override
	public int unblacklistMember(String memId) {
		return dao.unblacklistMember(memId);
	}
	@Override
    public List<MemVO> getBlacklistedMembers()	{
		return dao.getBlacklistedMembers();
	}
}
