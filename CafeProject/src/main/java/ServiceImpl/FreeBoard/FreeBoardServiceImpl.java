package ServiceImpl.FreeBoard;

import java.util.List;

import Service.FreeBoard.IFreeBoardService;
import VO.FreeBoardVO;

public class FreeBoardServiceImpl implements IFreeBoardService{
	
	// 싱글톤
	private static FreeBoardServiceImpl service;
	
	private IFreeBoardService dao;
	
	private FreeBoardServiceImpl() {
		dao = FreeBoardServiceImpl.getInstance();
	}
	public static FreeBoardServiceImpl getInstance() {
		if(service == null)
			service = new FreeBoardServiceImpl();
			return service;
	}
	
	// 싱글톤에서 dao 변수에 serviceimpl 인스턴스를 담아와서 return할 때 doa.으로 시작한다.
	
	@Override
	public int insertFreeBoard(FreeBoardVO FreeBoardVO) {
		return dao.insertFreeBoard(FreeBoardVO);
	}

	@Override
	public int updateFreeBoard(FreeBoardVO FreeBoardVO) {
		return dao.updateFreeBoard(FreeBoardVO);
	}

	@Override
	public int deleteFreeBoard(int boardNo) {
		return dao.deleteFreeBoard(boardNo);
	}

	@Override
	public List<FreeBoardVO> selectFreeBoard(FreeBoardVO FreeBoardVO) {
		return dao.selectFreeBoard(FreeBoardVO);
	}

	@Override
	public List<FreeBoardVO> selectAllFreeBoard() {
		return dao.selectAllFreeBoard();
				
	}
}
