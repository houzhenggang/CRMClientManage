package com.icss.dao.linkrecordDao;

public class LinkrecordInfoFactory {
	
	//��������ģʽ
	private LinkrecordInfoFactory(){}
	
	//ͨ���ù�����ֱ�ӵõ�һ����ϵ��¼Dao�������
	public static LinkrecordInfoDao getInstance(){
		return new LinkrecordInfoDaoImpl();
	}
	
	

}
