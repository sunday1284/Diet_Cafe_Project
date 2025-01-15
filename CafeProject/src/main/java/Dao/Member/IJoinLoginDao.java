package Dao.Member;

import VO.MemVO;

public interface IJoinLoginDao {
	
	/**
	 * 회원가입 
	 * @param memvo
	 * @return
	 */
	public int joinMember(MemVO memvo);
	
}
