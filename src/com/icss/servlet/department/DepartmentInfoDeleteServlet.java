package com.icss.servlet.department;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.dao.DepartmentInfoDao.DepartmentInfoDao;
import com.icss.dao.DepartmentInfoDao.DepartmentInfoDaoFactory;


/**
 * Servlet implementation class DepartmentInfoDeleteServlet
 */
@WebServlet("/DepartmentInfoDeleteServlet")
public class DepartmentInfoDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获得数据
		String department_id = request.getParameter("department_id");
		DepartmentInfoDao dao = DepartmentInfoDaoFactory.getInstance();
		//默认删除失败
		String path ="view/department/department_add.jsp";
		String msg = "删除失败";
		// 调用Dao方法
		try {
			int row = dao.deleteInfo(department_id);
			if(row>0){
				// 添加成功，更改路径
				path = "DepartmentInfoQueryServlet";
				msg = "删除成功";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//设置request对象的属性
		request.setAttribute("msg", msg);
		request.setAttribute("path", path);
		//响应客户端
		request.getRequestDispatcher(path)
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
