package com.sec.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.Dao.userinfoDao;
import com.sec.model.userinfo;


@WebServlet("/userinfoServlet")
public class userinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public userinfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//处理中文乱码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		userinfoDao dao= new userinfoDao();
		//获取op
		String op=request.getParameter("op");
		if(op==null||"".equals(op)) {
			ArrayList<userinfo> list=dao.query();
			request.setAttribute("list", list);
			request.getRequestDispatcher("show.jsp").forward(request, response);
		}else if("proce".equals(op)) {
			//存储过程调用
			ArrayList<userinfo> list=dao.query1();
			request.setAttribute("list", list);
			request.getRequestDispatcher("show.jsp").forward(request, response);
		}else if("toadd".equals(op)) {
			response.sendRedirect("add.jsp");
		}else if("add".equals(op)) {
			int id=Integer.parseInt(request.getParameter("id"));
			String name=request.getParameter("name");
			userinfo user=new userinfo();
			user.setId(id);
			user.setName(name);
			
			int i=dao.insert(user);
			System.out.println(i);
			
				response.sendRedirect("userinfoServlet");
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
