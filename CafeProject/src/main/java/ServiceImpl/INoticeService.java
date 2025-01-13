package ServiceImpl;

import VO.noticeVO;

public interface INoticeService {

	/**
	 * 공지사항 등록
	 * @param noticeVO
	 * @return
	 */
	public int insertNotice(noticeVO noticeVO);
	
}
