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

@WebServlet("/CustomerCareUpdateServlet")
public class CustomerCareUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CustomerCareUpdateServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String care_id = request.getParameter("care_id");
		int careId = Integer.parseInt(care_id);
		String  customerId= request.getParameter("customerId");
		int cusId = Integer.parseInt(customerId);
		
		String caretime = request.getParameter("careTime").substring(0, 10);
		String  careNexttime= request.getParameter("careNexttime").substring(0, 10);
		String  careWay= request.getParameter("careWay");
		String  careRemark= request.getParameter("careRemark");
		String  carePeople= request.getParameter("carePeople");
		String  careTheme= request.getParameter("careTheme");
		
		System.out.println(careId+"***"+cusId+"---"+caretime+careNexttime+"---"+careWay+"---"+careRemark+"---"+carePeople+"---"+careTheme);
		CustomerCareDao dao = CustomerCareFactory.getInstance();
		CustomerCareBean careBean = new CustomerCareBean(careId,cusId,careTheme,careWay,caretime,careRemark,careNexttime,carePeople);
		String path = "CustomerCareQueryServlet";
		try {
			int rows = dao.updateCare(careBean);
			
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
