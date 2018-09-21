package com.goods.service;

import java.util.List;

import com.goods.dao.GoodsDao;
import com.goods.domain.Goods;
import com.goods.imp.GoodsDaoimp;

/**
*@开发人员:占沪斌
*@创建时间:2018年8月23日上午11:13:11
*/
public class GoodsService {
	//打印所有商品
	public List<Goods> findAll(){
		GoodsDao goodsDao = new GoodsDaoimp();
		List<Goods> goodsAll = goodsDao.findAll();
		return goodsAll;
	}
	//根据ID删除商品
	public boolean delete(int id) {
		boolean flag = false;
		GoodsDao goodsDao = new GoodsDaoimp();
		flag = goodsDao.delete(id);
		return flag;
		
	}
	//添加商品
	public boolean addGoods(Goods goods) {
			GoodsDao goodsDao = new GoodsDaoimp();
			boolean flag = goodsDao.addGoods(goods);
			return flag;
		
	}
	//根据ID修改商品
	public boolean update(int id,String name,double price,String image,int cid,String gdesc) {
		GoodsDao goodsDao = new GoodsDaoimp();
		boolean flag = goodsDao.update(id, name, price, image, cid, gdesc);
		return flag;
		
	}
	//根据ID查询商品
		public Goods select(int id) {
			GoodsDao goodsDao = new GoodsDaoimp();
			Goods goods = goodsDao.select(id);
			return goods;
			
		}
	
	
}
