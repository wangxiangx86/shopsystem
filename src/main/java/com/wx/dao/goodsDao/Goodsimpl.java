package com.wx.dao.goodsDao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;

import com.wx.dao.GoodsDao;
import com.wx.entity.Goods;
public class Goodsimpl extends MybatisDao implements GoodsDao{

	@Override
	public List<Goods> selectAll(SqlSession session) {
		List<Goods> goodslist = super.selectList(session, "GoodsMapper.selectAll");
		return goodslist;
	}

	@Override
	public int insertGoods(SqlSession session, Goods goods) {
		int result = super.insert(session, "GoodsMapper.insertGoods", goods);
		return result;
	}

	@Override
	public int deleteGoods(SqlSession session, int id) {
		int result = super.delete(session, "GoodsMapper.DeleteGoods", id);
		return result;
	}

	@Override
	public int updateGoods(SqlSession session, Goods goods) {
		int result = super.update(session, "GoodsMapper.UpdateGoods", goods);
		return 0;
	}

	@Override
	public Goods selectOne(SqlSession session, String name) {
		Goods goods = (Goods)super.selectOne(session, "GoodsMapper.SelectOne", name);
		return goods;
	}
	

	
	
}
