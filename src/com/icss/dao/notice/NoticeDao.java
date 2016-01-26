package com.icss.dao.notice;

import java.util.List;
import java.util.Map;

import com.icss.bean.NoticeBean;
/**
 * Notice客户信息dao
 * @author 才新
 * 012001
 */
public interface NoticeDao {
	//将dao（数据访问对象）做成一个接口，在接口中声明所有数据库操作方法
	public int addNotice(NoticeBean bean)throws Exception;
	//删除
	public int deletNotice(String id)throws Exception;
	//部门分页查询
	public List<Map<String, Object>>queryNoticeOnepage(int noepage ,int pagesize) throws Exception;
	
	public List<Map<String, Object>>queryNoticeOnepage(int noepage) throws Exception;
	//多表连接查询 模糊查询查询方式
	public List<Map<String, Object>>querybyNotice(int i,String str,int noepage ,int pagesize) throws Exception;
	//多表连接查看有效公告 结束时间大于系统时间
	public List<Map<String, Object>>querybeUseNotice() throws Exception;
	
	public int getRowCount();
	public int getPageCount() ;
	public int getNowPage();
	public int getPageSize() ;

}
