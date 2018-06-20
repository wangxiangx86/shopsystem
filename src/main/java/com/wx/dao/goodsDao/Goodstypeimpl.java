package com.wx.dao.goodsDao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.wx.dao.GoodstypeDao;
import com.wx.entity.Goods;
import com.wx.entity.GoodsType;

public class Goodstypeimpl extends MybatisDao implements GoodstypeDao{

	@Override
	public List<GoodsType> selectAll(SqlSession session) {
		List<GoodsType> typelist = super.selectList(session, "GoodstypeMapper.selectAll");
		return typelist;
	}

	@Override
	public int insertGoodstype(SqlSession session, GoodsType type) {
		int result = super.insert(session, "GoodstypeMapper.insertGoodstype", type);
		return result;
	}

	@Override
	public int deleteGoodstype(SqlSession session, int id) {
		int result = super.delete(session, "GoodstypeMapper.deleteGoodstype", id);
		return result;
	}

	@Override
	public int updateGoodstype(SqlSession session, GoodsType type) {
		int result = super.update(session, "GoodstypeMapper.updateGoodstype", type);
		return 0;
	}

	@Override
	public GoodsType selectOne(SqlSession session, String name) {
		GoodsType type  = (GoodsType)super.selectOne(session, "GoodstypeMapper.selectOne", name);
		return type;
	}
	
}
