package com.icss.dao.customerinfo;

import java.util.List;
import java.util.Map;

import com.icss.bean.customer.CustomerInfoBean;
/**
 * CustomerInfo客户信息dao
 * @author 才新
 * 011901
 */
public interface CustomerInfoDao {
	//将dao（数据访问对象）做成一个接口，在接口中声明所有数据库操作方法
	public int addCustomer(CustomerInfoBean bean)throws Exception;
	//查询
	public List<CustomerInfoBean> queryAllCustomer() throws Exception;
	//删除
	public int deletCustomer(String id)throws Exception;
	//修改
	public int update(CustomerInfoBean bean)throws Exception;
	//根据部门编号查询部门信息
	public CustomerInfoBean querybyidCustomer(String id)throws Exception;
	//批量删除
	public boolean delCustomerByBath(Object[] paramsList)throws Exception;
	//部门分页查询
	public List<Map<String, Object>>queryCustomerOnepage(int noepage ,int pagesize) throws Exception;
	
	public List<Map<String, Object>>queryCustomerOnepage(int noepage) throws Exception;
	//多表连接查询 按照查询方式
	public List<Map<String, Object>>querybyCustomer(int i,String str,int noepage ,int pagesize) throws Exception;
	//多表连接查询 按照id
	public List<Map<String, Object>> querybyCustomer(String id) throws Exception;
	//多表连接查询 首页按照生日查询
	public List<Map<String, Object>> BirthquerybyCustomer(String day) throws Exception;
	
	public int getRowCount();
	public int getPageCount() ;
	public int getNowPage();
	public int getPageSize() ;

}
