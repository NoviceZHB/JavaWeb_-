package com.goods;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.classfile.Method;





/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		//获取当前的字节码
		Class clazz = this.getClass();
		String path = null;
		try {
			
			java.lang.reflect.Method method = clazz.getMethod(action, HttpServletRequest.class,HttpServletResponse.class);
			//判断有没有传入的方法
			if(method != null) {
				//如果有就调用
				try {
					path = (String) method.invoke(this, request,response);
					//转发
					if(path != null) {
						request.getRequestDispatcher("path").forward(request,response);
					}
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("增加");
		return "add.jsp";
	}
	public String del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("删除");
		return "del.jsp";
		
	}
	public String update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("更新");
		return "update.jsp";
	}
	public String find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("查找");
		return "find.jsp";
	}

}
