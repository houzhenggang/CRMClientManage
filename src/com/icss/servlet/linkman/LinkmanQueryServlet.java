package com.icss.servlet.linkman;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.dao.linkmanDao.linkmanInfoDao;
import com.icss.dao.linkmanDao.linkmanInfoFactory;


@WebServlet("/LinkmanQueryServlet")
public class LinkmanQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ����
		String linkmanInput = request.getParameter("linkmanInput");
		String queryType = request.getParameter("queryType");
		//��ȡ��ǰҳ
		String pagenumStr = request.getParameter("pagenum");
		//Ĭ��ȡ��һҳֵ
		int pagenum = 1;
		if(pagenumStr!=null){
			pagenum = Integer.parseInt(pagenumStr);
		}
		//����dao��ҳ��ѯ������ȡ�����͵�jspҳ��
		linkmanInfoDao dao =linkmanInfoFactory.getInstance();

		try {
			List<Map<String, Object>> allData = dao.queryLinkmanOnPage(pagenum, 1, linkmanInput, queryType);
			request.setAttribute("allData", allData);
			request.setAttribute("nowPage", dao.getNowPage());
			request.setAttribute("pageCount", dao.getPageCount());
			request.setAttribute("rowCount", dao.getRowCount());
			request.setAttribute("pageSize", dao.getPageSize());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//ת��
		request.getRequestDispatcher("/view/linkman/linkman_list.jsp")
		.forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
