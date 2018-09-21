package com.hk.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hk.domain.Goods;
import com.hk.service.GoodsService;


/**
 * Servlet implementation class GoodsServlet
 */
@WebServlet("/GoodsServlet")
public class GoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*//1.连接数据库
		Connection conn = JdbcUtil.getConnection();
		//2.从数据库中获取数据
		String sql = "select * from goods";
		List<Goods> allGoods = new ArrayList<Goods>();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Goods goods = new Goods();
				goods.setId(rs.getInt("id"));
				goods.setName(rs.getString("name"));
				goods.setPrice(rs.getDouble("price"));
				goods.setImage(rs.getString("image"));
				allGoods.add(goods);
			}
			JdbcUtil.free(rs, pst, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//3.把从数据库中的数据存放到request域当中
		request.setAttribute("allGoods", allGoods);
		//4.转发到商品列表页面，转发时把request对象传入
		request.getRequestDispatcher("/goods_list.jsp").forward(request, response);
		*/
		GoodsService goodsService = new GoodsService();
		List<Goods> allGoods = goodsService.findAllGoods();
		request.setAttribute("allGoods", allGoods);
		//4.转发到商品列表页面，转发时把request对象传入
		request.getRequestDispatcher("/goods_list.jsp").forward(request, response);
	}

}
