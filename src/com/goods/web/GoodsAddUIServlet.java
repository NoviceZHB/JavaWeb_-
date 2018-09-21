package com.goods.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.goods.domain.Classify;
import com.goods.service.ClassifyService;

/**
 * Servlet implementation class ClassifyServlet
 */
@WebServlet("/GoodsAddUIServlet")
public class GoodsAddUIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//先从数据库中获取分类信息
		ClassifyService classifyService = new ClassifyService();
		List<Classify> classList = classifyService.ClassifyAll();
		//将获到的信息存到request域中
		request.setAttribute("classList", classList);
		//将信息转发到增加页面中
		request.getRequestDispatcher("admin/add.jsp").forward(request, response);
	}

}
