package Dao.Member;

import java.util.Map;

import VO.MemVO;

public interface IJoinLoginDao {
	
	/**
	 * 회원가입 
	 * @param memvo
	 * @return
	 */
	public int joinMember(MemVO memvo);

	/**
	 * id 중복체크
	 */
	public int CheckId(String mem_id);

	/**
	 * 로그인 
	 */
	public MemVO getLoginMember(Map<String, String> map);
	
}
