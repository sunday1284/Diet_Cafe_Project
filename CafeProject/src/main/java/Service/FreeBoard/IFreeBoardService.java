package Service.FreeBoard;
import java.util.List;

import VO.FreeBoardVO;

/**
 * 파라미터
 * 1. 단순하게 사용자 ID 하나를 가지고 사용자의 정보 조회를 하는 경우 : userID만 받음
 * 2. 여러 정보를 가지고 사용자의 정보를 업데이트 해야하는 경우 : VO로 받음
 * 3. 전체 데이터를 조회하거나 특정 조건에 따른 필터링 없이 모든 데이터를 반환해야하는 경우 : List(파라미터없음) 사용
 * 4. 전체 데이터를 조회하는데 특정 조건에 따른 필터링이 필요한 경우 : List(조건파라미터) 사용f
 */

public interface IFreeBoardService {
	// 게시글 작성 (insert)
	public int insertFreeBoard(FreeBoardVO FreeBoardVO);
	
	// 게시글 수정 (update)
	public int updateFreeBoard(FreeBoardVO FreeBoardVO);
	
	// 게시글 삭제 (delete)
	public int deleteFreeBoard(int boardNo);
	
	// 게시글 조회 (select - 사용자가 특정 게시글 검색)
	// 글번호, 제목, 내용, 작성일, 조회수로 게시글 조회 가능
	public List<FreeBoardVO> selectFreeBoard(FreeBoardVO FreeBoardVO);
	
	// 게시글 전체조회 (select - 게시판 들어갔을 때 전체게시글 목록)
	public List<FreeBoardVO> selectAllFreeBoard();
	
}
