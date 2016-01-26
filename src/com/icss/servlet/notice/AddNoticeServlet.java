package com.icss.servlet.notice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.bean.CustomerInfoBean;
import com.icss.bean.NoticeBean;
import com.icss.dao.customerinfo.CustomerInfoFactory;
import com.icss.dao.notice.NoticeFactory;

/**
 * 增加公告
 * @author 才新
 * @version 012001
 */
@WebServlet("/AddNoticeServlet")
public class AddNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String customerForUser = request.getParameter("customerForUser");
		String noticeEndTime = request.getParameter("noticeEndTime");
		String noticeTime = request.getParameter("noticeTime");
		String noticeContent = request.getParameter("noticeContent");
		String noticeItem = request.getParameter("noticeItem");
		System.out.println(noticeEndTime);
		System.out.println(noticeTime);
		System.out.println(customerForUser);
		System.out.println(noticeContent);
		System.out.println(noticeItem);

		String path = "login.jsp"; //失败界面
		String msg = "添加失败";
		
		try {
			int rows = NoticeFactory.getInstance().addNotice(
					new NoticeBean(customerForUser, noticeItem, 
							noticeContent, noticeTime, noticeEndTime));
			if(rows>0){
				path = "QueryOnePageNoticeServlet";//成功路径
				msg = "添加成功";	
			}
		} catch (Exception e) {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
