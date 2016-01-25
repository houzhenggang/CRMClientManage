package com.icss.dao.linkrecordDao;

import java.util.List;
import java.util.Map;

import com.icss.bean.Linkrecord.LinkrecordBean;

public interface LinkrecordInfoDao {
	//将Dao(数据库访问对象)做成一个接口，在接口中声明所有数据库的操作方法
	//添加联系记录
	
	public int addLinkrecord (LinkrecordBean bean)throws Exception;
	
	//查询联系记录
	//	public List<LinkRecordBean> queryAllLinkrecord() throws Exception;
	
	
	//根据联系记录id查询
	public List<Map<String, Object>> queryByIdLinkrecord(int record_id) throws Exception ;
	
	//根据联系记录id删除
	public int deleteLinkrecord (int record_id) throws Exception;
	
	//分页查询
	public List<Map<String, Object>> queryCareOnPage(int nowPage,String whoLinkInput ,String queryType) throws Exception;
	
	//分页查询
	public List<Map<String, Object>> queryCareOnPage(int nowPage,int pageSize,String whoLinkInput ,String queryType) throws Exception;
	
	public int getRowCount();
	public int getPageCount() ;
	public int getNowPage();
	public int getPageSize() ;
}


