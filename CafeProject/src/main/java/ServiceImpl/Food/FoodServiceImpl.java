package ServiceImpl.Food;

import java.util.List;

import Service.Food.IFoodService;
import VO.FoodVO;

public class FoodServiceImpl implements IFoodService{
	
	private static FoodServiceImpl service;
	
	private IFoodService dao;
	
	private FoodServiceImpl() {
		dao = FoodServiceImpl.getInstance();
	}
	public static FoodServiceImpl getInstance() {
		if(service == null)
			service = new FoodServiceImpl();
			return service;
	}
	
	@Override
	public int insertFood(FoodVO FoodVO) {
		return dao.insertFood(FoodVO);
	}
	
	@Override
	public int updateFood(FoodVO FoodVO) {
		return dao.updateFood(FoodVO);
	}
	
	@Override
	public int deleteFood(int Foods_id) {
		return dao.deleteFood(Foods_id);
	}
	
	@Override
	public List<FoodVO> selectFood(FoodVO FoodVO){
		return dao.selectFood(FoodVO);
	}
	
	@Override
	public List<FoodVO> selectAllFood(){
		return dao.selectAllFood();
	}
	
}
