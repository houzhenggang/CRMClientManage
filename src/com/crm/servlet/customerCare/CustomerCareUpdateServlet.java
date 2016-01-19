package com.crm.servlet.customerCare;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		CustomerCareDao dao = CustomerCareFactory.getInstance();
		//dao.updateCare(careBean);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		doGet(request, response);
	}

}
