package com.icss.dao.linkmanDao;


public class linkmanInfoFactory {
	//工厂单例模式
	private linkmanInfoFactory(){}
	
	//通过该工厂类直接得到一个部门Dao的类对象
	public static linkmanInfoDao getInstance(){
		return new LinkmanInfoDaoImpl();
	}
	

}
