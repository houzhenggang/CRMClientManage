package com.icss.dao.user;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import com.icss.bean.UserBean;

import oracle.net.aso.e;

public interface UserDao {

	public int addUser(UserBean uBean) throws Exception;
	
	public int delUser(int user_id) throws Exception;
	
	//���ڸ��±༭ʱ�����Ϣ
	public List<Map<String, Object>> queryUserById(int user_id) throws Exception;
	//����Ա����Ϣҳ��ʱ��Ĳ�ѯ
	public List<Map<String, Object>> queryUserOnPage(int nowPage, int pageSize) throws Exception;
	public int getRowCount();
	public int getPageSize();
	public int getNowPage() ;
	public int getPageCount();
	//���ڲ�ѯ����Ա��
	public List<Map<String, Object>> queryAllUser() throws Exception;
	
	public List<Map<String, Object>> queryUserByName(int nowpage,int pagesize,String name)throws Exception;
	
	//���ڵ�¼ʱ��Ȩ����֤
	public ResultSet checkLogin(String usernum,String pwd) throws Exception;
	
	//�������Ա��ʱ�ж��Ƿ�����
	public ResultSet checkName() throws Exception;

}
