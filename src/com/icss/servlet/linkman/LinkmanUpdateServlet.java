package com.icss.servlet.linkman;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.icss.bean.linkmanBean.LinkmanBean;
import com.icss.dao.linkmanDao.linkmanInfoDao;
import com.icss.dao.linkmanDao.linkmanInfoFactory;


@WebServlet("/LinkmanUpdateServlet")
public class LinkmanUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取文本框的值
		int linkman_id = Integer.parseInt(request.getParameter("linkman_id"));
		int customer_id = Integer.parseInt(request.getParameter("customer_id"));
		String linkman_name = request.getParameter("linkman_name");
		String linkman_sex = request.getParameter("linkman_sex");
		String linkman_job = request.getParameter("linkman_job");
		String linkman_mobile = request.getParameter("linkman_mobile");
		int linkman_age = Integer.parseInt(request.getParameter("linkman_age"));
		String linkman_relation = request.getParameter("linkman_relation");
		String is_used = request.getParameter("is_used");
		
		linkmanInfoDao dao = linkmanInfoFactory.getInstance();
		try {
			int row = dao.updateLinkman(new LinkmanBean(linkman_id, customer_id,
					linkman_name, linkman_sex, linkman_job, linkman_mobile, linkman_age, linkman_relation, is_used));
			if (row>0){		
				request.setAttribute("info", "修改成功");
			}else{
				request.setAttribute("info", "修改失败");
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
