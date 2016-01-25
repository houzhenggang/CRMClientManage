package com.icss.dao.notice;
/**
 * NoticeFactory通知工厂
 * @author 才新
 * @version 012001
 */
public class NoticeFactory {
	//工厂单例模式
	private NoticeFactory(){}
	
	//通过该工厂类直接得到一个部门Dao的类对象
	public static NoticeDao getInstance(){
		return new NoticeDaoImpl();
	}
}
