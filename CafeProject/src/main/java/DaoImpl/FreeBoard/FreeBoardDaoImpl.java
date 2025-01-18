package DaoImpl.FreeBoard;

import java.util.List;

import Dao.FreeBoard.IFreeBoardDao;
import VO.FreeBoardVO;

public class FreeBoardDaoImpl implements IFreeBoardDao {
	
	// 싱글톤
	private static FreeBoardDaoImpl dao;
	
	private FreeBoardDaoImpl() {
		dao = FreeBoardDaoImpl.getInstance();
	}
	public static FreeBoardDaoImpl getInstance() {
		if(dao == null)
			dao = new FreeBoardDaoImpl();
			return dao;
	}
	@Override
	public int insertFreeBoard(FreeBoardVO FreeBoardVO) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int updateFreeBoard(FreeBoardVO FreeBoardVO) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int deleteFreeBoard(int boardNo) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<FreeBoardVO> selectFreeBoard(FreeBoardVO FreeBoardVO) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<FreeBoardVO> selectAllFreeBoard() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
