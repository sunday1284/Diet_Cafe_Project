package Dao.FreeBoard;

import java.util.List;

import VO.FreeBoardVO;

public interface IFreeBoardDao {
	
	/**
	 * 게시글 작성(insert)
	 * @param FreeBoardVO
	 */
	public int insertFreeBoard(FreeBoardVO FreeBoardVO);
	
	/**
	 * 게시글 수정(update)
	 * @param FreeBoardVO
	 */
	public int updateFreeBoard(FreeBoardVO FreeBoardVO);
	
	/**
	 * 게시글 삭제(delete)
	 * @param boardNo
	 */
	public int deleteFreeBoard(int boardNo);
	
	/**
	 * 게시글 조회(select - 사용자가 특정 게시글 검색)
	 * 글번호, 제목, 내용, 작성일, 조회수로 게시글 조회 가능
	 * @param FreeBoardVO
	 */
	public List<FreeBoardVO> selectFreeBoard(FreeBoardVO FreeBoardVO);
	
	/**
	 * 게시글 전체조회 (select - 게시판 들어갔을 때 전체게시글 목록)
	 */
	public List<FreeBoardVO> selectAllFreeBoard();
}
