package com.goods.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.goods.dao.ClassifyDao;
import com.goods.domain.Classify;
import com.goods.util.JdbcUtil;

/**
*@开发人员:占沪斌
*@创建时间:2018年8月23日下午7:37:49
*/
public class ClassifyDaoimp implements ClassifyDao{
	//连接数据库查找数据
	@Override
	public List<Classify> ClassifyAll() {
		Connection conn = JdbcUtil.getConnection();
		String sql = "select * from classify";
		List<Classify> classList = new ArrayList<Classify>();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Classify classify = new Classify();
				classify.setCid(rs.getInt("cid"));
				classify.setCname(rs.getString("cname"));
				classList.add(classify);		
			}
			System.out.println("------------分类查询成功-----------");
			JdbcUtil.free(rs, pst, conn);
		} catch (SQLException e) {
			System.out.println("分类查询操作数据库异常!!!");
			e.printStackTrace();
		}
		return classList;
	}

}
