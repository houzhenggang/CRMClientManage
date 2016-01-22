package com.icss.servlet.customerCare;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.bean.customerCare.CustomerCareBean;
import com.icss.dao.customerCare.CustomerCareDao;
import com.icss.dao.customerCare.CustomerCareFactory;
import com.sun.org.apache.xerces.internal.impl.xs.SubstitutionGroupHandler;

@WebServlet("/CustCareQueryByIdServlet")
public class CustCareQueryByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CustCareQueryByIdServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		CustomerCareDao dao = CustomerCareFactory.getInstance();
		String care_id = request.getParameter("id");
		int id = Integer.parseInt(care_id);
		ResultSet rs = null;
		CustomerCareBean careBean = new CustomerCareBean();
		
		String path = "view/customerCare/customerCare_update.jsp";
		try {
			rs = dao.queryCareById(id);
			while(rs.next()){
				careBean.setCare_id(id);
				careBean.setCustomer_id(rs.getInt(2));
				careBean.setCare_theme(rs.getString(3));
				careBean.setCare_way(rs.getString(4));
				careBean.setCare_time(rs.getString(5));
				careBean.setCare_remark(rs.getString(6));
				careBean.setCare_nexttime(rs.getString(7));
				careBean.setCare_people(rs.getString(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("careUpdBean", careBean);
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		doGet(request, response);
	}

}
