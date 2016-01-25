package com.icss.servlet.custmoerinfo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.bean.customer.CustomerInfoBean;
import com.icss.dao.customerinfo.CustomerInfoFactory;

/**
 * Servlet implementation class UpdateCustomerServlet
 */
@WebServlet("/UpdateCustomerServlet")
public class UpdateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String customerId = request.getParameter("customerId");
//		String customerName = request.getParameter("customerName"); disable 不可获得
		String customerSource = request.getParameter("customerSource");
		String customerJob = request.getParameter("customerJob");
		String customerType = request.getParameter("customerType");
		String customerSex = request.getParameter("customerSex");
		String customerEmail = request.getParameter("customerEmail");
		String customerCondition = request.getParameter("customerCondition");
		String customerMobile = request.getParameter("customerMobile");
		String customerQq = request.getParameter("customerQq");
		String customerAddress = request.getParameter("customerAddress");
		String customerChangeMan = request.getParameter("customerChangeMan");
		String customerBlog = request.getParameter("customerBlog");
		String customerTel = request.getParameter("customerTel");
		String customerMsn = request.getParameter("customerMsn");
		String customerCompany = request.getParameter("customerCompany");
		String customerAddTime = request.getParameter("customerAddTime");
		String customerChangeTime = request.getParameter("customerChangeTime");
		String customerRemark = request.getParameter("customerRemark");
		String customerForUser = request.getParameter("customerForUser");
		
		String path = "QueryOnePageCustmerServlet";
		String msg = "失败";
		boolean flag = false;
		try {
			int rows = CustomerInfoFactory.getInstance().update(
					new CustomerInfoBean(customerId, customerCondition, customerSource, 
							customerForUser, customerType, customerSex, 
							customerMobile, customerQq, customerAddress, 
							customerEmail, customerRemark, customerJob, customerBlog, 
							customerTel, customerMsn, customerAddTime, 
							customerChangeTime, customerChangeMan, customerCompany));
			if(rows>0){
				path = "QueryOnePageCustmerServlet";
				msg = "成功";
				flag = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag){
			request.setAttribute("msg", msg);
			request.setAttribute("customerId", customerId);
			request.getRequestDispatcher(path)
			.forward(request, response);
		}else {
			request.setAttribute("msg", msg);
			response.sendRedirect("QueryByidToupCustomerServlet?customerId="+customerId);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
