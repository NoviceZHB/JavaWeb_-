package com.goods.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.goods.service.GoodsService;

/**
 * Servlet implementation class GoodsUpServlet
 */
@WebServlet("/GoodsUpServlet")
public class GoodsUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//获取修改页面的数据
		String id = request.getParameter("id");
		System.out.println(id);
		int gid = Integer.parseInt(id);
		String name = request.getParameter("name");
		System.out.println(name);
		String price = request.getParameter("price");
		System.out.println(price);
		double gprice = Double.parseDouble(price);
		String image = request.getParameter("image");
		System.out.println(image);
		String cid = request.getParameter("cid");
		System.out.println(cid);
		int gcid = Integer.parseInt(cid);
		String gdesc = request.getParameter("gdesc");
		System.out.println(gdesc);
		GoodsService goodsService = new GoodsService();
		boolean flag = goodsService.update(gid, name, gprice, image, gcid, gdesc);
		System.out.println(flag);
		if(flag) {
			request.getRequestDispatcher("/GoodsAllServlet").forward(request, response);
		}
		
	}

}
