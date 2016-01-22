package com.icss.servlet.user;

import java.io.IOException;
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

@WebServlet("/UserQueryServlet")
public class UserQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserQueryServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int nowPage = 1;
		String nowPageStr = request.getParameter("pagenum");
		String idcheck = request.getParameter("idcheck");
		
		if(nowPageStr == null || nowPageStr == ""){
			System.out.println("当前页的值nowPage传入值为空");
			
		}else{
			nowPage = Integer.parseInt(nowPageStr);
			if(nowPage<0){
				nowPage = 1;
			}
		}
		
		String path = "view/user/user_list.jsp";
		
		UserDao dao = UserDaoFactory.getInstance();
		List<Map<String, Object>> allData = new ArrayList<>();
		
		try {
			if(idcheck != null && idcheck.equals("2")){
				String queryType = request.getParameter("queryType");
				String userInput = request.getParameter("userInput");

				if(queryType.equals("1")){
					allData = dao.queryUserByName(nowPage,4,userInput);	
				}
				request.setAttribute("queryType", queryType);
				request.setAttribute("userInput", userInput);
				request.setAttribute("mark", 2);
			}else{
				allData = dao.queryUserOnPage(nowPage, 4);		
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(allData);
		request.setAttribute("allData", allData);
		request.setAttribute("nowPage", dao.getNowPage());
		request.setAttribute("pageCount",dao.getPageCount() );
		request.setAttribute("rowCount", dao.getRowCount());
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
