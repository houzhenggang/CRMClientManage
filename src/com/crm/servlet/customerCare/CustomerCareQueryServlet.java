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

@WebServlet("/CustomerCareQueryServlet")
public class CustomerCareQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CustomerCareQueryServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		CustomerCareDao dao = CustomerCareFactory.getInstance();
		int nowPage = 1;
		String nowPageStr = request.getParameter("pagenum");
		String path = "view/customerCare/customerCare_list.jsp";
		
		if(nowPageStr == null || nowPageStr == ""){
			System.out.println("传入值为空");
		}else{
			nowPage = Integer.parseInt(nowPageStr);
		}
		
		List<Map<String, Object>> allData = new ArrayList<>();
		try {
			allData = dao.queryCareOnPage(nowPage, 4);
			
			request.setAttribute("Cares", allData);
			System.out.println(allData);
			request.setAttribute("nowPage", dao.getNowPage());
			request.setAttribute("pageCount", dao.getPageCount());
			request.setAttribute("rowCount", dao.getRowCount());
			
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
