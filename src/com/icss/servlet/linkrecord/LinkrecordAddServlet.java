package com.icss.servlet.linkrecord;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.bean.LinkrecordBean;
import com.icss.dao.linkrecordDao.LinkrecordInfoFactory;


@WebServlet("/LinkrecordAddServlet")
public class LinkrecordAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�������
		
		int customer_id =Integer.parseInt(request.getParameter("customerId"));
		String who_link = request.getParameter("whoLink");
		String link_type = request.getParameter("linkType");
		String link_theme = request.getParameter("linkTheme");
		String link_nexttime = request.getParameter("linkNexttime");
		String link_remark = request.getParameter("linkRemark");
		
		//ת��·��
		String path = "/view/linkrecord/linkrecord_save.jsp";
		//��ʾ��Ϣ
		String info = "���ʧ��";

		//����Dao����
		try {
			if(LinkrecordInfoFactory.getInstance().addLinkrecord(new LinkrecordBean(customer_id, who_link, link_type, 
					link_theme, link_nexttime, link_remark ))>0){
				// �ɹ�ת���¼ҳ��
				//path = "login.jsp";
				info = "��ӳɹ�";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// �������
		request.setAttribute("info", info);
		// ����ת��
		request.getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
