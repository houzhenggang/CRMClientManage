package com.icss.bean;

public class NoticeBean {
	
	private String notice_id;
	private String user_id;
	private String notice_item;
	private String notice_content;
	private String notice_time;
	private String notice_endtime;
	private String is_used;
	
	public NoticeBean(){}
	
	public NoticeBean(String notice_id, String user_id, String notice_item,
			String notice_content, String notice_time, String notice_endtime,
			String is_used) {
		super();
		this.notice_id = notice_id;
		this.user_id = user_id;
		this.notice_item = notice_item;
		this.notice_content = notice_content;
		this.notice_time = notice_time;
		this.notice_endtime = notice_endtime;
		this.is_used = is_used;
	}
	
	public NoticeBean(String user_id, String notice_item,
			String notice_content, String notice_time, String notice_endtime) {
		super();
		this.user_id = user_id;
		this.notice_item = notice_item;
		this.notice_content = notice_content;
		this.notice_time = notice_time;
		this.notice_endtime = notice_endtime;
	}

	public String getNotice_id() {
		return notice_id;
	}

	public void setNotice_id(String notice_id) {
		this.notice_id = notice_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getNotice_item() {
		return notice_item;
	}

	public void setNotice_item(String notice_item) {
		this.notice_item = notice_item;
	}

	public String getNotice_content() {
		return notice_content;
	}

	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}

	public String getNotice_time() {
		return notice_time;
	}

	public void setNotice_time(String notice_time) {
		this.notice_time = notice_time;
	}

	public String getNotice_endtime() {
		return notice_endtime;
	}

	public void setNotice_endtime(String notice_endtime) {
		this.notice_endtime = notice_endtime;
	}

	public String getIs_used() {
		return is_used;
	}

	public void setIs_used(String is_used) {
		this.is_used = is_used;
	}
	
	
}
