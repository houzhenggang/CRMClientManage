package com.icss.dao.DepartmentInfoDao;

import java.util.List;
import java.util.Map;

import com.icss.bean.DepartmentInfoBean;

/**
 * 崔鹏程
 * @author Administrator
 *
 */
public interface DepartmentInfoDao {
	//将Dao(数据库访问对象) 做成一个接口，在接口中声明所有数据库操作方法
	/**
	 * 添加部门信息
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public int addInfo(DepartmentInfoBean bean)throws Exception;
	
	/**
	 * 查询部门信息全部数据
	 * @return
	 * @throws Exception
	 */
	public List<DepartmentInfoBean> queryAllSource() throws Exception;
	
	/**
	 * 根据部门编号删除数据
	 * @param deptid
	 * @return
	 * @throws Exception
	 */
	public int deleteInfo(String department_id) throws Exception;
	
	/**
	 * 根据部门编号查询该部门信息
	 * @param deptid
	 * @return
	 * @throws Exception
	 */
	public DepartmentInfoBean queryByIdInfo(String department_id) throws Exception;
	
	/**
	 * 根据主键更新部门信息
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public int updateInfo(DepartmentInfoBean bean) throws Exception;
	
	/**
	 * 客户来源分页查询
	 * @param nowPage
	 * @return
	 * @throws Exception
	 */
	
	public List<Map<String, Object>> queryInfoOnPage(int nowPage) throws Exception;
	
	/**
	 * 客户来源分页查询
	 * @param nowPage
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	
	public List<Map<String, Object>> queryInfoOnPage(int nowPage,int pageSize) throws Exception;
	public int getRowCount();
	public int getPageCount() ;
	public int getNowPage();
	public int getPageSize() ;
	
	List<Map<String, Object>> queryInfoOnPage1(int nowPage, int pageSize,String text) throws Exception;
}
	
