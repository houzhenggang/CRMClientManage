package com.crm.dao.customerCare;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import com.crm.bean.customerCare.CustomerCareBean;

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
	
	public List<Map<String, Object>> queryCareByTheme(String theme) throws Exception;
	
	public List<Map<String, Object>> queryCareByCustomer(int customer) throws Exception;
	
	public List<Map<String, Object>> queryCareByCareway(String careway) throws Exception;
}
