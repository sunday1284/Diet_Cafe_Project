package Service;

import java.util.List;

import Dao.NoticeDaoImpl;
import DaoImpl.INoticeDao;
import ServiceImpl.INoticeService;
import VO.noticeVO;

public class NoticeServiceImpl implements INoticeService{
	
	private static NoticeServiceImpl service;
	private INoticeDao dao;
	
	private NoticeServiceImpl() {
		dao = NoticeDaoImpl.getInstance();
	}
	
	public static NoticeServiceImpl getInstance() {
		if(service==null) service = new NoticeServiceImpl();
		
		return service;
	}
	

	@Override
	public int insertNotice(noticeVO noticeVO) {
		// TODO Auto-generated method stub
		return dao.insertNotice(noticeVO);
	}

	@Override
	public List<noticeVO> getAllNotice() {
		// TODO Auto-generated method stub
		return dao.getAllNotice();
	}


	
	

}
