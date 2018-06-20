package com.wx.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;


import com.wx.dao.GoodsDao;
import com.wx.dao.goodsDao.Goodsimpl;
import com.wx.dao.goodsDao.MybatisUtis;
import com.wx.entity.Goods;
import com.wx.service.Goodservice;
public class Goodsserviceimpl implements Goodservice{
	public GoodsDao dao = new Goodsimpl();
	public GoodsDao getDao() {
		return dao;
	}

	public void setDao(GoodsDao dao) {
		this.dao = dao;
	}

	@Override
	public int addGoods(Goods goods) {
		int result = 0;
		SqlSession session = MybatisUtis.createSqlsessin();
		try {
			result = dao.insertGoods(session, goods);
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
	public List<Goods> getAll() {
		List<Goods> result = null;
		SqlSession session = MybatisUtis.createSqlsessin();
		try {
			result = dao.selectAll(session);
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
	public int deleteGoods(int id) {
		int result = 0;
		SqlSession session = MybatisUtis.createSqlsessin();
		try {
			result = dao.deleteGoods(session, id);
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
	public int updateGoods(Goods goods) {
		int result = 0;
		SqlSession session = MybatisUtis.createSqlsessin();
		try {
			result = dao.updateGoods(session, goods);
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
