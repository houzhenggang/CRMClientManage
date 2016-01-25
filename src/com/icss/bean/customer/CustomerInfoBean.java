package com.icss.bean.customer;
/**
 * CustomerInfoBean客户信息bean
 * @author 才新
 * 011901
 */
public class CustomerInfoBean {
	
	private String customer_id;
	private String condition_id;
	private String source_id;
	private String user_id;
	private String type_id;
	private String customer_name;
	private String customer_sex;
	private String customer_mobile;
	private String customer_qq;
	private String customer_address;
	private String customer_email;
	private String customer_remark;
	private String customer_job;
	private String customer_blog;
	private String customer_tel;
	private String customer_msn;
	private String birth_day;
	private String customer_addtime;
	private String customer_addman;
	private String customer_changtime;
	private String change_man;
	private String customer_company;
	private String is_used;
	
	public CustomerInfoBean(){}
	
	public CustomerInfoBean(String customer_id, String condition_id, String source_id,
			String user_id, String type_id, String customer_name,
			String customer_sex, String customer_mobile, String customer_qq,
			String customer_address, String customer_email,
			String customer_remark, String customer_job, String customer_blog,
			String customer_tel, String customer_msn, String birth_day,
			String customer_addtime, String customer_addman,
			String customer_changtime, String change_man,
			String customer_company, String is_used) {
		super();
		this.customer_id = customer_id;
		this.condition_id = condition_id;
		this.source_id = source_id;
		this.user_id = user_id;
		this.type_id = type_id;
		this.customer_name = customer_name;
		this.customer_sex = customer_sex;
		this.customer_mobile = customer_mobile;
		this.customer_qq = customer_qq;
		this.customer_address = customer_address;
		this.customer_email = customer_email;
		this.customer_remark = customer_remark;
		this.customer_job = customer_job;
		this.customer_blog = customer_blog;
		this.customer_tel = customer_tel;
		this.customer_msn = customer_msn;
		this.birth_day = birth_day;
		this.customer_addtime = customer_addtime;
		this.customer_addman = customer_addman;
		this.customer_changtime = customer_changtime;
		this.change_man = change_man;
		this.customer_company = customer_company;
		this.is_used = is_used;
	}
	
	public CustomerInfoBean(String condition_id, String source_id,
			String user_id, String type_id, String customer_name,
			String customer_sex, String customer_mobile, String customer_qq,
			String customer_address, String customer_email,
			String customer_remark, String customer_job, String customer_blog,
			String customer_tel, String customer_msn, String birth_day,
			String customer_addtime, String customer_addman,
			String customer_changtime, String change_man,
			String customer_company ) {
		super();
		this.condition_id = condition_id;
		this.source_id = source_id;
		this.user_id = user_id;
		this.type_id = type_id;
		this.customer_name = customer_name;
		this.customer_sex = customer_sex;
		this.customer_mobile = customer_mobile;
		this.customer_qq = customer_qq;
		this.customer_address = customer_address;
		this.customer_email = customer_email;
		this.customer_remark = customer_remark;
		this.customer_job = customer_job;
		this.customer_blog = customer_blog;
		this.customer_tel = customer_tel;
		this.customer_msn = customer_msn;
		this.birth_day = birth_day;
		this.customer_addtime = customer_addtime;
		this.customer_addman = customer_addman;
		this.customer_changtime = customer_changtime;
		this.change_man = change_man;
		this.customer_company = customer_company;
		
	}
	
	public CustomerInfoBean(String customer_id, String condition_id, String source_id,
			String user_id, String type_id, String customer_name,
			String customer_sex, String customer_mobile, String customer_qq,
			String customer_address, String customer_email,
			String customer_remark, String customer_job, String customer_blog,
			String customer_tel, String customer_msn, String birth_day,
			String customer_addtime, String customer_addman,
			String customer_changtime, String change_man,
			String customer_company) {
		super();
		this.customer_id = customer_id;
		this.condition_id = condition_id;
		this.source_id = source_id;
		this.user_id = user_id;
		this.type_id = type_id;
		this.customer_name = customer_name;
		this.customer_sex = customer_sex;
		this.customer_mobile = customer_mobile;
		this.customer_qq = customer_qq;
		this.customer_address = customer_address;
		this.customer_email = customer_email;
		this.customer_remark = customer_remark;
		this.customer_job = customer_job;
		this.customer_blog = customer_blog;
		this.customer_tel = customer_tel;
		this.customer_msn = customer_msn;
		this.birth_day = birth_day;
		this.customer_addtime = customer_addtime;
		this.customer_addman = customer_addman;
		this.customer_changtime = customer_changtime;
		this.change_man = change_man;
		this.customer_company = customer_company;
	}
	
	public CustomerInfoBean(String customer_id, String condition_id, String source_id,
			String user_id, String type_id, String customer_sex, String customer_mobile, String customer_qq,
			String customer_address, String customer_email,
			String customer_remark, String customer_job, String customer_blog,
			String customer_tel, String customer_msn, String customer_addtime, 
			String customer_changtime, String change_man,
			String customer_company) {
		super();
		this.customer_id = customer_id;
		this.condition_id = condition_id;
		this.source_id = source_id;
		this.user_id = user_id;
		this.type_id = type_id;
		this.customer_sex = customer_sex;
		this.customer_mobile = customer_mobile;
		this.customer_qq = customer_qq;
		this.customer_address = customer_address;
		this.customer_email = customer_email;
		this.customer_remark = customer_remark;
		this.customer_job = customer_job;
		this.customer_blog = customer_blog;
		this.customer_tel = customer_tel;
		this.customer_msn = customer_msn;
		this.customer_addtime = customer_addtime;
		this.customer_changtime = customer_changtime;
		this.change_man = change_man;
		this.customer_company = customer_company;
	}
	
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getCondition_id() {
		return condition_id;
	}
	public void setCondition_id(String condition_id) {
		this.condition_id = condition_id;
	}
	public String getSource_id() {
		return source_id;
	}
	public void setSource_id(String source_id) {
		this.source_id = source_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getType_id() {
		return type_id;
	}
	public void setType_id(String type_id) {
		this.type_id = type_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getCustomer_sex() {
		return customer_sex;
	}
	public void setCustomer_sex(String customer_sex) {
		this.customer_sex = customer_sex;
	}
	public String getCustomer_mobile() {
		return customer_mobile;
	}
	public void setCustomer_mobile(String customer_mobile) {
		this.customer_mobile = customer_mobile;
	}
	public String getCustomer_qq() {
		return customer_qq;
	}
	public void setCustomer_qq(String customer_qq) {
		this.customer_qq = customer_qq;
	}
	public String getCustomer_address() {
		return customer_address;
	}
	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}
	public String getCustomer_email() {
		return customer_email;
	}
	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}
	public String getCustomer_remark() {
		return customer_remark;
	}
	public void setCustomer_remark(String customer_remark) {
		this.customer_remark = customer_remark;
	}
	public String getCustomer_job() {
		return customer_job;
	}
	public void setCustomer_job(String customer_job) {
		this.customer_job = customer_job;
	}
	public String getCustomer_blog() {
		return customer_blog;
	}
	public void setCustomer_blog(String customer_blog) {
		this.customer_blog = customer_blog;
	}
	public String getCustomer_tel() {
		return customer_tel;
	}
	public void setCustomer_tel(String customer_tel) {
		this.customer_tel = customer_tel;
	}
	public String getCustomer_msn() {
		return customer_msn;
	}
	public void setCustomer_msn(String customer_msn) {
		this.customer_msn = customer_msn;
	}
	public String getBirth_day() {
		return birth_day;
	}
	public void setBirth_day(String birth_day) {
		this.birth_day = birth_day;
	}
	public String getCustomer_addtime() {
		return customer_addtime;
	}
	public void setCustomer_addtime(String customer_addtime) {
		this.customer_addtime = customer_addtime;
	}
	public String getCustomer_addman() {
		return customer_addman;
	}
	public void setCustomer_addman(String customer_addman) {
		this.customer_addman = customer_addman;
	}
	public String getCustomer_changtime() {
		return customer_changtime;
	}
	public void setCustomer_changtime(String customer_changtime) {
		this.customer_changtime = customer_changtime;
	}
	public String getChange_man() {
		return change_man;
	}
	public void setChange_man(String change_man) {
		this.change_man = change_man;
	}
	public String getCustomer_company() {
		return customer_company;
	}
	public void setCustomer_company(String customer_company) {
		this.customer_company = customer_company;
	}
	public String getIs_used() {
		return is_used;
	}
	public void setIs_used(String is_used) {
		this.is_used = is_used;
	}


}
