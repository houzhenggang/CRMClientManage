package com.icss.servlet.department;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.bean.department.DepartmentInfoBean;
import com.icss.dao.DepartmentInfoDao.DepartmentInfoDao;
import com.icss.dao.DepartmentInfoDao.DepartmentInfoDaoFactory;

/**
 * Servlet implementation class DepartmentInfoAddServlet
 */
@WebServlet("/DepartmentInfoAddServlet")
public class DepartmentInfoAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String departmentName = request.getParameter("departmentName");
		String departmentDesc = request.getParameter("departmentDesc");
		//默认登陆失败
		System.out.println(departmentName);
		String path ="view/department/department_add.jsp";
		String msg = "客户来源名添加失败";
		DepartmentInfoDao dao = DepartmentInfoDaoFactory.getInstance();
		try{
			int row = dao.addInfo(new DepartmentInfoBean(departmentName,departmentDesc));
			if(row>0){
				//注册成功,更改路径
				path = "DepartmentInfoQueryServlet";
				msg = "客户来源名添加成功";
			}
		}catch (Exception e) {
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
