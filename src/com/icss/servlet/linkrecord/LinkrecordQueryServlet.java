package com.icss.servlet.linkrecord;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.dao.linkrecordDao.LinkrecordInfoDao;
import com.icss.dao.linkrecordDao.LinkrecordInfoFactory;


@WebServlet("/LinkrecordQueryServlet")
public class LinkrecordQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡҳ���ı����ֵ
		String whoLinkInput = request.getParameter("whoLinkInput");
		String queryType = request.getParameter("queryType");
		//ȡ��ǰҳ����
		String pagenumStr = request.getParameter("pagenum");
		//Ĭ��ȡ��һҳֵ
		int pagenum = 1;
		if(pagenumStr!=null){
			pagenum = Integer.parseInt(pagenumStr);
		}
		//����dao��ҳ��ѯ������ȡ�����͵�jspҳ��
		LinkrecordInfoDao dao = LinkrecordInfoFactory.getInstance();
		List<Map<String, Object>> allData;
		try {
			allData = dao.queryCareOnPage(pagenum, 3, whoLinkInput, queryType);
			//����ѯ������ӵ�request
			request.setAttribute("allData", allData);
			request.setAttribute("nowPage", dao.getNowPage());
			request.setAttribute("pageCount", dao.getPageCount());
			request.setAttribute("rowCount", dao.getRowCount());
			request.setAttribute("pageSize", dao.getPageSize());
		} catch (Exception e) {
			e.printStackTrace();
		}		
		//ת��
		request.getRequestDispatcher("view/linkrecord/linkrecord_list.jsp")
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
