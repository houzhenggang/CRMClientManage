package com.icss.servlet.linkrecord;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.dao.linkrecordDao.LinkrecordInfoFactory;


@WebServlet("/LinkrecordQueryByIdServlet")
public class LinkrecordQueryByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ȡ��URL�еĲ��ű��
		int record_id =Integer.parseInt (request.getParameter("record_id"));

		String info = "��ѯʧ��";
		String path = "login.jsp";
		//���ò�ѯ����
		List<Map<String, Object>> bean = null;
		try {
			bean = LinkrecordInfoFactory.getInstance().queryByIdLinkrecord(record_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//��bean��װ�� request
		request.setAttribute("bean", bean);
		//ת��
		request.getRequestDispatcher(path).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
