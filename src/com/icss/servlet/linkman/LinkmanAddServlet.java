package com.icss.servlet.linkman;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.bean.linkmanBean.LinkmanBean;
import com.icss.dao.linkmanDao.linkmanInfoFactory;



@WebServlet("/LinkmanAddServlet")
public class LinkmanAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得数据
		int customer_id = Integer.parseInt(request.getParameter("userName"));
		String linkman_name = request.getParameter("linkManName");
		String linkman_sex = request.getParameter("LinkManSex");
		String linkman_job = request.getParameter("linkManJob");
		String linkman_mobile = request.getParameter("linkManMobile");
		int linkman_age = Integer.parseInt(request.getParameter("linkManAge"));
		String linkman_relation = request.getParameter("linkManRelation");
		//转向路径
		String path = "/view/linkman/linkman_save.jsp";
		//提示信息
		String info = "添加失败";		
		//调用Dao方法
		
		try {
			if((linkmanInfoFactory.getInstance().addLinkman(new LinkmanBean(customer_id,linkman_name,linkman_sex,linkman_job,linkman_mobile,linkman_age,linkman_relation))>0)){
				// 成功提示信息
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
