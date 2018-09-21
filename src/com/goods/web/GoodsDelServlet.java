package com.goods.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.goods.service.GoodsService;

/**
 * Servlet implementation class GoodsDelServlet
 */
@WebServlet("/GoodsDelServlet")
public class GoodsDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		GoodsService goodsService = new GoodsService();
		boolean flag = goodsService.delete(Integer.parseInt(id));
		if(flag) {
			System.out.println("ID为:"+id+"的商品已被删除");
			//跳转到打印所有的GoodsAllServlet中再显示所有商品
			request.getRequestDispatcher("/GoodsAllServlet").forward(request, response);
		}	
		
	}

}
