package com.icss.bean.Linkrecord;

public class LinkrecordBean {
	private int record_id;

	private int customer_id;
	
	private String link_time;

	private String who_link;

	private String link_type;

	private String link_theme;

	private String link_nexttime;

	private String link_remark;

	private String is_used;
	
	//无参构造方法
	public LinkrecordBean(){}		
	
	//有参构造方法，初始化全部属性
	public LinkrecordBean(int record_id,int customer_id,String link_time,String who_link,String link_type,String link_theme,String link_nexttime,String link_remark,String is_used){
		this.record_id = record_id;
		this.customer_id = customer_id;
		this.link_time = link_time;
		this.who_link = who_link;
		this.link_type = link_type;
		this.link_theme = link_theme;
		this.link_nexttime = link_nexttime;
		this.link_remark = link_remark;
		this.is_used = is_used;
	}
	
	public LinkrecordBean(int customer_id,String who_link,String link_type,String link_theme, String link_nexttime, String link_remark){
		this.customer_id = customer_id;
		this.who_link = who_link;
		this.link_type = link_type;
		this.link_theme = link_theme;
		this.link_nexttime = link_nexttime;
		this.link_remark = link_remark;
		
	}
	//set,get方法
	public int getRecord_id() {
		return record_id;
	}

	public void setRecord_id(int record_id) {
		this.record_id = record_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getLink_time() {
		return link_time;
	}

	public void setLink_time(String link_time) {
		this.link_time = link_time;
	}

	public String getWho_link() {
		return who_link;
	}

	public void setWho_link(String who_link) {
		this.who_link = who_link;
	}

	public String getLink_type() {
		return link_type;
	}

	public void setLink_type(String link_type) {
		this.link_type = link_type;
	}

	public String getLink_theme() {
		return link_theme;
	}

	public void setLink_theme(String link_theme) {
		this.link_theme = link_theme;
	}

	public String getLink_nexttime() {
		return link_nexttime;
	}

	public void setLink_nexttime(String link_nexttime) {
		this.link_nexttime = link_nexttime;
	}

	public String getLink_remark() {
		return link_remark;
	}

	public void setLink_remark(String link_remark) {
		this.link_remark = link_remark;
	}

	public String getIs_used() {
		return is_used;
	}

	public void setIs_used(String is_used) {
		this.is_used = is_used;
	}
	

}
