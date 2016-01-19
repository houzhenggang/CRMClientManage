package com.crm.servlet.customerCare;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.dao.customerCare.CustomerCareDao;
import com.crm.dao.customerCare.CustomerCareFactory;

@WebServlet("/CustomerCareDeleteServlet")
public class CustomerCareDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CustomerCareDeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		CustomerCareDao dao = CustomerCareFactory.getInstance();
		String care_id = request.getParameter("id");
		int id = Integer.parseInt(care_id);
		
		String path = "CustomerCareQueryServlet";
		try {
			dao.delCustomerCare(id);
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
