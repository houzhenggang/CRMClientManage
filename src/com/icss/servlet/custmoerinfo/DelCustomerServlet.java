package com.icss.servlet.custmoerinfo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.dao.customerinfo.CustomerInfoFactory;

/**
 * Servlet implementation class DelCustomerServlet
 */
@WebServlet("/DelCustomerServlet")
public class DelCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String customerId = request.getParameter("customerId");
		
		String path = "QueryOnePageCustmerServlet";
		String msg = "删除失败";
		System.out.println(msg);
		
		try {
			int rows = CustomerInfoFactory.getInstance().deletCustomer(customerId);
			if(rows>0){
				path="QueryOnePageCustmerServlet";
				msg = "删除成功";
				System.out.println(msg);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
