package DaoImpl;

import java.util.List;

import VO.noticeVO;

public interface INoticeDao {

	/**
	 * 공지사항 등록
	 * @param noticeVO
	 * @return
	 */
	public int insertNotice(noticeVO noticeVO);
	
	/**
	 * 공지사항 조회
	 * @param noticeVO
	 */
	public List<noticeVO> getAllNotice();
	
}
