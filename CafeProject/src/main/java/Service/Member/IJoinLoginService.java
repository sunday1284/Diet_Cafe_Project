package Service.Member;

import VO.MemVO;

public interface IJoinLoginService {
	public int joinMember(MemVO memvo);

	public int CheckId(String mem_id);
}
