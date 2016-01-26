package com.icss.dao.user;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import com.icss.bean.UserBean;

import oracle.net.aso.e;

public interface UserDao {

	public int addUser(UserBean uBean) throws Exception;
	
	public int delUser(int user_id) throws Exception;
	
	//用于更新编辑时填充信息
	public List<Map<String, Object>> queryUserById(int user_id) throws Exception;
	//进入员工信息页面时候的查询
	public List<Map<String, Object>> queryUserOnPage(int nowPage, int pageSize) throws Exception;
	public int getRowCount();
	public int getPageSize();
	public int getNowPage() ;
	public int getPageCount();
	//用于查询所有员工
	public List<Map<String, Object>> queryAllUser() throws Exception;
	
	public List<Map<String, Object>> queryUserByName(int nowpage,int pagesize,String name)throws Exception;
	
	//用于登录时的权限验证
	public ResultSet checkLogin(String usernum,String pwd) throws Exception;
	
	//用于添加员工时判断是否重名
	public ResultSet checkName() throws Exception;

}
