package com.icss.dao.linkmanDao;

import java.util.List;
import java.util.Map;

import com.icss.bean.LinkmanBean;

public interface linkmanInfoDao {
	// ��Dao(���ݿ���ʶ���)����һ���ӿڣ��ڽӿ��������������ݿ�Ĳ�������
	//�����ϵ��
	public int addLinkman(LinkmanBean bean) throws Exception;
	
	//��ѯ��ϵ��ȫ������
//	public List<LinkmanBean> queryAllLinkman() throws Exception;
	
	
	//������ϵ��ID��ѯ
	public List<Map<String, Object>> queryByIdLinkman (int linkman_id) throws Exception;
	
	
	//������ϵ�˱��ɾ����ϵ������
	public int deleteLinkman(int linkman_id) throws Exception;
	
	
	//��������������ϵ������
	 public int updateLinkman(LinkmanBean bean) throws Exception;


	//��ҳ��ѯ
	public List<Map<String, Object>> queryLinkmanOnPage (int nowPage,String linkmanInput ,String queryType)throws Exception;
	
	public List<Map<String, Object>> queryLinkmanOnPage(int nowPage,int pageSize,String LinkmanInput ,String queryType)throws Exception;
	
	public int getRowCount();
	public int getPageCount();
	public int getNowPage();
	public int getPageSize();
}
