package com.goods.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.goods.dao.GoodsDao;
import com.goods.domain.Goods;
import com.goods.util.JdbcUtil;


/**
*@开发人员:占沪斌
*@创建时间:2018年8月23日上午10:50:13
*/
public class GoodsDaoimp implements GoodsDao{
	
	//查询所有商品信息
	@Override
	public List<Goods> findAll() {
		//1.连接数据库
		Connection conn = JdbcUtil.getConnection();
		String sql = "select * from goods";
		List<Goods> goodsList = new ArrayList<Goods>();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Goods goods = new Goods();
				goods.setId(rs.getInt("id"));
				goods.setName(rs.getString("name"));
				goods.setPrice(rs.getDouble("price"));
				goods.setImage(rs.getString("image"));
				goodsList.add(goods);		
			}
			JdbcUtil.free(rs, pst, conn);
		} catch (SQLException e) {
			System.out.println("连接数据库异常！！！");
			e.printStackTrace();
		}
		return goodsList;
	}
	
	//根据商品ID删除商品
	@Override
	public boolean delete(int id) {
		boolean flag = false;
		//1.连接数据库
		Connection conn = JdbcUtil.getConnection();
		String sql = "delete from goods where id=?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			 int i = pst.executeUpdate();
			 if(i > 0) {
				 flag = true;
			 }else {
				flag = false;
			}
			 JdbcUtil.free(null, pst, conn);
		} catch (SQLException e) {
			System.out.println("连接数据库异常！！！");
			e.printStackTrace();
		}
		
		return flag;
	}
	//根据ID修改商品
	@Override
	public boolean update(int id,String name,double price,String image,int cid,String gdesc) {
		//1.连接数据库
		Connection conn = JdbcUtil.getConnection();
		String sql = "update goods set name=?,price=?,image=?,cid=?,gdesc=? where id=?";
		boolean flag = false;
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			pst.setDouble(2, price);
			pst.setString(3, image);
			pst.setInt(4, cid);
			pst.setString(5, gdesc);
			pst.setInt(6, id);
			int i = pst.executeUpdate();
			while(i > 0) {
				System.out.println("ID为:"+id+"的商品修改成功");
				flag = true;
			}
			
		} catch (SQLException e) {
			System.out.println("ID为:"+id+"的商品修改失败");
			e.printStackTrace();
		}
		
		return flag;
	}
	
	//添加商品
	@Override
	public boolean addGoods(Goods goods) {
		//增加商品信息
		//1.连接数据库
		Connection conn = JdbcUtil.getConnection();
		String sql = "insert into goods(name,price,image,cid,gdesc) values(?,?,?,?,?)";
		boolean flag = false;
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, goods.getName());
			pst.setDouble(2, goods.getPrice());
			pst.setString(3, goods.getImage());
			pst.setInt(4, goods.getCid());
			pst.setString(5, goods.getGdesc());
			int i = pst.executeUpdate();
			while(i > 0) {
				System.out.println("------商品插入成功--------");
				flag = true;
			}
			JdbcUtil.free(null, pst, conn);
		} catch (SQLException e) {
			System.out.println("--------商品插入失败----------");
			e.printStackTrace();
		}
		return flag;
		
	}
	
	//根据ID查询商品
	@Override
	public Goods select(int id) {
		Connection conn = JdbcUtil.getConnection();
		String sql = "select id,name,price,image,cid,gdesc from goods where id=?";
		Goods goods = new Goods();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				System.out.println("ID为:"+id+"的商品查询成功");
				goods.setId(rs.getInt("id"));
				goods.setName(rs.getString("name"));
				goods.setPrice(rs.getDouble("price"));
				goods.setImage(rs.getString("image"));
				goods.setCid(rs.getInt("cid"));
				goods.setGdesc(rs.getString("gdesc"));	
			}
			JdbcUtil.free(rs, pst, conn);
		} catch (SQLException e) {
			System.out.println("ID为:1"+id+"的商品查询失败");
			e.printStackTrace();
		}
		return goods;
	}


}
