package com.icss.servlet.customerCare;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.bean.CustomerCareBean;
import com.icss.bean.CustomerInfoBean;
import com.icss.dao.customerCare.CustomerCareDao;
import com.icss.dao.customerCare.CustomerCareFactory;
import com.icss.dao.customerinfo.CustomerInfoDao;
import com.icss.dao.customerinfo.CustomerInfoFactory;
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
		CustomerInfoDao dao2 = CustomerInfoFactory.getInstance();   //使用到Test2开发者的方法
		String care_id = request.getParameter("id");
		int id = Integer.parseInt(care_id);
		ResultSet rs = null;
		CustomerCareBean careBean = new CustomerCareBean();
		ResultSet cust_rs = null;
		
		String path = "view/customerCare/customerCare_update.jsp";
		try {
			
			cust_rs = dao2.queryAllCustomers();
            request.setAttribute("customers", cust_rs);
			
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
