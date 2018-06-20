package com.wx.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;


import com.wx.dao.GoodstypeDao;
import com.wx.dao.goodsDao.Goodstypeimpl;
import com.wx.dao.goodsDao.MybatisUtis;
import com.wx.entity.Goods;
import com.wx.entity.GoodsType;
import com.wx.service.GoodstypeService;

public class Goodstypeserviceimpl implements GoodstypeService{
	public GoodstypeDao typedao = new Goodstypeimpl();
	public GoodstypeDao getTypedao() {
		return typedao;
	}

	public void setTypedao(GoodstypeDao typedao) {
		this.typedao = typedao;
	}

	@Override
	public List getAll() {
		List<GoodsType> result = null;
		SqlSession session = MybatisUtis.createSqlsessin();
		try {
			result = typedao.selectAll(session);
			session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		return result;
	}

	@Override
	public int deleteGoodstype(int id) {
		int result = 0;
		SqlSession session = MybatisUtis.createSqlsessin();
		try {
			result = typedao.deleteGoodstype(session, id);
			session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		return result;
	}

	@Override
	public int updateGoodstype(GoodsType goodstype) {
		int result = 0;
		SqlSession session = MybatisUtis.createSqlsessin();
		try {
			result = typedao.updateGoodstype(session, goodstype);
			session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		return result;
	}

	@Override
	public int addGoodstype(GoodsType type) {
		int result = 0;
		SqlSession session = MybatisUtis.createSqlsessin();
		try {
			result = typedao.insertGoodstype(session, type);
			session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		return result;
	}

}
