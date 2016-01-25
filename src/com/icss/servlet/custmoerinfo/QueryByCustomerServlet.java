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
 * 不同查询方式查询
 * @author 才新
 * @version 011901
 */
@WebServlet("/QueryByCustomerServlet")
public class QueryByCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String queryType = request.getParameter("queryType");
		int type = Integer.parseInt(queryType);
		String str = request.getParameter("customerInput");
		String msg = "失败";
		System.out.println(type+str);
		
		String pagenumstr = request.getParameter("pagenum");
		int pagenum = 1;  //默认第一页
		if (pagenumstr!=null){
			pagenum = Integer.parseInt(pagenumstr);
		}
		System.out.println(pagenum);
		String path = "view/customer/customer_list.jsp";
		
		try {
			CustomerInfoDao dao = CustomerInfoFactory.getInstance();
			List<Map<String, Object>> alldate = dao.querybyCustomer(type,str,pagenum,5);
			msg="成功";
			System.out.println(alldate);
			request.setAttribute("alldate", alldate);
			
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
