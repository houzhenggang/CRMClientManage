package com.icss.dao.linkmanDao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.icss.bean.LinkmanBean;
import com.icss.dao.BaseDao;


public class LinkmanInfoDaoImpl extends BaseDao implements linkmanInfoDao{

	
	//添加联系人
	@Override
	public int addLinkman(LinkmanBean bean) throws Exception {
		StringBuilder sql = new StringBuilder()
				.append(" INSERT INTO CUSTOMER_LINKMAN")
				.append(" (customer_id,linkman_name,linkman_sex,linkman_job,linkman_mobile,linkman_age,linkman_relation)")
				.append(" VALUES(?,?,?,?,?,?,?)")
				;
		return executeUpdate(sql.toString(),bean.getCustomer_id(),
				bean.getLinkman_name(),bean.getLinkman_sex(),bean.getLinkman_job(),bean.getLinkman_mobile(),
				bean.getLinkman_age(),bean.getLinkman_relation());
	}

	 
	// 根据id查询
	@Override
	public List<Map<String, Object>> queryByIdLinkman(int linkman_id) throws Exception {
		StringBuilder sql = new StringBuilder()
				.append("select nownum,linkman_id,b.customer_name,linkman_name,linkman_sex,"
						+ "linkman_job,linkman_mobile,linkman_age,linkman_relation,is_used ")
				.append("  from customer_linkman a,customer_info b")
				.append("  where a.customer_id=b.customer_id")
				.append("    and linkman_id=?")
				.append("    and a.is_used=1")				
				;
		return executeQueryByMap(sql.toString(), linkman_id);
	}
	
	
	//根据联系人id编号删除数据
	@Override
	public int deleteLinkman(int linkman_id) throws Exception {
		
		return executeUpdate("DELETE FROM CUSTOMER_LINKMAN WHERE linkman_id = ?",linkman_id);		
	}
	
	
	//根据主键更新联系人数据
	@Override
	public int updateLinkman(LinkmanBean bean) throws Exception {
		StringBuilder sql = new StringBuilder()
				.append(" UPDATE CUSTOMER_LINKMAN ")
				.append(" SET ")
				.append(" customer_id=?")
				.append(" linkman_name=?")
				.append(" linkman_sex=?")
				.append(" linkman_job=?")
				.append(" linkman_mobile=?")
				.append(" linkman_age=?")
				.append(" linkman_relation=?")
				.append(" is_used=?")
				.append(" WHERE linkman_id=?")
		;
		return executeUpdate(sql.toString(), bean.getCustomer_id(),bean.getLinkman_name(),
				bean.getLinkman_sex(),bean.getLinkman_job(),bean.getLinkman_job(),
				bean.getLinkman_mobile(),bean.getLinkman_age(),bean.getLinkman_relation(),
				bean.getIs_used(),bean.getLinkman_id());
	}
	
	
	//分页查询
	@Override
	public List<Map<String, Object>> queryLinkmanOnPage(int nowPage, String LinkmanInput, String queryType)
			throws Exception {
		// TODO Auto-generated method stub
		return queryLinkmanOnPage(nowPage, LinkmanInput, queryType);
	}
	
	
	//分页查询
	@Override
	public List<Map<String, Object>> queryLinkmanOnPage(int nowPage, int pageSize, String linkmanInput,
			String queryType) throws Exception {
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder()
				.append("select linkman_id,b.customer_name,linkman_name,linkman_sex,"
						+ "linkman_job,linkman_mobile,linkman_age,linkman_relation,a.is_used ")
				.append("  from customer_linkman a,customer_info b")
				.append("  where a.customer_id=b.customer_id")
				.append("    and a.is_used=1")				
				;	
		if (linkmanInput != null && !"".equals(linkmanInput.trim()) && "1".equals(queryType)) {
			sql.append("and  linkman_name  like   '%" + linkmanInput + "%'");
		}else if (linkmanInput != null && !"".equals(linkmanInput.trim()) && "1".equals(queryType))  {
			sql.append("and  b.customer_name  like   '%" + linkmanInput + "%' ");
		}
		return queryOnPage(sql.toString(), nowPage, 1);
	}
	}
