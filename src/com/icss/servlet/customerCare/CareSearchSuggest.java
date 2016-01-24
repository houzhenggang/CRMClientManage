package com.icss.servlet.customerCare;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.dao.customerCare.CustomerCareDao;
import com.icss.dao.customerCare.CustomerCareFactory;

@WebServlet("/CareSearchSuggest")
public class CareSearchSuggest extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CareSearchSuggest() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String str = request.getParameter("search");
		String queryType = request.getParameter("queryType");
		
		
		PrintWriter out = response.getWriter();
		ResultSet rs = null;
		List strList = new ArrayList<>();
		CustomerCareDao dao = CustomerCareFactory.getInstance();
		try {
			if(str != null && str.length()>0){
				if(request.getHeader("X-Requested-With")!=null
						&& request.getHeader("X-Requested-With").equalsIgnoreCase("XMLHttpRequest"))
				{
					str = new String(str.getBytes("iso8859-1"),"utf-8");
				}else{
					str = new String(str.getBytes("iso8859-1"),"GBK");
				}
				
				if(queryType.equals("1")){
					int id = Integer.parseInt(str);
					rs = dao.checkId(id);
				}else if(queryType.equals("2")){
					rs = dao.checkTheme(queryType);
				}else{
					rs = dao.checkWay(queryType);
				}	
				
				while (rs.next()) {
					strList.add(rs.getInt(1));
				}
				
				StringBuffer sBuffer = new StringBuffer();
				int size = strList.size();
				for(int i=0; i<size; i++){
					sBuffer.append(strList.get(i)+"-");
				}
				System.out.println(sBuffer.toString());
				out.print(sBuffer.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			out.flush();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}