package com.wx.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.wx.entity.Goods;

public interface GoodsDao {
	public List<Goods> selectAll(SqlSession session);
	public int insertGoods(SqlSession session,Goods goods);
	public int deleteGoods(SqlSession session,int id);
	public int updateGoods(SqlSession session,Goods goods);
	public Goods selectOne(SqlSession session,String name);
}
