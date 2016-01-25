package com.icss.servlet.department;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.dao.DepartmentInfoDao.DepartmentInfoDao;
import com.icss.dao.DepartmentInfoDao.DepartmentInfoDaoFactory;


/**
 * Servlet implementation class DepartmentInfoQueryServlet
 */
@WebServlet("/DepartmentInfoQueryServlet")
public class DepartmentInfoQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// 取当前页的代码
	   String pagenumStr = request.getParameter("pagenum");
	    //默认取第一页数据
		int pagenum = 1;
		if(pagenumStr!=null){
			pagenum = Integer.parseInt(pagenumStr);
		}
		System.out.println(pagenum);
		String path = "view/department/department_list.jsp";
		//调用dao分页查询方法，取数据送到jsp页面*---
		try {
			DepartmentInfoDao dao = DepartmentInfoDaoFactory.getInstance();
			List<Map<String,Object>> allData = dao.queryInfoOnPage(pagenum, 5);
			request.setAttribute("allData", allData);
			request.setAttribute("nowPage", dao.getNowPage());
			request.setAttribute("PageCount", dao.getPageCount());
			request.setAttribute("RowCount", dao.getRowCount());
			request.setAttribute("PageSize", dao.getPageSize());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher(path)
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
