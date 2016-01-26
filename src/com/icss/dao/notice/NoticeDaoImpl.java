package com.icss.dao.notice;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.icss.bean.NoticeBean;
import com.icss.dao.BaseDao;

/**
 * NoticeDao接口的实现类
 * @author 才新
 * 011901
 */
public class NoticeDaoImpl extends BaseDao implements NoticeDao{
	/**
	 * 添加
	 */
	public int addNotice(NoticeBean bean) throws Exception{
		StringBuilder sql = new StringBuilder()
		.append(" INSERT INTO notice_info( ")
		.append("  notice_content,notice_endtime,notice_item,notice_time,User_id ) ")		
		.append(" VALUES (?,to_date(?,'yyyy-mm-rr hh24:mi:ss'),?,to_date(?,'yyyy-mm-rr hh24:mi:ss'),?) ");
		return executeUpdate(sql.toString(), 
				bean.getNotice_content(),
				bean.getNotice_endtime(),
				bean.getNotice_item(),
				bean.getNotice_time(),
				bean.getUser_id())
				;
	}
	
	/**
	 * 删除数据
	 */
	@Override
	public int deletNotice(String id) throws Exception {
		StringBuilder sql = new StringBuilder()
				.append(" DELETE Notice_Info")
				.append("  WHERE Notice_id=?");
		return executeUpdate(sql.toString(),id);
		
	}
	
	/**
	 * 分页  降序
	 */
	@Override
	public List<Map<String, Object>> queryNoticeOnepage(int nowpage, int pagesize)
			throws Exception {
		StringBuilder sql = new StringBuilder()
				.append(" SELECT ")
				.append("  notice_id,notice_content,notice_endtime,notice_item, ")
				.append("  notice_time,NI.user_id,user_name  ")	
				.append(" FROM Notice_info NI,user_info UI   ")
				.append(" WHERE NI.user_id=UI.user_id ORDER BY notice_endtime desc ");
		return queryOnPage(sql.toString()
				, nowpage, pagesize);	
	}
	/**
	 * 分页
	 */
	@Override
	public List<Map<String, Object>> queryNoticeOnepage(int nowpage)
			throws Exception {
		// TODO Auto-generated method stub
		return queryNoticeOnepage(nowpage, 5);
	}
	
	/**
	 * 多表模糊连接查询
	 */
	@Override
	public List<Map<String, Object>> querybyNotice(int i,String str,int noepage ,int pagesize)
			throws Exception {
		StringBuilder sql = new StringBuilder()
				.append(" SELECT ")
				.append("  notice_id,notice_content,notice_endtime,notice_item, ")
				.append("  notice_time,NI.user_id,user_name  ")	
				.append(" FROM Notice_info NI,user_info UI   ")
				.append(" WHERE NI.user_id=UI.user_id AND 1=1 ");
		if(str!=null){
			switch (i) {
			case 1://公告主题
				sql.append("  AND notice_item like ? ");
				break;
			case 2://公告内容
				sql.append("  AND notice_content like ? ");
				break;
			}
			return queryOnPage(sql.toString()
					, noepage, pagesize,"%"+str+"%");
		}
		return queryOnPage(sql.toString()
				, noepage, pagesize);
	}
	
	/**
	 * 多表连接查询，查看有效信息，结束时间大于系统时间
	 */
	@Override
	public List<Map<String, Object>> querybeUseNotice() throws Exception {
		StringBuilder sql = new StringBuilder()
				.append(" SELECT ")
				.append("  notice_id,notice_content,notice_endtime,notice_item, ")
				.append("  notice_time,NI.user_id,user_name  ")	
				.append(" FROM Notice_info NI,user_info UI   ")
				.append(" WHERE NI.user_id=UI.user_id and notice_endtime>sysdate ")
				.append(" ORDER BY notice_endtime desc ");
		return executeQueryByMap(sql.toString());
	}
	
	
}
