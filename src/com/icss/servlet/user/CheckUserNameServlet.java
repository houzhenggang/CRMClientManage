package com.icss.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.dao.user.UserDao;
import com.icss.dao.user.UserDaoFactory;

@WebServlet("/CheckUserNameServlet")
public class CheckUserNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CheckUserNameServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("name");
		PrintWriter out = response.getWriter();
		
		System.out.println(userName);
		UserDao dao = UserDaoFactory.getInstance();
		ResultSet rs = null;
		try {	
			rs = dao.checkName();
			
			while (rs.next()) {
				System.out.println(rs.getString("user_name"));
				if(userName.equals(rs.getString("user_name"))){
					out.print(true);
				}else{
					continue;
				}	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			out.flush();
			out.close();
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
