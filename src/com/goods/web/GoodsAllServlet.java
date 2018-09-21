package com.goods.web;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.goods.domain.Goods;
import com.goods.service.GoodsService;

/**
 * Servlet implementation class GoodsAllServlet
 */
@WebServlet("/GoodsAllServlet")
public class GoodsAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GoodsService goodsAllService = new GoodsService();
		List<Goods> goodsAll = goodsAllService.findAll();
		//对集合进行反转，因为添加商品的时候新添加的商品要显示在第一个
		Collections.reverse(goodsAll);
		request.setAttribute("goodsAll", goodsAll);
		//服务端跳转，所有只需要WebContent下的路径即可
		request.getRequestDispatcher("admin/main.jsp").forward(request, response);
	}

}
