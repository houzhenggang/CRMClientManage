package com.icss.dao.DepartmentInfoDao;


public class DepartmentInfoDaoFactory {
	//工厂单例模式
		private DepartmentInfoDaoFactory(){}
			
		//通过该工厂类直接得到一个部门Dao的类对象
		public static DepartmentInfoDao getInstance(){
			return new DepartmentInfoDaoImpl();
		}
}
