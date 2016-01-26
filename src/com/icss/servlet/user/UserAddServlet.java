package com.icss.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.bean.UserBean;
import com.icss.dao.user.UserDao;
import com.icss.dao.user.UserDaoFactory;

@WebServlet("/UserAddServlet")
public class UserAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserAddServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String userNum = request.getParameter("userNum");
		String userAge= request.getParameter("userAge");
		int uage = Integer.parseInt(userAge);
		String userPw= request.getParameter("userPw");
		String userSex= request.getParameter("userSex");
		String userNation= request.getParameter("userNation");
		String userDiploma= request.getParameter("userDiploma");
		String isMarried= request.getParameter("isMarried");
		String departmentId= request.getParameter("departmentId");
		int dep_id=Integer.parseInt(departmentId);
		String roleId= request.getParameter("roleId");
		int rid = Integer.parseInt(roleId);
		String userTel= request.getParameter("userTel");
		String userIntest= request.getParameter("userIntest");
		String userBankcard= request.getParameter("userBankcard");
		String userMobile= request.getParameter("userMobile");
		String userIdnum= request.getParameter("userIdnum");
		String userAddtime= request.getParameter("userAddtime");
		String userAddress= request.getParameter("userAddress");
		String userAddman= request.getParameter("userAddman");
		String userEmail=request.getParameter("userEmail");
        		
		UserBean userBean = new UserBean(dep_id, rid, userName, userSex, userMobile,
				uage, userAddress, userNum, userPw, userTel, userIdnum,
				userEmail, userAddtime, userAddman, userIntest, userDiploma,
				userBankcard, userNation, isMarried);
		UserDao dao = UserDaoFactory.getInstance();
		
		String path = "UserQueryServlet";
		try {
			int row = dao.addUser(userBean);
			if(row>0){
				System.out.println("≤Â»Î≥…π¶");
			}else{
				
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
