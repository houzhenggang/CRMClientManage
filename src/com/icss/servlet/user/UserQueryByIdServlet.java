package com.icss.servlet.user;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.dao.user.UserDao;
import com.icss.dao.user.UserDaoFactory;
import com.sun.org.apache.bcel.internal.generic.DALOAD;

@WebServlet("/UserQueryByIdServlet")
public class UserQueryByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserQueryByIdServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String qid = request.getParameter("qid");
		String user_id = request.getParameter("user_id");
		int uid = Integer.parseInt(user_id);
		
		System.out.println(qid + "---" +uid);
		String path = "view/user/user_more.jsp";
		if(qid.equals("1")){
			path = "view/user/user_update.jsp";
			
		}else{
			System.out.println("ฯ๊ว้าณ");
		}
		
		UserDao dao = UserDaoFactory.getInstance();
		List<Map<String, Object>> allData = new ArrayList<>();
		
		try {
			allData = dao.queryUserById(uid);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(allData);
		request.setAttribute("allData", allData);
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
