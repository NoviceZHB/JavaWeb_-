package com.goods.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.goods.domain.Admin;
import com.hk.util.JdbcUtil;

/**
*@开发人员:占沪斌
*@创建时间:2018年8月22日下午5:01:41
*/
public class AdminDao {

	public Admin CheckAdmin(String uname, String pwd) throws SQLException{
		//1.连接数据库
		Connection conn = JdbcUtil.getConnection();
		String sql = "select * from admin where uname=? and pwd=?";
		PreparedStatement pst = conn.prepareStatement(sql) ;
		pst.setString(1, uname);
		pst.setString(2, pwd);
		ResultSet rs = pst.executeQuery();
		Admin admin = null;
		while(rs.next()) {
			admin = new Admin();
			if(rs.getString("uname").equals(uname) && rs.getString("pwd").equals(pwd)) {
				System.out.println("管理员账号与密码查询成功!!!");
				admin.setUname(rs.getString("uname"));
				admin.setPwd(rs.getString("pwd"));	
			}
		}
		if(admin == null) {
			System.out.println("管理员账号与密码查询失败!!!");	
		}
		JdbcUtil.free(rs, pst, conn);
		return admin;
		
		
	}

}
