package Service.Member;

import java.util.List;
import java.util.Map;

import VO.MemVO;

public interface IJoinLoginService {
	/**
	 * 회원가입
	 * @param memvo
	 * @return
	 */
	public int joinMember(MemVO memvo);
	/**
	 * id 중복 체크
	 * @param mem_id
	 * @return
	 */
	public int CheckId(String mem_id);
	/**
	 * 로그인 
	 * @param map
	 * @return
	 */
	public MemVO getLoginMember(Map<String, String> map);
	
	/**
	 * 회원 리스트 -> 운영자일 경우는 출력X
	 * @return
	 */
	public List<MemVO> getAllMember();
	/**
	 * 회원 리스트 수정 -> 운영자일 경우 수정X
	 * 
	 * @param member
	 * @return
	 */
	public int updateMember(Map<String, String> member);
	/**
	 * 회원 아이디를 클릭하면 회원 정보가 보임
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
	 * 운영자가 블랙리스트를 봄
	 * @return
	 */
	public List<MemVO> getBlacklistedMembers();
}
