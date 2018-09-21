package com.goods.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.goods.domain.Admin;
import com.goods.service.AdminService;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收用户名和密码
		String uname = request.getParameter("username");
		String pwd= request.getParameter("password");
		System.out.println("输入的账号为:"+uname+"\t输入的密码为:"+pwd);
		//调用业务层
		AdminService adminService = new AdminService();
		try {
			Admin admin  = adminService.login(uname,pwd);
			if(admin.getUname().equals(uname) && admin.getPwd().equals(pwd)){
				System.out.println("管理员登录成功");
				//1.将用户保存
				HttpSession session = request.getSession();
				session.setAttribute("admin", admin);
				//2.重定向，让浏览器跳转到指定位置
				response.sendRedirect(request.getContextPath()+"/admin/admin_index.jsp");
			}else {
				System.out.println("管理员登录失败");
			}
		} catch (Exception e) {
			if(e.getMessage().equals("用户名或密码错误")) {
				System.out.println("管理员登录失败");
				//跳转到登录页面同时回显账号或密码错误提示信息
				request.setAttribute("err", e.getMessage());
				request.getRequestDispatcher("admin/admin_login.jsp").forward(request, response);
			}else {
				e.printStackTrace();
			}
		}
		
	}

}
