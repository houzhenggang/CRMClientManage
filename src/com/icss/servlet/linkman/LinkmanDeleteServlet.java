package com.icss.servlet.linkman;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.dao.linkmanDao.linkmanInfoDao;
import com.icss.dao.linkmanDao.linkmanInfoFactory;


@WebServlet("/LinkmanDeleteServlet")
public class LinkmanDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得数据
		int linkman_id = Integer.parseInt(request.getParameter("linkman_id"));
		linkmanInfoDao dao = linkmanInfoFactory.getInstance();
		try {
			int row = dao.deleteLinkman(linkman_id);			
			if (row>0) {
				request.setAttribute("info", "联系记录删除成功");
			}else{
				request.setAttribute("info", "联系记录删除失败");
			}			
			request.getRequestDispatcher("/view/linkman/linkman_save.jsp").forward(request, response);
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
