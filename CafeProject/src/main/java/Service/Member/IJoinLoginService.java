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
}
