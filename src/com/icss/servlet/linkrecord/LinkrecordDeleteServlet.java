package com.icss.servlet.linkrecord;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.dao.linkrecordDao.LinkrecordInfoDao;
import com.icss.dao.linkrecordDao.LinkrecordInfoFactory;


@WebServlet("/LinkrecordDeleteServlet")
public class LinkrecordDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得数据
		int record_id = Integer.parseInt(request.getParameter("record_id"));
		LinkrecordInfoDao dao = LinkrecordInfoFactory.getInstance();
		try {
			int row = dao.deleteLinkrecord(record_id);			
			if (row>0) {
				request.setAttribute("info", "联系记录删除成功");
			}else{
				request.setAttribute("info", "联系记录删除失败");
			}			
			request.getRequestDispatcher("/view/linkrecord/linkrecord_save.jsp").forward(request, response);
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
