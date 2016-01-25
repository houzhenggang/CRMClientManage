package com.icss.servlet.linkman;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QueryByIdLinkManServlet
 */
@WebServlet("/LinkmanQueryByIdServlet")
public class LinkmanQueryByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取URL中的id
		int linkman_id = Integer.parseInt(request.getParameter("linkman_id"));
		// TODO Auto-generated method stub		
		//转向
		request.getRequestDispatcher("view/linkman/linkman_update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
