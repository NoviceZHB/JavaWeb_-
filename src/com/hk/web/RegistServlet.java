package com.hk.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hk.domain.User;
import com.hk.util.JdbcUtil;


/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//判断验证码输入是否正确
		String code = request.getParameter("code");
		String word = (String) this.getServletContext().getAttribute("checkCode");
		if(code.equals(word)) {
			//如果正确就开始存储信息
			//获取参数
			String uname = request.getParameter("uname");
			String pwd = request.getParameter("pwd");
			String phone = request.getParameter("phone");
			User user = new User();
			user.setUname(uname);
			user.setPwd(pwd);
			user.setPhone(phone);
			//随机获取id
			user.setUid(UUID.randomUUID().toString());
			try {
				//连接数据库
				Connection conn = JdbcUtil.getConnection();
				String sql = "insert into user values(?,?,?,?);";
				PreparedStatement pst = conn.prepareStatement(sql);
				pst.setString(1, user.getUid());
				pst.setString(2, user.getUname());
				pst.setString(3, user.getPwd());
				pst.setString(4, user.getPhone());
				int i = pst.executeUpdate();
				if(i > 0) {
					System.out.println("注册成功");
					response.setHeader("refresh", "1;url=/JavaWeb4/login.jsp");
				}else {
					System.out.println("注册失败");
				}
				JdbcUtil.free(null, pst, conn);
			} catch (SQLException e) {
				System.out.println("操作数据库失败!!!");
				e.printStackTrace();
			}
			
			
			
			
		}else {
			//验证码错误过1秒跳转到注册页面
			response.getWriter().write("验证码错误!!!");
			response.setHeader("refresh", "1;url=/JavaWeb4/regist.jsp");
		}
			
		
	}

}
