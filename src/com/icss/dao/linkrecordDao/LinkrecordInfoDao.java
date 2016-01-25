package com.icss.dao.linkrecordDao;

import java.util.List;
import java.util.Map;

import com.icss.bean.Linkrecord.LinkrecordBean;

public interface LinkrecordInfoDao {
	//��Dao(���ݿ���ʶ���)����һ���ӿڣ��ڽӿ��������������ݿ�Ĳ�������
	//�����ϵ��¼
	
	public int addLinkrecord (LinkrecordBean bean)throws Exception;
	
	//��ѯ��ϵ��¼
	//	public List<LinkRecordBean> queryAllLinkrecord() throws Exception;
	
	
	//������ϵ��¼id��ѯ
	public List<Map<String, Object>> queryByIdLinkrecord(int record_id) throws Exception ;
	
	//������ϵ��¼idɾ��
	public int deleteLinkrecord (int record_id) throws Exception;
	
	//��ҳ��ѯ
	public List<Map<String, Object>> queryCareOnPage(int nowPage,String whoLinkInput ,String queryType) throws Exception;
	
	//��ҳ��ѯ
	public List<Map<String, Object>> queryCareOnPage(int nowPage,int pageSize,String whoLinkInput ,String queryType) throws Exception;
	
	public int getRowCount();
	public int getPageCount() ;
	public int getNowPage();
	public int getPageSize() ;
}


