package com.icss.servlet.customerCare;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.dao.customerinfo.CustomerInfoDao;
import com.icss.dao.customerinfo.CustomerInfoFactory;
/**
 * 实现从customerCare_list.jsp页面进入customerCare_add.jsp时调用customer_info的数据
 * @author 王万超
 *
 */

@WebServlet("/CustomerCareQueryDataServlet")
public class CustomerCareQueryDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CustomerCareQueryDataServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		CustomerInfoDao dao2 = CustomerInfoFactory.getInstance();   //使用到Test2开发者的方法
		String path = "view/customerCare/customerCare_add.jsp";
		
		ResultSet cust_rs = null;
		try {
			cust_rs = dao2.queryAllCustomers();
	        request.setAttribute("cust_add", cust_rs);
	        System.out.println(cust_rs.getRow());
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
        
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		doGet(request, response);
	}

}
