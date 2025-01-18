package ServiceImpl.Faq;

import java.util.List;

import Service.Faq.IFaqService;
import VO.FaqVO;

public class FaqServiceImpl implements IFaqService {
	
	// 싱글톤
		private static FaqServiceImpl service;
		
		private IFaqService dao;
		
		private FaqServiceImpl() {
			dao = FaqServiceImpl.getInstance();
		}
		public static FaqServiceImpl getInstance() {
			if(service == null)
				service = new FaqServiceImpl();
				return service;
		}

	@Override
	public int insertFaq(FaqVO FaqVO) {
		return dao.insertFaq(FaqVO);
	}

	@Override
	public int deleteFaq(int Faq_no) {
		return dao.deleteFaq(Faq_no);
	}

	@Override
	public int updateFaq(FaqVO FaqVO) {
		return dao.updateFaq(FaqVO);
	}

	@Override
	public List<FaqVO> selectAllFaq(FaqVO FaqVO) {
		return dao.selectAllFaq(FaqVO);
	}

	@Override
	public List<FaqVO> selectFaq(FaqVO FaqVO) {
		return dao.selectFaq(FaqVO);
	}

}
