package com.icss.servlet.linkrecord;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.bean.LinkrecordBean;
import com.icss.dao.linkrecordDao.LinkrecordInfoFactory;


@WebServlet("/LinkrecordAddServlet")
public class LinkrecordAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得数据
		
		int customer_id =Integer.parseInt(request.getParameter("customerId"));
		String who_link = request.getParameter("whoLink");
		String link_type = request.getParameter("linkType");
		String link_theme = request.getParameter("linkTheme");
		String link_nexttime = request.getParameter("linkNexttime");
		String link_remark = request.getParameter("linkRemark");
		
		//转向路径
		String path = "/view/linkrecord/linkrecord_save.jsp";
		//提示信息
		String info = "添加失败";

		//调用Dao方法
		try {
			if(LinkrecordInfoFactory.getInstance().addLinkrecord(new LinkrecordBean(customer_id, who_link, link_type, 
					link_theme, link_nexttime, link_remark ))>0){
				// 成功转向登录页面
				//path = "login.jsp";
				info = "添加成功";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 添加属性
		request.setAttribute("info", info);
		// 请求转发
		request.getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
