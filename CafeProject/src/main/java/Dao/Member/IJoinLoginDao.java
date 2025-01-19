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

	/**
	 * 회원 삭제
	 * @param mem_id
	 * @return
	 */
	public int deleteMember(String mem_id);
	
	/**
	 * 운영자가 블랙리스트 추가 
	 * @param memId
	 * @return
	 */
	public int blacklistMember(String memId);
	
	/**
	 * 운영자가 블랙리스트 해제
	 * @param memId
	 * @return
	 */
	public int unblacklistMember(String memId);

	/**
	 * 블랙리스트된 회원 정보 조회
	 */
	public List<MemVO> getBlacklistedMembers();

	
}
