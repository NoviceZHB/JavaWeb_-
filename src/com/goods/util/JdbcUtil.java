package com.goods.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
*@开发人员:占沪斌
*@创建时间:2018年8月16日下午4:59:44
*/
public class JdbcUtil {
	static Connection conn=null;
	static Statement stat=null;
	static ResultSet rs=null;
	static Properties pro = null;
	static {
		//1.创建Properties集合
			pro = new Properties();
		try {
			//2.创建输入流的对象
			String path = JdbcUtil.class.getClassLoader().getResource("db.properties").getPath();
			InputStream in = new FileInputStream(path);
			//3.把输入流中的数据加载到Properties集合中
			pro.load(in);
			//4.创建并注册驱动对象：Driver，通过getProperty()方法获取配置文件中的数据
			Class.forName(pro.getProperty("driver"));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//5.获取连接对象：Connection，通过getProperty()方法获取配置文件中的数据
	public static Connection getConnection() {
		try {
			 conn = DriverManager.getConnection(pro.getProperty("url"), pro.getProperty("username"), pro.getProperty("password"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
		
	}
	//6.关闭资源 ：ResultSet->Statement->Connection
	public static void free(ResultSet rs,PreparedStatement pst,Connection conn) {
		try {
			if(rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(pst != null) {
					pst.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(conn != null) {
						conn.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
