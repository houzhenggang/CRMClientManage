package com.icss.dao.linkrecordDao;

public class LinkrecordInfoFactory {
	
	//工厂单例模式
	private LinkrecordInfoFactory(){}
	
	//通过该工厂类直接得到一个联系记录Dao的类对象
	public static LinkrecordInfoDao getInstance(){
		return new LinkrecordInfoDaoImpl();
	}
	
	

}
