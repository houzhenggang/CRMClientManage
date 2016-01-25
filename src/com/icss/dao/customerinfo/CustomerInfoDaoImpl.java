package com.icss.dao.customerinfo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.icss.bean.customer.CustomerInfoBean;
import com.icss.dao.BaseDao;

/**
 * CustomerInfoDao接口的实现类
 * @author 才新
 * 012202
 */
public class CustomerInfoDaoImpl extends BaseDao implements CustomerInfoDao{
	/**
	 * 添加
	 */
	public int addCustomer(CustomerInfoBean bean) throws Exception{
		StringBuilder sql = new StringBuilder()
		.append(" INSERT INTO Customer_Info(Condition_id,Source_id,User_id,Type_id,Customer_name, ")
		.append("  Customer_sex,Customer_mobile,Customer_qq,Customer_address,Customer_email,Customer_remark, ")
		.append("  Customer_job,Customer_blog,Customer_tel,Customer_msn,Birth_day,Customer_addtime,Customer_addman, ")
		.append("   Customer_changtime,Change_man,Customer_company ) ")		
		.append(" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'yyyy-mm-rr hh24:mi:ss'),to_date(?,'yyyy-mm-rr hh24:mi:ss'),?,to_date(?,'yyyy-mm-rr hh24:mi:ss'),?,?) ");
		return executeUpdate(sql.toString(), 
				bean.getCustomer_id(),
				bean.getCondition_id(),
				bean.getSource_id(),
				bean.getUser_id(),
				bean.getType_id(),
				bean.getCustomer_name(),
				bean.getCustomer_sex(),
				bean.getCustomer_mobile(),
				bean.getCustomer_qq(),
				bean.getCustomer_address(),
				bean.getCustomer_email(),
				bean.getCustomer_remark(),
				bean.getCustomer_job(),
				bean.getCustomer_blog(),
				bean.getCustomer_tel(),
				bean.getCustomer_msn(),
				bean.getBirth_day(),
				bean.getCustomer_addtime(),
				bean.getCustomer_addman(),
				bean.getCustomer_changtime(),
				bean.getChange_man(),
				bean.getCustomer_company(),
				bean.getIs_used())
				;
	}
	/**
	 * 查询全部数据 @author 才新
	 */
	@Override
	public List<CustomerInfoBean> queryAllCustomer() throws Exception {
		
		List<CustomerInfoBean> allData = new ArrayList<CustomerInfoBean>();    // 返回值
		
		StringBuilder sql = new StringBuilder()
				.append(" SELECT ")
				.append("  Customer_id,Condition_id,Source_id,User_id,Type_id,Customer_name, ")
				.append("  Customer_sex,Customer_mobile,Customer_qq,Customer_address,Customer_email,Customer_remark, ")
				.append("  Customer_job,Customer_blog,Customer_tel,Customer_msn,Birth_day,Customer_addtime,Customer_addman, ")
				.append("   Customer_changtime,Change_man,Customer_company,Is_used  ")		
				.append(" FROM Customer_Info ORDER BY Customer_id ");
		ResultSet rs = executeQuery(sql.toString());
		try {
			while (rs.next()) {
				// 将单条记录导入到Bean对象中，Bean中的属性名对应列名
				CustomerInfoBean bean = new CustomerInfoBean();
				bean.setBirth_day(rs.getString("birth_day"));
				bean.setChange_man( rs.getString("change_man"));
				bean.setCondition_id( rs.getString("condition_id"));
				bean.setCustomer_addman( rs.getString("customer_addman"));
				bean.setCustomer_address( rs.getString("customer_address"));
				bean.setCustomer_addtime( rs.getString("customer_addtime"));
				bean.setCustomer_blog( rs.getString("customer_blog"));
				bean.setCustomer_changtime( rs.getString("customer_changtime"));
				bean.setCustomer_company( rs.getString("customer_company"));
				bean.setCustomer_email( rs.getString("customer_email"));
				bean.setCustomer_id( rs.getString("customer_id"));
				bean.setCustomer_job( rs.getString("customer_job"));
				bean.setCustomer_mobile( rs.getString("customer_mobile"));
				bean.setCustomer_msn( rs.getString("customer_msn"));
				bean.setCustomer_name( rs.getString("customer_name"));
				bean.setCustomer_qq( rs.getString("customer_qq"));
				bean.setCustomer_remark( rs.getString("customer_remark"));
				bean.setCustomer_sex( rs.getString("customer_sex"));
				bean.setCustomer_tel( rs.getString("customer_tel"));
				bean.setIs_used( rs.getString("is_used"));
				bean.setSource_id( rs.getString("source_id"));
				bean.setType_id( rs.getString("type_id"));
				bean.setUser_id( rs.getString("user_id"));
				allData.add(bean);
			}
			return allData;
		} finally {
			closeAll();
		}
	}
	
	
	/**
	 * 删除数据
	 */
	@Override
	public int deletCustomer(String id) throws Exception {
		StringBuilder sql = new StringBuilder().append(" DELETE Customer_Info")
				.append("  WHERE customer_id=?");
		return executeUpdate(sql.toString(),id);
		
	}
	/**
	 * 修改数据
	 */
	@Override
	public int update(CustomerInfoBean bean) throws Exception {
		StringBuilder sql = new StringBuilder()
		.append(" UPDATE Customer_Info   ")
		.append("    SET ")
		.append("  Condition_id=?,Source_id=?,User_id=?,Type_id=?, ")
		.append("  Customer_sex=?,Customer_mobile=?,Customer_qq=?,Customer_address=?,Customer_email=?,Customer_remark=?, ")
		.append("  Customer_job=?,Customer_blog=?,Customer_tel=?,Customer_msn=?,Customer_addtime=to_date(?,'yyyy-mm-dd'), ")
		.append("  Customer_changtime=to_date(?,'yyyy-mm-rr hh24:mi:ss'),Change_man=?,Customer_company=?  ")	
		.append(" where Customer_id=? ");
		return executeUpdate(sql.toString(), 
				bean.getCondition_id(),
				bean.getSource_id(),
				bean.getUser_id(),
				bean.getType_id(),
				bean.getCustomer_sex(),
				bean.getCustomer_mobile(),
				bean.getCustomer_qq(),
				bean.getCustomer_address(),
				bean.getCustomer_email(),
				bean.getCustomer_remark(),
				bean.getCustomer_job(),
				bean.getCustomer_blog(),
				bean.getCustomer_tel(),
				bean.getCustomer_msn(),
				bean.getCustomer_addtime(),
				bean.getCustomer_changtime(),
				bean.getChange_man(),
				bean.getCustomer_company(),
				bean.getCustomer_id())
				;
	}
	/**
	 * 根据id查询数据
	 */
	@Override
	public CustomerInfoBean querybyidCustomer(String id) throws Exception {
		
		StringBuilder sql = new StringBuilder()
				.append(" SELECT ")
				.append("  customer_id,condition_id,Source_id,User_id,Type_id,customer_name, ")
				.append("  customer_sex,customer_mobile,customer_qq,customer_address,customer_email,customer_remark, ")
				.append("  customer_job,customer_blog,customer_tel,customer_msn,Birth_day,customer_addtime,customer_addman, ")
				.append("   customer_changtime,change_man,customer_company,Is_used  ")		
				.append("   FROM customerInfo ")
				.append(" WHERE customer_id=? ");
		ResultSet rs = executeQuery(sql.toString(),id);
		try {
			// 将单条记录导入到Bean对象中，Bean中的属性名对应列名
			CustomerInfoBean bean = new CustomerInfoBean();
			if(rs.next()){
				bean.setBirth_day(rs.getString("birth_day"));
				bean.setChange_man( rs.getString("change_man"));
				bean.setCondition_id( rs.getString("condition_id"));
				bean.setCustomer_addman( rs.getString("customer_addman"));
				bean.setCustomer_address( rs.getString("customer_address"));
				bean.setCustomer_addtime( rs.getString("customer_addtime"));
				bean.setCustomer_blog( rs.getString("customer_blog"));
				bean.setCustomer_changtime( rs.getString("customer_changtime"));
				bean.setCustomer_company( rs.getString("customer_company"));
				bean.setCustomer_email( rs.getString("customer_email"));
				bean.setCustomer_id( rs.getString("customer_id"));
				bean.setCustomer_job( rs.getString("customer_job"));
				bean.setCustomer_mobile( rs.getString("customer_mobile"));
				bean.setCustomer_msn( rs.getString("customer_msn"));
				bean.setCustomer_name( rs.getString("customer_name"));
				bean.setCustomer_qq( rs.getString("customer_qq"));
				bean.setCustomer_remark( rs.getString("customer_remark"));
				bean.setCustomer_sex( rs.getString("customer_sex"));
				bean.setCustomer_tel( rs.getString("customer_tel"));
				bean.setIs_used( rs.getString("is_used"));
				bean.setSource_id( rs.getString("source_id"));
				bean.setType_id( rs.getString("type_id"));
				bean.setUser_id( rs.getString("user_id"));
				return bean;
			}
		} finally {
			closeAll();
		}
		return null;
	}
	/**
	 * 批量删除
	 */
	@Override
	public boolean delCustomerByBath(Object[] paramsList) throws Exception {
		
		StringBuilder sql = new StringBuilder()
		.append(" 	DELETE FROM CustomerInfo ")
		.append(" WHERE department_id=? ");
		return executeUpdateByBatch(sql.toString(), paramsList);
	}
	/**
	 * 分页
	 */
	@Override
	public List<Map<String, Object>> queryCustomerOnepage(int nowpage, int pagesize)
			throws Exception {
		StringBuilder sql = new StringBuilder().append(" SELECT ")
				.append("  CF.customer_id,CF.condition_id,CF.Source_id,CF.User_id,CF.Type_id,customer_name, ")
				.append("  customer_sex,customer_mobile,customer_qq,customer_address,customer_email,customer_remark, ")
				.append("  customer_job,customer_blog,customer_tel,customer_msn,Birth_day,customer_addtime,customer_addman, ")
				.append("   customer_changtime,change_man,customer_company,condition_name,  ")
				.append("   source_name,type_name,user_name ")
				.append(" FROM customer_info CF,customer_condition CC,customer_source CS,customer_type CT,user_info UI   ")
				.append(" WHERE CF.CONDITION_ID=CC.CONDITION_ID AND CF.SOURCE_ID=CS.SOURCE_ID AND CF.USER_ID=UI.USER_ID AND CF.TYPE_ID=CT.TYPE_ID ");
		return queryOnPage(sql.toString(), nowpage, pagesize);
		
	}
	/**
	 * 分页
	 */
	@Override
	public List<Map<String, Object>> queryCustomerOnepage(int nowpage)
			throws Exception {
		// TODO Auto-generated method stub
		return queryCustomerOnepage(nowpage, 5);
	}
	/**
	 * 多表连接查询
	 */
	@Override
	public List<Map<String, Object>> querybyCustomer(int i,String str,int noepage ,int pagesize)
			throws Exception {
		StringBuilder sql = new StringBuilder().append(" SELECT ")
				.append("  CF.customer_id,CF.condition_id,CF.Source_id,CF.User_id,CF.Type_id,customer_name, ")
				.append("  customer_sex,customer_mobile,customer_qq,customer_address,customer_email,customer_remark, ")
				.append("  customer_job,customer_blog,customer_tel,customer_msn,Birth_day,customer_addtime,customer_addman, ")
				.append("   customer_changtime,change_man,customer_company,condition_name,  ")
				.append("   source_name,type_name,user_name ")
				.append(" FROM customer_info CF,customer_condition CC,customer_source CS,customer_type CT,user_info UI   ")
				.append(" WHERE CF.CONDITION_ID=CC.CONDITION_ID AND CF.SOURCE_ID=CS.SOURCE_ID AND CF.USER_ID=UI.USER_ID AND CF.TYPE_ID=CT.TYPE_ID AND 1=1");
		if(str!=null){
			if (i == 1) {// 客户姓名
				sql.append("  AND customer_name like ? ");
			}
			if (i == 2) {// 客户状态
				sql.append("  AND condition_name like ? ");
			}
			if (i == 3) {// 客户来源
				sql.append("  AND source_name like ? ");
			}
			if (i == 4) {// 客户类型
				sql.append("  AND type_name like ? ");
			}
			if (i == 5) {// 所属员工
				sql.append("  AND user_name like ? ");
			}
			if (i == 6) {// 客户公司
				sql.append("  AND customer_company like ? ");
			}
		//	System.out.println(sql.toString() + "'%"+str+"%'");
			return queryOnPage(sql.toString()
					, noepage, pagesize,"%"+str+"%");
		}else {
			return queryOnPage(sql.toString(), noepage, pagesize);
		}
		
	}
	
	/**
	 * 根据id   多表连接查询
	 */
	@Override
	public List<Map<String, Object>> querybyCustomer(String id)
			throws Exception {
		StringBuilder sql = new StringBuilder().append(" SELECT ")
				.append("  CF.customer_id,CF.condition_id,CF.Source_id,CF.User_id,CF.Type_id,customer_name, ")
				.append("  customer_sex,customer_mobile,customer_qq,customer_address,customer_email,customer_remark, ")
				.append("  customer_job,customer_blog,customer_tel,customer_msn,birth_day,customer_addtime,customer_addman, ")
				.append("   customer_changtime,change_man,customer_company,condition_name,  ")
				.append("   source_name,type_name,user_name ")
				.append(" FROM customer_info CF,customer_condition CC,customer_source CS,customer_type CT,user_info UI   ")
				.append(" WHERE CF.CONDITION_ID=CC.CONDITION_ID AND CF.SOURCE_ID=CS.SOURCE_ID AND CF.USER_ID=UI.USER_ID AND CF.TYPE_ID=CT.TYPE_ID AND 1=1")
				.append("  AND CF.customer_id=? ");
		
		return executeQueryByMap(sql.toString(),id);
	}
	/**
	 * 首页根据生日查询信息
	 */
	@Override
	public List<Map<String, Object>> BirthquerybyCustomer(String day)
			throws Exception {
		StringBuilder sql = new StringBuilder()
				.append(" SELECT ")
				.append("  customer_name,condition_name,birth_day,customer_mobile ")
				.append(" FROM customer_info CF,customer_condition CC   ")
				.append(" WHERE CF.CONDITION_ID=CC.CONDITION_ID AND 1=1");
		if(day!=null){
			int bday = Integer.parseInt(day);
			switch (bday) {
			case 0:
				sql.append("  and birth_day=sysdate ");
				break;
			case 7:
				sql.append("  and birth_day between sysdate and sysdate+7 ");
				break;
			case 15:
				sql.append("  and birth_day between sysdate and sysdate+7 ");
				break;
			case 30:
				sql.append("  and birth_day between sysdate and sysdate+30 ");
				break;
			default:
				break;
			}
		}else {
			sql.append("  and birth_day=sysdate ");
		}
		return executeQueryByMap(sql.toString());
	}
	
	/**
	 * 修改人：王万超
	 * 日期：2016-01-25
	 */
	@Override
	public ResultSet queryAllCustomers() throws Exception {
		
		return executeQuery(" select customer_id,customer_name from customer_info ORDER BY Customer_id  ");
	}
	
	
}
