package com.goods.dao;
/**
*@开发人员:占沪斌
*@创建时间:2018年8月23日下午7:36:47
*/

import java.util.List;

import com.goods.domain.Classify;

public interface ClassifyDao {
	public List<Classify> ClassifyAll();//查找所有分类
}
