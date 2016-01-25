package com.icss.dao.linkrecordDao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.icss.bean.Linkrecord.LinkrecordBean;
import com.icss.dao.BaseDao;

public class LinkrecordInfoDaoImpl extends BaseDao implements LinkrecordInfoDao{
	
	//添加联系记录
	@Override
	public int addLinkrecord(LinkrecordBean bean) throws Exception {
		StringBuilder sql = new StringBuilder()
				.append(" INSERT INTO CUSTOMER_LINKREORD")
				.append(" (")
				.append(" customer_id,who_link,link_type,link_theme,link_nexttime,link_remark")
				.append(" )")
				.append("VALUES (?,?,?,?,?,?)")
				;
		
		return executeUpdate(sql.toString(), bean.getCustomer_id(),
				bean.getWho_link(),bean.getLink_type(),bean.getLink_theme(),
				bean.getLink_nexttime(),bean.getLink_remark());
	}

	
	//根据联系记录ID查询
	@Override
	public List<Map<String, Object>> queryByIdLinkrecord(int record_id) throws Exception {
		List<Map<String, Object>> allData = new ArrayList<Map<String,Object>>();//返回值
		StringBuilder sql = new StringBuilder()
				.append(" select")
				.append(" rownum,b.customer_name,link_time,who_link,link_type,link_theme,link_nexttime,link_remark")
				.append("  from")
				.append(" customer_linkrecord a ,customer_info b")
				.append("  where")
				.append(" a.customer_id=b.customer_id")
				.append("  and record_id=?")
				.append("  and a.is_used=1")
				;
		return executeQueryByMap(sql.toString(), record_id);
	}

	
	//删除联系人记录
	@Override
	public int deleteLinkrecord(int record_id) throws Exception {
		return executeUpdate("DELETE FROM CUSTOMER_LINKREORD WHERE record_id = ?",record_id);		
	}
	
	//分页查询
	@Override
	public List<Map<String, Object>> queryCareOnPage(int nowPage, String whoLinkInput, String queryType)
			throws Exception {
		return queryCareOnPage(nowPage,whoLinkInput ,queryType);
	}
	@Override
	public List<Map<String, Object>> queryCareOnPage(int nowPage, int pageSize, String whoLinkInput,
			String queryType) throws Exception {
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder()
				.append(" select")
				.append(" record_id,b.customer_name,link_time,who_link,link_type,link_theme,link_nexttime,link_remark,a.is_used")
				.append("  from")
				.append(" customer_linkreord a ,customer_info b")
				.append("  where")
				.append(" a.customer_id=b.customer_id")
				.append("  and a.is_used=1")
				;
		if (whoLinkInput != null && !"".equals(whoLinkInput.trim())&& "1".equals(queryType)) {
			sql.append("  and  b.customer_name  like '%"+whoLinkInput+"%'");
		}	else if (whoLinkInput != null && !"".equals(whoLinkInput.trim())&& "2".equals(queryType)) {
			sql.append("  and  link_theme  like '%"+whoLinkInput+"%'");
		}else if (whoLinkInput != null && !"".equals(whoLinkInput.trim())&& "3".equals(queryType)) {
			sql.append("  and  linkType  like '%"+whoLinkInput+"%'");
		}
		return queryOnPage(sql.toString(),nowPage,1);
	}


}
	


