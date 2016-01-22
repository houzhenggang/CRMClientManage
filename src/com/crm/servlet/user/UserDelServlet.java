package com.crm.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.dao.user.UserDao;
import com.crm.dao.user.UserDaoFactory;

@WebServlet("/UserDelServlet")
public class UserDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserDelServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String uid = request.getParameter("user_id");
		int user_id = Integer.parseInt(uid);
		
		UserDao dao = UserDaoFactory.getInstance();
		String path="view/user/user_save.jsp";
		String info = "É¾³ý³É¹¦";
		try {
			int rows = dao.delUser(user_id);
			if(rows>0){
				System.out.println("É¾³ý³É¹¦");
			}else{
				info = "É¾³ýÊ§°Ü";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("info", info);
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
