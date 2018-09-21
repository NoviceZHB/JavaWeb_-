package com.goods.dao;
/**
*@开发人员:占沪斌
*@创建时间:2018年8月23日上午10:38:07
*/

import java.util.List;

import com.goods.domain.Goods;


public interface GoodsDao {
	public List<Goods> findAll();//查询所有商品信息
	public boolean delete(int id);//通过id删除商品
	public boolean update(int id,String name,double price,String image,int cid,String gdesc);//通过id修改商品
	public boolean addGoods(Goods goods);//增加商品
	public Goods select(int id);//根据ID查询商品
}
