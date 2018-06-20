package com.wx.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import com.wx.entity.GoodsType;

public interface GoodstypeDao {
	public List<GoodsType> selectAll(SqlSession session);
	public int insertGoodstype(SqlSession session,GoodsType type);
	public int deleteGoodstype(SqlSession session,int id);
	public int updateGoodstype(SqlSession session,GoodsType type);
	public GoodsType selectOne(SqlSession session,String name);
}
