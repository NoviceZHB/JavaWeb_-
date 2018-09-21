package com.hk.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hk.domain.User;
import com.hk.util.JdbcUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//获取页面参数
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		//从数据库中查询账号密码是否与登录时匹配
		try {
			Connection con = JdbcUtil.getConnection();
			String sql = "select * from user where uname=? and pwd=?;";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, uname);
			pst.setString(2, pwd);
			ResultSet rs = pst.executeQuery();
			User user = new User();
			while(rs.next()) {
				user.setUid(rs.getString("uid"));
				user.setUname(rs.getString("uname"));
				user.setPwd(rs.getString("pwd"));
				user.setPhone(rs.getString("phone"));
			}
			if(user.getUid() == null) {
				response.getWriter().write("登录失败");
				//定时刷新重定向，1秒后跳转
				response.setHeader("refresh", "1;url=login.jsp");
			}else {
				response.getWriter().write("登录成功");
				//将登陆的用户名保存起来
				HttpSession session = request.getSession();
				Cookie cookie = new Cookie("JSESSIONID", session.getId());
				cookie.setMaxAge(0);
				response.addCookie(cookie);
				session.setAttribute("user", user);
				response.setHeader("refresh", "1;url=index.jsp");
			}
			JdbcUtil.free(rs, pst, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库查询失败!!!");
			e.printStackTrace();
		}
	}
	

}
