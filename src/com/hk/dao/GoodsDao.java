package com.hk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hk.domain.Goods;
import com.hk.util.JdbcUtil;

/**
*@开发人员:占沪斌
*@创建时间:2018年8月22日下午3:59:24
*/
public class GoodsDao {

	public List<Goods> findAllGoods() {
		//1.连接数据库
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
		return allGoods;
		
	}

}
