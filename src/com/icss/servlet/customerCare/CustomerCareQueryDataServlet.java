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
 * ʵ�ִ�customerCare_list.jspҳ�����customerCare_add.jspʱ����customer_info������
 * @author ����
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
		CustomerInfoDao dao2 = CustomerInfoFactory.getInstance();   //ʹ�õ�Test2�����ߵķ���
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
