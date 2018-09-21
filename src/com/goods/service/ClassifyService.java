package com.goods.service;
/**
*@开发人员:占沪斌
*@创建时间:2018年8月23日下午7:42:40
*/

import java.util.List;

import com.goods.dao.ClassifyDao;
import com.goods.domain.Classify;
import com.goods.imp.ClassifyDaoimp;

public class ClassifyService {
	public List<Classify> ClassifyAll(){
		ClassifyDao classifyDao = new ClassifyDaoimp();
		List<Classify> classList = classifyDao.ClassifyAll();
		return classList;
		
	}
}	
