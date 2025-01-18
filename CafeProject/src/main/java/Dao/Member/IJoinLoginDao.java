package Dao.Member;

import java.util.List;
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
	
	/**
	 * 회원 리스트 -> 운영자일 경우는 출력X
	 * @param memvo
	 * @return
	 */
	public List<MemVO> getAllMember();
	
	/**
	 * 회원 리스트 업데이트 -> 운영자일 경우 수정x
	 * @param member
	 * @return
	 */
	public int updateMember(Map<String, String> member);
	
	/**
	 * 회원 리스트 보기 -> 업데이트에서
	 * @param memId
	 * @return
	 */
	public MemVO getMemberById(String memId);

	
}
