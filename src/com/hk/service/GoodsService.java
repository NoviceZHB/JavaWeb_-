package com.hk.service;

import java.util.List;

import com.hk.dao.GoodsDao;
import com.hk.domain.Goods;

/**
*@开发人员:占沪斌
*@创建时间:2018年8月22日下午3:59:39
*/
public class GoodsService {

	public List<Goods> findAllGoods() {
		GoodsDao goodsDao = new GoodsDao();
		return goodsDao.findAllGoods();
		
	}

}
