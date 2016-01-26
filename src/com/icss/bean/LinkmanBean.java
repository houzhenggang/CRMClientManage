package com.icss.bean;


public class LinkmanBean {
	
	private int linkman_id;
	private int customer_id;
	private String linkman_name;
	private String linkman_sex;
	private String linkman_job;
	private String linkman_mobile;
	private int linkman_age;
	private String linkman_relation;
	private String is_used;
	
	//无参构造方法
	public LinkmanBean(){}
	
	//有参构造方法
	public LinkmanBean(int linkman_id,int customer_id,String linkman_name,String linkman_sex,String linkman_job,String linkman_mobile,int linkman_age,String linkman_relation,String is_used){
		this.linkman_id = linkman_id;
		this.customer_id = customer_id;
		this.linkman_name = linkman_name;
		this.linkman_sex = linkman_sex;
		this.linkman_job = linkman_job;
		this.linkman_mobile = linkman_mobile;
		this.linkman_age = linkman_age;
		this.linkman_relation = linkman_relation;
		this.is_used = is_used;
	}
	
	public LinkmanBean(int customer_id,String linkman_name,String linkman_sex,String linkman_job,String linkman_mobile,int linkman_age,String linkman_relation){
		this.customer_id = customer_id;
		this.linkman_name = linkman_name;
		this.linkman_sex = linkman_sex;
		this.linkman_job = linkman_job;
		this.linkman_mobile = linkman_mobile;
		this.linkman_age = linkman_age;
		this.linkman_relation = linkman_relation;
	}

	//set，get方法
	public int getLinkman_id() {
		return linkman_id;
	}

	public void setLinkman_id(int linkman_id) {
		this.linkman_id = linkman_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getLinkman_name() {
		return linkman_name;
	}

	public void setLinkman_name(String linkman_name) {
		this.linkman_name = linkman_name;
	}

	public String getLinkman_sex() {
		return linkman_sex;
	}

	public void setLinkman_sex(String linkman_sex) {
		this.linkman_sex = linkman_sex;
	}

	public String getLinkman_job() {
		return linkman_job;
	}

	public void setLinkman_job(String linkman_job) {
		this.linkman_job = linkman_job;
	}

	public String getLinkman_mobile() {
		return linkman_mobile;
	}

	public void setLinkman_mobile(String linkman_mobile) {
		this.linkman_mobile = linkman_mobile;
	}

	public int getLinkman_age() {
		return linkman_age;
	}

	public void setLinkman_age(int linkman_age) {
		this.linkman_age = linkman_age;
	}

	public String getLinkman_relation() {
		return linkman_relation;
	}

	public void setLinkman_relation(String linkman_relation) {
		this.linkman_relation = linkman_relation;
	}

	public String getIs_used() {
		return is_used;
	}

	public void setIs_used(String is_used) {
		this.is_used = is_used;
	}
	

}
