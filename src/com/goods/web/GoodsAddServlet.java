package com.goods.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.goods.domain.Goods;
import com.goods.service.GoodsService;

/**
 * Servlet implementation class GoodsAddServlet
 */
@WebServlet("/GoodsAddServlet")
public class GoodsAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//先获取要插入的商品信息
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String image = request.getParameter("image");
		String cid = request.getParameter("cid");
		String gdesc = request.getParameter("gdesc");
		Goods goods = new Goods();
		goods.setName(name);
		goods.setPrice(Double.parseDouble(price));
		goods.setImage(image);
		goods.setCid(Integer.parseInt(cid));
		goods.setGdesc(gdesc);
		System.out.println(goods);
		//调用服务层
		GoodsService goodsService = new GoodsService();
		boolean flag = goodsService.addGoods(goods);
		if(flag) {
			//跳转到查询所有商品的页面
			request.getRequestDispatcher("/GoodsAllServlet").forward(request, response);
		}
		
			
	}

}
