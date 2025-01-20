package DaoImpl.Faq;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import Dao.Faq.IFaqDao;
import Util.MybatisUtil;
import VO.FaqVO;

public class FaqDaoImpl implements IFaqDao {

    private static FaqDaoImpl instance;

    private FaqDaoImpl() {}

    public static FaqDaoImpl getInstance() {
        if (instance == null) {
            instance = new FaqDaoImpl();
        }
        return instance;
    }

    @Override
    public int insertFaq(FaqVO faqVO) {
        int result = 0;
        SqlSession session = null;
        try {
            session = MybatisUtil.getSqlSession();
            result = session.insert("Faq.insertFaq", faqVO);
            if (result > 0) {
                session.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                session.rollback();  // 예외 발생 시 롤백
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }

    @Override
    public int deleteFaq(int faq_no) {
        int result = 0;
        SqlSession session = null;
        try {
            session = MybatisUtil.getSqlSession();
            result = session.delete("Faq.deleteFaq", faq_no);
            if (result > 0) {
                session.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                session.rollback();  // 예외 발생 시 롤백
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }

    @Override
    public int updateFaq(FaqVO faqVO) {
        int result = 0;
        SqlSession session = null;
        try {
            session = MybatisUtil.getSqlSession();
            result = session.update("Faq.updateFaq", faqVO);
            if (result > 0) {
                session.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                session.rollback();  // 예외 발생 시 롤백
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }

    @Override
    public List<FaqVO> selectAllFaq(FaqVO faqVO) {
        List<FaqVO> list = null;
        SqlSession session = null;
        try {
            session = MybatisUtil.getSqlSession();
            list = session.selectList("Faq.selectAllFaq");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return list;
    }

    @Override
    public FaqVO selectFaq(FaqVO faqVO) {
        FaqVO result = null;
        SqlSession session = null;
        try {
            session = MybatisUtil.getSqlSession();
            result = session.selectOne("Faq.selectFaq", faqVO);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }
}
