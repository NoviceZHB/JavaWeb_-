package com.hk.domain;

import lombok.Getter;
import lombok.Setter;

/**
*@开发人员:占沪斌
*@创建时间:2018年8月21日下午6:54:28
*/
@Setter@Getter
public class Goods {
	private int id;
	private String name;
	private double price;
	private String image;
	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", price=" + price + ", image=" + image + "]";
	}
	
}
