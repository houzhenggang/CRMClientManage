package com.icss.dao.customerCare;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import com.icss.bean.customerCare.CustomerCareBean;
import com.icss.dao.BaseDao;

import oracle.net.aso.e;
/**
 * 
 * @author ÍõÍò³¬
 */
public class CustomerCareDaoImpl extends BaseDao implements CustomerCareDao{

	@Override
	public int addCustomerCare(CustomerCareBean careBean) throws Exception {
		StringBuilder sql = new StringBuilder()
				.append(" INSERT INTO customer_care(customer_id,care_theme,care_way,care_time,care_remark,care_nexttime,care_people)  ")
				.append(" values(?,?,?,to_date(?,'yyyy-mm-dd'),?,to_date(?,'yyyy-mm-dd'),?)")
				;
		return executeUpdate(sql.toString(), careBean.getCustomer_id(),
				careBean.getCare_theme(),
				careBean.getCare_way(),
				careBean.getCare_time(),
				careBean.getCare_remark(),
				careBean.getCare_nexttime(),
				careBean.getCare_people());
	}

	@Override
	public int delCustomerCare(int id) throws Exception {
		
		return executeUpdate(" delete from customer_care where care_id=? ", id);
	}

	@Override
	public List<Map<String, Object>> queryCareOnPage(int nowPage, int pageSize) throws Exception {
		StringBuilder sql = new StringBuilder()
				.append(" select * from customer_care ")
				.append(" order by care_id ")
				;
		return queryOnPage(sql.toString(), nowPage, pageSize);
	}

	@Override
	public int updateCare(CustomerCareBean careBean) throws Exception {
		StringBuilder sql = new StringBuilder()
				.append(" update customer_care ")
				.append(" set  customer_id=?, ")
				.append(" care_theme=?, care_way=?, ")
				.append(" care_remark=?, ")
				.append(" care_nexttime=to_date(?,'yyyy-mm-dd'),care_people=? ")
				.append(" where care_id=? ")
				;
				
		return executeUpdate(sql.toString(), careBean.getCustomer_id(),
				careBean.getCare_theme(),careBean.getCare_way(),
				careBean.getCare_remark(),
				careBean.getCare_nexttime(),
				careBean.getCare_people(),
				careBean.getCare_id());
	}

	@Override
	public ResultSet queryCareById(int care_id) throws Exception {
		
		return executeQuery("select * from customer_care where care_id=? ", care_id);
	}

	public List<Map<String, Object>> queryCareByTheme(int nowPage,int pageSize,String theme) 
			throws Exception{
		StringBuilder sql = new StringBuilder()
				.append(" select * from customer_care  ")
				.append(" where care_theme like '%"+theme+"%'  ")
				;
		
		return queryOnPage(sql.toString(),nowPage, pageSize);
	}
	
	public List<Map<String, Object>> queryCareByCustomer(int nowPage,int pageSize,int customer) 
			throws Exception{
		
		return queryOnPage(" select * from customer_care where customer_id=? ",nowPage, pageSize,customer);
	}
	
	public List<Map<String, Object>> queryCareByCareway(int nowPage,int pageSize,String careway) 
			throws Exception{
		StringBuilder sql = new StringBuilder()
				.append(" select * from customer_care  ")
				.append(" where care_way like '%"+careway+"%'  ")
				;
		
		return queryOnPage(sql.toString(),nowPage, pageSize);
	}
	
	@Override
	public ResultSet checkId(int id) throws Exception {
		StringBuilder sql = new StringBuilder()
				.append(" select distinct customer_id from customer_care ")
				.append(" where customer_id like '"+ id +"%'")
				;
		
		return executeQuery(sql.toString());
	}

	@Override
	public ResultSet checkTheme(String theme) throws Exception {
		StringBuilder sql = new StringBuilder()
				.append(" select distinct care_theme from customer_care ")
				.append(" where care_theme like '"+ theme +"%'")
				;
		
		return executeQuery(sql.toString());
	}

	@Override
	public ResultSet checkWay(String way) throws Exception {
		StringBuilder sql = new StringBuilder()
				.append(" select distinct care_way from customer_care ")
				.append(" where care_way like '"+ way +"%'")
				;
		
		return executeQuery(sql.toString());
	}
}
