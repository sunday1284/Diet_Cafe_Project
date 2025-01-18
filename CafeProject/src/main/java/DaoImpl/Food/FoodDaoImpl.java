package DaoImpl.Food;

import java.util.List;

import Dao.Food.IFoodDao;
import VO.FoodVO;

public class FoodDaoImpl implements IFoodDao {
	
	private static FoodDaoImpl dao;
	
	private FoodDaoImpl() {
		dao = FoodDaoImpl.getInstance();
	}
	public static FoodDaoImpl getInstance() {
		if(dao == null)
			dao = new FoodDaoImpl();
			return dao;
	}
	
	@Override
	public int insertFood(FoodVO FoodVO) {
		return 0;
	}
	
	@Override
	public int updateFood(FoodVO FoodVO) {
		return 0;
	}
	
	@Override
	public int deleteFood(int foods_id) {
		return foods_id;
	}
	
	@Override
	public List<FoodVO> selectFood(FoodVO FoodVO) {
		return null;
	}

	@Override
	public List<FoodVO> selectAllFood() {
		return null;
	}
	
}
