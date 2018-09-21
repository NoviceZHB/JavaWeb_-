package com.goods.service;

import com.goods.dao.AdminDao;
import com.goods.domain.Admin;

/**
*@开发人员:占沪斌
*@创建时间:2018年8月22日下午5:01:24
*/
public class AdminService{

	public Admin login(String uname, String pwd) throws Exception {
		//调用dao层到数据库中查询
		AdminDao adminDao = new AdminDao();
		Admin admin = adminDao.CheckAdmin(uname, pwd);
		if(admin != null) {
			return admin;
		}else {
			throw new Exception("用户名或密码错误");
		}
		
	}

}
