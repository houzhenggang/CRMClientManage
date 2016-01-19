package com.crm.servlet.customerCare;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.dao.customerCare.CustomerCareDao;
import com.crm.dao.customerCare.CustomerCareFactory;

@WebServlet("/CustCareQueryByType")
public class CustCareQueryByType extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CustCareQueryByType() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		CustomerCareDao dao = CustomerCareFactory.getInstance();
		String type = request.getParameter("queryType");
		String queryType = request.getParameter("customerInput");
		
		System.out.println(type+"---"+queryType);
		String path = "view/customerCare/customerCare_list.jsp";
		List<Map<String, Object>> allData = new ArrayList<>();
		try {
			if(type.equals("1")){
				int cust_id = Integer.parseInt(queryType);
				allData = dao.queryCareByCustomer(cust_id);
			}else if(type.equals("2")){
				allData = dao.queryCareByTheme(queryType);
			}else if (type.equals("3")){
				allData = dao.queryCareByCareway(queryType);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("Cares", allData);
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
