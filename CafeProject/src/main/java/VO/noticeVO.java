package VO;

public class noticeVO {
	
	private String notice_no;
	private String notice_title;
	private String notice_content;
	private String notice_type;
	private int notice_view;
	private String notice_day;
	private String ofile;
	private String sfile;
	
	
	public String getNotice_no() {
		return notice_no;
	}
	public void setNotice_no(String notice_no) {
		this.notice_no = notice_no;
	}
	public String getNotice_title() {
		return notice_title;
	}
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	public String getNotice_content() {
		return notice_content;
	}
	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}
	public String getNotice_type() {
		return notice_type;
	}
	public void setNotice_type(String notice_type) {
		this.notice_type = notice_type;
	}
	public int getNotice_view() {
		return notice_view;
	}
	public void setNotice_view(int notice_view) {
		this.notice_view = notice_view;
	}
	public String getNotice_day() {
		return notice_day;
	}
	public void setNotice_day(String notice_day) {
		this.notice_day = notice_day;
	}
	public String getOfile() {
		return ofile;
	}
	public void setOfile(String ofile) {
		this.ofile = ofile;
	}
	public String getSfile() {
		return sfile;
	}
	public void setSfile(String sfile) {
		this.sfile = sfile;
	}
	@Override
	public String toString() {
		return "noticeVO [notice_no=" + notice_no + ", notice_title=" + notice_title + ", notice_content="
				+ notice_content + ", notice_type=" + notice_type + ", notice_view=" + notice_view + ", notice_day="
				+ notice_day + ", ofile=" + ofile + ", sfile=" + sfile + "]";
	}
	
	
	
	
	
	
	

}
