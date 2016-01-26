package com.icss.dao.DepartmentInfoDao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.icss.bean.DepartmentInfoBean;
import com.icss.dao.BaseDao;

public class DepartmentInfoDaoImpl extends BaseDao implements DepartmentInfoDao{

	/**
	 * 添加部门信息
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	 
	public int addInfo(DepartmentInfoBean bean) throws Exception {
		StringBuilder sql = new StringBuilder()
				.append(" INSERT INTO department_info(department_name,department_desc)")
				.append(" VALUES (?,?)");
		System.out.println(bean.getDepartment_name());
		return executeUpdate(sql.toString(),
				bean.getDepartment_name(),
				bean.getDepartment_desc());
	}

	/**
	 * 查询部门信息
	 * @throws Exception 
	 * 
	 */
	
	public List<DepartmentInfoBean> queryAllInfo() throws Exception {
		//返回值
		List<DepartmentInfoBean> allInfo = new ArrayList<DepartmentInfoBean>();
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder()
				.append(" SELECT ")
				.append(" department_id ")
				.append(" department_name ")
				.append(" department_desc ")
				.append(" is_used ")
				.append(" FROM ")
				.append(" department_info ");
		try {
		    rs = executeQuery(sql.toString());
		    // 解析结果集；将结果集中的数据在连接关闭前导入到list
		    while (rs.next()){
			// 将单条记录导入到Bean对象中，Bean中的属性名对应列名
			DepartmentInfoBean bean = new DepartmentInfoBean();
			bean.setDepartment_id(rs.getString("department_id"));
			bean.setDepartment_name(rs.getString("department_name"));
			bean.setDepartment_desc(rs.getString("department_desc"));
			bean.setIs_used(rs.getString("is_used"));
			// 将Bean封装到List
			allInfo.add(bean);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			closeAll();
		}
		return allInfo;
	}

	/**
	 * 跟据编号删除
	 */
	
	public int deleteInfo(String department_id) throws Exception {
		
		return executeUpdate("delete from department_info where department_id = ?",department_id);
	}

	/**
	 * 根据客户来源名查询
	 */
	public DepartmentInfoBean queryByIdInfo(String department_id) throws Exception {
		StringBuilder sql = new StringBuilder()
				.append(" SELECT department_id,department_name,department_desc,is_used ")
				.append("  FROM department_info ")
				.append(" WHERE department_name=? ");
		ResultSet rs = null;
		try{
		   rs = executeQuery(sql.toString(),department_id);
		   if(rs.next()){
			  DepartmentInfoBean bean = new DepartmentInfoBean();
			  bean.setDepartment_id(rs.getString("department_id"));
			  bean.setDepartment_name(rs.getString("department_name"));
			  bean.setDepartment_desc(rs.getString("department_desc"));
			  bean.setIs_used(rs.getString("is_used"));
			  return bean;
		    }
		  }finally{
			  closeAll();
		   }
		return null;
	}

	/**
	 * 修改部门信息
	 */
	
	public int updateInfo(DepartmentInfoBean bean) throws Exception {
		return executeUpdate("update department_info set department_name = ?,department_desc = ?,is_used = ? where department_id = ?");
		
	}

	/**
	 * 根据用户名查询是否存在
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	
	public boolean queryByName(DepartmentInfoBean bean) throws Exception{
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder()
				.append(" SELECT * FROM department_info ")
				.append("  WHERE department_id=? and department_name=? ")
				.append("  and department_desc=? and is_used=? ");
		try{
			rs = executeQuery(sql.toString(),bean.getDepartment_id(),bean.getDepartment_name(),bean.getDepartment_desc(),bean.getIs_used());
			if(rs.next()){
				return true;
			}
		}finally{
			closeAll();
		}
		return false;
	}
	
	/**分页查询
	 * @Override
	 */
	public List<Map<String, Object>> queryInfoOnPage(int nowPage) throws Exception {
		
		return queryInfoOnPage(nowPage, 5);
	}

	public List<Map<String, Object>> queryInfoOnPage(int nowPage, int pageSize) throws Exception {
		
		return queryOnPage("SELECT department_id, department_name ,department_desc FROM department_info ORDER BY department_id", nowPage, pageSize);
	}

	@Override
	public List<DepartmentInfoBean> queryAllSource() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 客户来源模糊查询
	 */
	public List<Map<String, Object>> queryInfoOnPage1(int nowPage,String text) throws Exception {
		
		return queryInfoOnPage1(nowPage,5,text);
	}
	
    public List<Map<String, Object>> queryInfoOnPage1(int nowPage, int pageSize,String text) throws Exception {
		
		return queryOnPage("SELECT department_id, department_name ,department_desc FROM department_info WHERE department_name LIKE ? ORDER BY department_id", nowPage, pageSize,"%"+text+"%");
	}
}
