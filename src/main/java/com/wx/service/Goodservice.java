package com.wx.service;

import java.util.List;

import com.wx.entity.Goods;

public interface Goodservice {
	public int addGoods(Goods goods);
	public List getAll();
	public int deleteGoods(int id);
	public int updateGoods(Goods goods);
}
