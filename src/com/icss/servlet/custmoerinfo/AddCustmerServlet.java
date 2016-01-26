package com.icss.servlet.custmoerinfo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.bean.CustomerInfoBean;
import com.icss.dao.customerinfo.CustomerInfoFactory;

/**
 * 增加用户
 * @author 才新
 * @version 011901
 */
@WebServlet("/AddCustmerServlet")
public class AddCustmerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String customerName = request.getParameter("customerName");
		String customerSource = request.getParameter("customerSource");
		String customerJob = request.getParameter("customerJob");
		String customerType = request.getParameter("customerType");
		String customerSex = request.getParameter("customerSex");
		String customerEmail = request.getParameter("customerEmail");
		String customerBirthday = request.getParameter("customerBirthday");
		String customerCondition = request.getParameter("customerCondition");
		String customerMobile = request.getParameter("customerMobile");
		String customerQq = request.getParameter("customerQq");
		String customerAddress = request.getParameter("customerAddress");
		String customerChangeMan = request.getParameter("customerChangeMan");
		String customerAddMan = request.getParameter("customerAddMan");
		String customerBlog = request.getParameter("customerBlog");
		String customerTel = request.getParameter("customerTel");
		String customerMsn = request.getParameter("customerMsn");
		String customerCompany = request.getParameter("customerCompany");
		String customerAddTime = request.getParameter("customerAddTime");
		String customerChangeTime = request.getParameter("customerChangeTime");
		String customerRemark = request.getParameter("customerRemark");
		String userNum = request.getParameter("userNum");//用session获得
		
		String path = "login.jsp"; //失败界面
		String msg = "添加失败";
		System.out.println(msg);
		
		try {
			int rows = CustomerInfoFactory.getInstance().addCustomer(
					new CustomerInfoBean(customerCondition, customerSource, userNum, 
							customerType, customerName, customerSex, customerMobile, 
							customerQq, customerAddress, customerEmail, customerRemark, 
							customerJob, customerBlog, customerTel, customerMsn, 
							customerBirthday, customerAddTime, customerAddMan, 
							customerChangeTime, customerChangeMan, customerCompany));
			if(rows>0){
				path = "QueryOnePageCustmerServlet";//成功路径
				msg = "添加成功";	
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
