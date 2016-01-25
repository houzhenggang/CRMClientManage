package com.icss.servlet.custmoerinfo;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.dao.customerinfo.CustomerInfoDao;
import com.icss.dao.customerinfo.CustomerInfoFactory;

/**
 * id 查询方式查询
 * @author 才新
 * @version 011901
 */
@WebServlet("/QueryByidCustomerServlet")
public class QueryByidCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String customerId = request.getParameter("customerId");
		
		String path = "login.jsp"; // 失败界面
		String msg = "查询失败";
		
		try {
			
			List<Map<String, Object>> onedate = 
					CustomerInfoFactory.getInstance().querybyCustomer(customerId);
			System.out.println(onedate);
			if(onedate.size()>0){
			request.setAttribute("onedate", onedate.get(0));
			path = "view/customer/customer_more.jsp";//成功界面
			msg="成功";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(msg);
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
