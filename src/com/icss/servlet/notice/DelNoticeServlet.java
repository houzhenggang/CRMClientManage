package com.icss.servlet.notice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.dao.customerinfo.CustomerInfoFactory;
import com.icss.dao.notice.NoticeFactory;

/**
 * Servlet implementation class DelCustomerServlet
 */
@WebServlet("/DelNoticeServlet")
public class DelNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String notice_id = request.getParameter("notice_id");
		
		String path = "QueryOnePageNoticeServlet";
		String msg = "删除失败";
		
		
		try {
			int rows = NoticeFactory.getInstance().deletNotice(notice_id);
			if(rows>0){
				path="QueryOnePageNoticeServlet";
				msg = "删除成功";
				System.out.println(msg);
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
