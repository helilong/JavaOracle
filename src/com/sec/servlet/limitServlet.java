package com.sec.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.Dao.userinfolimit;
import com.sec.model.userinfo;
import com.sec.util.pageModel;

/**
 * Servlet implementation class limitServlet
 */
@WebServlet("/limitServlet")
public class limitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public limitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String pageNo=null;
		pageNo=request.getParameter("pageNo");
		if(pageNo==null){
			pageNo="1";
			
		}
		userinfolimit dao=new userinfolimit();
		pageModel<userinfo> pm=dao.getAllUserinfo1(Integer.parseInt(pageNo));
		request.setAttribute("allinfo",pm);
		request.setAttribute("list",pm.getList());
		request.getRequestDispatcher("limit1.jsp").forward(request,response);
		
	}

}
