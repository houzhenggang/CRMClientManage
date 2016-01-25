package com.icss.servlet.notice;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.icss.dao.customerinfo.CustomerInfoDao;
import com.icss.dao.customerinfo.CustomerInfoFactory;
import com.icss.dao.notice.NoticeDao;
import com.icss.dao.notice.NoticeFactory;

/**
 * notice分页查询方式查询
 * @author 才新
 * @version 012001
 */
@WebServlet("/QueryOnePageNoticeServlet")
public class QueryOnePageNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//取当前页的代码
		String pagenumstr = request.getParameter("pagenum");
		int pagenum = 1;  //默认第一页
		if (pagenumstr!=null){
			pagenum = Integer.parseInt(pagenumstr);
		}
		System.out.println(pagenum);
		String path = "view/notice/notice_list.jsp";//jsp成功界面
		
		try{
			NoticeDao dao = NoticeFactory.getInstance();
			List<Map<String, Object>> alldate = dao.queryNoticeOnepage(pagenum, 5);
			System.out.println(alldate);
			request.setAttribute("alldate", alldate);
			request.setAttribute("nowPage", dao.getNowPage());
			request.setAttribute("pageCount", dao.getPageCount());
			request.setAttribute("pageSize", dao.getPageSize());
			request.setAttribute("rowCount", dao.getRowCount());
			System.out.println(dao.getNowPage());
			System.out.println(dao.getPageCount());
			System.out.println(dao.getPageSize());
			System.out.println(dao.getRowCount());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher(path)
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
