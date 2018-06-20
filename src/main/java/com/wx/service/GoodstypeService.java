package com.wx.service;

import java.util.List;

import com.wx.entity.GoodsType;

public interface GoodstypeService {
	public int addGoodstype(GoodsType type);
	public List getAll();
	public int deleteGoodstype(int id);
	public int updateGoodstype(GoodsType goodstype);
}
