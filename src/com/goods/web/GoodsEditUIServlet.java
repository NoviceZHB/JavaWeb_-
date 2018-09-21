package com.goods.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.goods.domain.Classify;
import com.goods.domain.Goods;
import com.goods.service.ClassifyService;
import com.goods.service.GoodsService;

/**
 * Servlet implementation class GoodsEditUIServlet
 */
@WebServlet("/GoodsEditUIServlet")
public class GoodsEditUIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		GoodsService goodsService = new GoodsService();
		Goods goods = goodsService.select(Integer.parseInt(id));
		//将获取商品的数据存到域中
		request.setAttribute("goods", goods);
		//获取分类信息
		ClassifyService classifyService = new ClassifyService();
		List<Classify> classList = classifyService.ClassifyAll();
		//将获取的分类信息存储到域中
		request.setAttribute("classList", classList);
		//在跳转到编辑页面同时打印数据
		request.getRequestDispatcher("admin/edit.jsp").forward(request, response);
		
	}

}
