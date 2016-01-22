package com.icss.servlet.customerCare;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.dao.customerCare.CustomerCareDao;
import com.icss.dao.customerCare.CustomerCareFactory;

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
			if(nowPage<=0){
				nowPage = 1;
			}
		}
		
		List<Map<String, Object>> allData = new ArrayList<>();
		String idcheck = request.getParameter("idcheck");

		try {
			if(idcheck != null && idcheck.equals("2")){
				String queryType = request.getParameter("queryType");
				String customerInput = request.getParameter("customerInput");
				
				System.out.println("queryType - "+ queryType+"\t customerInput - "+customerInput);
				if(queryType.equals("1")){
					int cust_id = Integer.parseInt(queryType);
					allData = dao.queryCareByCustomer(nowPage,4,cust_id);
				}else if(queryType.equals("2")){
					allData = dao.queryCareByTheme(nowPage,4,customerInput);
				}else if (queryType.equals("3")){
					allData = dao.queryCareByCareway(nowPage,4,customerInput);
				}
				request.setAttribute("queryType", queryType);
				request.setAttribute("customerInput", customerInput);
				request.setAttribute("mark", 2);
			}else{
	            allData = dao.queryCareOnPage(nowPage, 4);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(allData);
		request.setAttribute("Cares", allData);
	
		request.setAttribute("nowPage", dao.getNowPage());
		request.setAttribute("pageCount", dao.getPageCount());
		request.setAttribute("rowCount", dao.getRowCount());
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
