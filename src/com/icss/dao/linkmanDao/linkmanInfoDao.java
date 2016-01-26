package com.icss.dao.linkmanDao;

import java.util.List;
import java.util.Map;

import com.icss.bean.LinkmanBean;

public interface linkmanInfoDao {
	// 将Dao(数据库访问对象)做成一个接口，在接口中声明所有数据库的操作方法
	//添加联系人
	public int addLinkman(LinkmanBean bean) throws Exception;
	
	//查询联系人全部数据
//	public List<LinkmanBean> queryAllLinkman() throws Exception;
	
	
	//根据联系人ID查询
	public List<Map<String, Object>> queryByIdLinkman (int linkman_id) throws Exception;
	
	
	//根据联系人编号删除联系人数据
	public int deleteLinkman(int linkman_id) throws Exception;
	
	
	//根据主键更新联系人数据
	 public int updateLinkman(LinkmanBean bean) throws Exception;


	//分页查询
	public List<Map<String, Object>> queryLinkmanOnPage (int nowPage,String linkmanInput ,String queryType)throws Exception;
	
	public List<Map<String, Object>> queryLinkmanOnPage(int nowPage,int pageSize,String LinkmanInput ,String queryType)throws Exception;
	
	public int getRowCount();
	public int getPageCount();
	public int getNowPage();
	public int getPageSize();
}
