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
		//获取页面文本框的值
		String whoLinkInput = request.getParameter("whoLinkInput");
		String queryType = request.getParameter("queryType");
		//取当前页代码
		String pagenumStr = request.getParameter("pagenum");
		//默认取第一页值
		int pagenum = 1;
		if(pagenumStr!=null){
			pagenum = Integer.parseInt(pagenumStr);
		}
		//调用dao分页查询方法，取数据送到jsp页面
		LinkrecordInfoDao dao = LinkrecordInfoFactory.getInstance();
		List<Map<String, Object>> allData;
		try {
			allData = dao.queryCareOnPage(pagenum, 3, whoLinkInput, queryType);
			//将查询数据添加到request
			request.setAttribute("allData", allData);
			request.setAttribute("nowPage", dao.getNowPage());
			request.setAttribute("pageCount", dao.getPageCount());
			request.setAttribute("rowCount", dao.getRowCount());
			request.setAttribute("pageSize", dao.getPageSize());
		} catch (Exception e) {
			e.printStackTrace();
		}		
		//转向
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
