package VO;

import java.io.Serializable;

public class MemVO implements Serializable{
	private String mem_id;
	private String mem_name;
	private String mem_pw;
	private String mem_bir;
	private String mem_tel;
	private String mem_addr1;
	private String mem_addr2;
	private String mem_create;
	private String mem_grd;
	private int is_blacklisted;
	
	
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_pw() {
		return mem_pw;
	}
	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}
	public String getMem_bir() {
		return mem_bir;
	}
	public void setMem_bir(String mem_bir) {
		this.mem_bir = mem_bir;
	}
	public String getMem_tel() {
		return mem_tel;
	}
	public void setMem_tel(String mem_tel) {
		this.mem_tel = mem_tel;
	}
	public String getMem_addr1() {
		return mem_addr1;
	}
	public void setMem_addr1(String mem_addr1) {
		this.mem_addr1 = mem_addr1;
	}
	public String getMem_addr2() {
		return mem_addr2;
	}
	public void setMem_addr2(String mem_addr2) {
		this.mem_addr2 = mem_addr2;
	}
	public String getMem_create() {
		return mem_create;
	}
	public void setMem_create(String mem_create) {
		this.mem_create = mem_create;
	}
	public String getMem_grd() {
		return mem_grd;
	}
	public void setMem_grd(String mem_grd) {
		this.mem_grd = mem_grd;
	}
	public int getIs_blacklisted() {
		return is_blacklisted;
	}
	public void setIs_blacklisted(int is_blacklisted) {
		this.is_blacklisted = is_blacklisted;
	}
	@Override
	public String toString() {
		return "MemVO [mem_id=" + mem_id + ", mem_name=" + mem_name + ", mem_pw=" + mem_pw + ", mem_bir=" + mem_bir
				+ ", mem_tel=" + mem_tel + ", mem_addr1=" + mem_addr1 + ", mem_addr2=" + mem_addr2 + ", mem_create="
				+ mem_create + ", mem_grd=" + mem_grd + ", is_blacklisted=" + is_blacklisted + "]";
	}
	
	
	
	
	
}
