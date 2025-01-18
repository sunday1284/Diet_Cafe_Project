package VO;

public class FaqVO {
	
	private int faq_no;
	private String faq_title;
	private String faq_content;
	private int fa_img_no;
	private String fa_orgimg_name;
	private int fa_img_size;
	private String fa_img_date;
	private int Manger_no;
	private String fa_img_name;
	private int board_id;
	
	public int getFaq_no() {
		return faq_no;
	}
	public void setFaq_no(int faq_no) {
		this.faq_no = faq_no;
	}
	public String getFaq_title() {
		return faq_title;
	}
	public void setFaq_title(String faq_title) {
		this.faq_title = faq_title;
	}
	public String getFaq_content() {
		return faq_content;
	}
	public void setFaq_content(String faq_content) {
		this.faq_content = faq_content;
	}
	public int getFa_img_no() {
		return fa_img_no;
	}
	public void setFa_img_no(int fa_img_no) {
		this.fa_img_no = fa_img_no;
	}
	public String getFa_orgimg_name() {
		return fa_orgimg_name;
	}
	public void setFa_orgimg_name(String fa_orgimg_name) {
		this.fa_orgimg_name = fa_orgimg_name;
	}
	public int getFa_img_size() {
		return fa_img_size;
	}
	public void setFa_img_size(int fa_img_size) {
		this.fa_img_size = fa_img_size;
	}
	public String getFa_img_date() {
		return fa_img_date;
	}
	public void setFa_img_date(String fa_img_date) {
		this.fa_img_date = fa_img_date;
	}
	public int getManger_no() {
		return Manger_no;
	}
	public void setManger_no(int manger_no) {
		Manger_no = manger_no;
	}
	public String getFa_img_name() {
		return fa_img_name;
	}
	public void setFa_img_name(String fa_img_name) {
		this.fa_img_name = fa_img_name;
	}
	
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	
	@Override
	public String toString() {
		return "FaqVO [faq_no=" + faq_no + ", faq_title=" + faq_title + ", faq_content=" + faq_content + ", fa_img_no="
				+ fa_img_no + ", fa_orgimg_name=" + fa_orgimg_name + ", fa_img_size=" + fa_img_size + ", fa_img_date="
				+ fa_img_date + ", Manger_no=" + Manger_no + ", fa_img_name=" + fa_img_name + ", board_id=" + board_id
				+ "]";
	}
	

}
