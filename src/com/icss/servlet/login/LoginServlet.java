package com.icss.servlet.login;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icss.dao.user.UserDao;
import com.icss.dao.user.UserDaoFactory;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String userName = request.getParameter("userNum");
		String userPw = request.getParameter("userPw");

		UserDao dao = UserDaoFactory.getInstance();
		ResultSet rs = null;
		HttpSession session = request.getSession();
		
		String path = "view/frame/main.jsp";
		
		try {
			rs = dao.checkLogin(userName, userPw);
			if(rs != null && rs.next()){
				Cookie username = new Cookie("username", userName);
				username.setMaxAge(60*60*24*7);
				response.addCookie(username);
				
				int level = rs.getInt("role_id");
				System.out.println(level);
				session.setAttribute("sname", userName);
				session.setAttribute("slevel", level);
				
			}else{
				path = "login.jsp";
			}
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
