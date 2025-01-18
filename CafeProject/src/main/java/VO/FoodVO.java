package VO;

public class FoodVO {
	
	private int foods_id;
	private String foods_name;
	private String foods_calorie;
	private String carbs;
	private String protein;
	private String fat;
	private String sodium;
	private int manger_no;
	private String mem_id;
	private int f_img_no;
	private String f_orgimg_name;
	private int f_img_size;
	private String f_img_date;
	private String f_img_name;
	
	public int getFoods_id() {
		return foods_id;
	}
	public void setFoods_id(int foods_id) {
		this.foods_id = foods_id;
	}
	public String getFoods_name() {
		return foods_name;
	}
	public void setFoods_name(String foods_name) {
		this.foods_name = foods_name;
	}
	public String getFoods_calorie() {
		return foods_calorie;
	}
	public void setFoods_calorie(String foods_calorie) {
		this.foods_calorie = foods_calorie;
	}
	public String getCarbs() {
		return carbs;
	}
	public void setCarbs(String carbs) {
		this.carbs = carbs;
	}
	public String getProtein() {
		return protein;
	}
	public void setProtein(String protein) {
		this.protein = protein;
	}
	public String getFat() {
		return fat;
	}
	public void setFat(String fat) {
		this.fat = fat;
	}
	public String getSodium() {
		return sodium;
	}
	public void setSodium(String sodium) {
		this.sodium = sodium;
	}
	public int getManger_no() {
		return manger_no;
	}
	public void setManger_no(int manger_no) {
		this.manger_no = manger_no;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public int getF_img_no() {
		return f_img_no;
	}
	public void setF_img_no(int f_img_no) {
		this.f_img_no = f_img_no;
	}
	public String getF_orgimg_name() {
		return f_orgimg_name;
	}
	public void setF_orgimg_name(String f_orgimg_name) {
		this.f_orgimg_name = f_orgimg_name;
	}
	public int getF_img_size() {
		return f_img_size;
	}
	public void setF_img_size(int f_img_size) {
		this.f_img_size = f_img_size;
	}
	public String getF_img_date() {
		return f_img_date;
	}
	public void setF_img_date(String f_img_date) {
		this.f_img_date = f_img_date;
	}
	public String getF_img_name() {
		return f_img_name;
	}
	public void setF_img_name(String f_img_name) {
		this.f_img_name = f_img_name;
	}
	
	@Override
	public String toString() {
		return "FoodVO [foods_id=" + foods_id + ", foods_name=" + foods_name + ", foods_calorie=" + foods_calorie
				+ ", carbs=" + carbs + ", protein=" + protein + ", fat=" + fat + ", sodium=" + sodium + ", manger_no="
				+ manger_no + ", mem_id=" + mem_id + ", f_img_no=" + f_img_no + ", f_orgimg_name=" + f_orgimg_name
				+ ", f_img_size=" + f_img_size + ", f_img_date=" + f_img_date + ", f_img_name=" + f_img_name + "]";
	}
	
	
	
}
