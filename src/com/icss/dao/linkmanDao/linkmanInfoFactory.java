package com.icss.dao.linkmanDao;


public class linkmanInfoFactory {
	//��������ģʽ
	private linkmanInfoFactory(){}
	
	//ͨ���ù�����ֱ�ӵõ�һ������Dao�������
	public static linkmanInfoDao getInstance(){
		return new LinkmanInfoDaoImpl();
	}
	

}
