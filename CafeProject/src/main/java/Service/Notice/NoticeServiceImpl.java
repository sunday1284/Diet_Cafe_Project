package Service.Notice;

import java.util.List;

import Dao.Notice.NoticeDaoImpl;
import DaoImpl.Notice.INoticeDao;
import ServiceImpl.Notice.INoticeService;
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

	@Override
	public noticeVO DetailNotice(String notice_no) {
		// TODO Auto-generated method stub
		return dao.DetailNotice(notice_no);
	}

	@Override
	public int CountViewNotice(String notice_no) {
		// TODO Auto-generated method stub
		return dao.CountViewNotice(notice_no);
	}

	
	
	

}
