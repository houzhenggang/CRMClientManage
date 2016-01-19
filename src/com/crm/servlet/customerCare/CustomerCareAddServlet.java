package com.crm.servlet.customerCare;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.bean.customerCare.CustomerCareBean;
import com.crm.dao.customerCare.CustomerCareDao;
import com.crm.dao.customerCare.CustomerCareFactory;

@WebServlet("/CustomerCareAddServlet")
public class CustomerCareAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CustomerCareAddServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String  customerId= request.getParameter("customerId");
		int cusId = Integer.parseInt(customerId);
		String  careTime= request.getParameter("careTime");
		String  careNexttime= request.getParameter("careNexttime");
		String  careWay= request.getParameter("careWay");
		String  careRemark= request.getParameter("careRemark");
		String  carePeople= request.getParameter("carePeople");
		String  careTheme= request.getParameter("careTheme");
		
		System.out.println(cusId+careTime);
		CustomerCareDao dao = CustomerCareFactory.getInstance();
		CustomerCareBean careBean = new CustomerCareBean(cusId,careTheme,careWay,careTime,careRemark,careNexttime,carePeople);
		String path = "CustomerCareQueryServlet";
		try {
			int rows = dao.addCustomerCare(careBean);
			
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
