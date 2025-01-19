package ServiceImpl.Notice;

import java.util.List;

import VO.noticeVO;

public interface INoticeService {

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
	
	/**
	 * 공지사항 상세조회
	 * @param notice_title
	 * @return
	 */
	public noticeVO DetailNotice(String notice_no);
	
	/**
	 * 공지사항 조회수 증가
	 * @param notice_no
	 * @return
	 */
	public int CountViewNotice(String notice_no);
	
}
