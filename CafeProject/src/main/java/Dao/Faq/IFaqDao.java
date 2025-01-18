package Dao.Faq;

import java.util.List;

import VO.FaqVO;

public interface IFaqDao {
	// 게시글 작성
	public int insertFaq(FaqVO FaqVO);
	
	// 게시글 삭제
	public int deleteFaq(int Faq_no);
	
	// 게시글 수정
	public int updateFaq(FaqVO FaqVO);
	
	// 게시글 전체조회
	public List<FaqVO> selectAllFaq(FaqVO FaqVO);
	
	// 게시글 조회
	public List<FaqVO> selectFaq(FaqVO FaqVO);
}
