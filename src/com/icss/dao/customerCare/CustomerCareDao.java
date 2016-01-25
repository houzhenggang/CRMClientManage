package com.icss.dao.customerCare;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import com.icss.bean.customerCare.CustomerCareBean;

public interface CustomerCareDao {

	public int addCustomerCare(CustomerCareBean careBean) throws Exception;
	
	public int delCustomerCare(int id) throws Exception;
	
	public int updateCare(CustomerCareBean careBean) throws Exception;
	
	public ResultSet queryCareById(int care_id) throws Exception;
	
	public List<Map<String, Object>> queryCareOnPage( int nowPage,int pageSize) throws Exception;
	public int getRowCount();
	public int getPageSize();
	public int getNowPage() ;
	public int getPageCount();
	
	public List<Map<String, Object>> queryCareByTheme(int nowPage,int pageSize,String theme) throws Exception;
	
	public List<Map<String, Object>> queryCareByCustomer(int nowPage,int pageSize,int customer) throws Exception;
	
	public List<Map<String, Object>> queryCareByCareway(int nowPage,int pageSize,String careway) throws Exception;
	
	//根据客户关怀，关怀主题，关怀方式查询
	public ResultSet checkId(int id) throws Exception;
	public ResultSet checkTheme(String theme) throws Exception;
	public ResultSet checkWay(String way) throws Exception;
}
