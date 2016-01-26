package com.icss.servlet.notice;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.bean.UserBean;
import com.icss.dao.customerinfo.CustomerInfoDao;
import com.icss.dao.customerinfo.CustomerInfoFactory;
import com.icss.dao.user.UserDaoFactory;

/**
 * id 查询方式查询 并且转向更改
 * @author 才新
 * @version 012101
 */
@WebServlet("/QueryToupdateNoticeServlet")
public class QueryToupdateNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		String path = "login.jsp"; // 失败界面
		String msg = "查询失败";
		
		try {
			List<UserBean> onedateuser = 
					UserDaoFactory.getInstance().queryAllUser();
			
			System.out.println(onedateuser);
			if(onedateuser.size()>0){
			request.setAttribute("onedateuser", onedateuser);
			path = "view/notice/notice_add.jsp";//成功界面
			msg="成功";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(msg);
		request.setAttribute("msg", msg);
		
		request.getRequestDispatcher(path)
		.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
