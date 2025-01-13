package DaoImpl;

import VO.noticeVO;

public interface INoticeDao {

	/**
	 * 공지사항 등록
	 * @param noticeVO
	 * @return
	 */
	public int insertNotice(noticeVO noticeVO);
	
}
