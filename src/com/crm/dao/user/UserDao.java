package com.crm.dao.user;

import java.util.List;
import java.util.Map;

import com.crm.bean.user.UserBean;

public interface UserDao {

	public int addUser(UserBean uBean) throws Exception;
	
	public List<Map<String, Object>> queryUserOnPage(int nowPage, int pageSize) throws Exception;
	public int getRowCount();
	public int getPageSize();
	public int getNowPage() ;
	public int getPageCount();
	
	
}
