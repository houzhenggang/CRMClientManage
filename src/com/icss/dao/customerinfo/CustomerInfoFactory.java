package com.icss.dao.customerinfo;
/**
 * CustomerInfo工厂
 * @author 才新
 * @version 011901
 */
public class CustomerInfoFactory {
	//工厂单例模式
	private CustomerInfoFactory(){}
	
	//通过该工厂类直接得到一个部门Dao的类对象
	public static CustomerInfoDao getInstance(){
		return new CustomerInfoDaoImpl();
	}
}
