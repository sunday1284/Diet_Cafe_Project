package Dao.Food;

import java.util.List;

import VO.FoodVO;

public interface IFoodDao {
	
	/**
	 * 음식 정보 추가(insert)
	 * @param FoodVO
	 */
	public int insertFood(FoodVO FoodVO);
	
	/**
	 * 음식 정보 수정(update)
	 * @param FoodVO
	 */
	public int updateFood(FoodVO FoodVO);
	
	/**
	 * 음식 정보 삭제(delete)
	 * @param foods_id
	 */
	public int deleteFood(int foods_id);
	
	/**
	 * 음식 정보 조회(select - 특정 음식 검색)
	 * @param FoodVO
	 */
	public List<FoodVO> selectFood(FoodVO FoodVO);
	
	/**
	 * 음식 정보 전체 조회
	 */
	public List<FoodVO> selectAllFood();
	
}
