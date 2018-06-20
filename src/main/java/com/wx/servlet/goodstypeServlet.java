package com.wx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.wx.entity.Goods;
import com.wx.entity.GoodsType;
import com.wx.service.Goodservice;
import com.wx.service.GoodstypeService;
import com.wx.service.impl.Goodsserviceimpl;
import com.wx.service.impl.Goodstypeserviceimpl;


/**
 * Servlet implementation class goodstypeServlet
 */
public class goodstypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Goodservice goodservice = new Goodsserviceimpl();
	private GoodstypeService typeservice = new Goodstypeserviceimpl();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public goodstypeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String op = request.getParameter("op");
	
		if(op.equals("insertgoodtype")) {
			String typename = request.getParameter("typename");
			if(typename.equals("")==false && typename.length()!=0) {
				GoodsType type = new GoodsType();
				type.setTypename(typename);
				int result = typeservice.addGoodstype(type);
			}
			response.sendRedirect("GoodsTypeUpdate.jsp");
		}else if(op.equals("deleteGoodtype")) {
			int id = Integer.parseInt(request.getParameter("id"));
			int result = typeservice.deleteGoodstype(id);
			response.sendRedirect("GoodsTypeUpdate.jsp");
		}else if(op.equals("updateGoodtype")) {
			int id = Integer.parseInt(request.getParameter("id"));
			String typename = request.getParameter("typename");
			GoodsType type = new GoodsType();
			type.setTypename(typename);
			type.setTypeid(id);
			int result = typeservice.updateGoodstype(type);
			response.sendRedirect("GoodsTypeUpdate.jsp");
		}else if(op.equals("goodinsert")) {
			String goodname = request.getParameter("goodname");
			int id = Integer.parseInt(request.getParameter("id"));
			double price = Double.parseDouble(request.getParameter("price"));
			int num = Integer.parseInt(request.getParameter("num"));
			Goods goods = new Goods();
			goods.setGoods_name(goodname);
			goods.setGoods_num(num);
			goods.setTypeid(id);
			int result = goodservice.addGoods(goods);
			response.sendRedirect("GoodsInsert.jsp");
		}else if(op.equals("deleteGood")) {
			int id = Integer.parseInt(request.getParameter("id"));
			int result = goodservice.deleteGoods(id);
			response.sendRedirect("GoodsUpdate.jsp");
		}else if(op.equals("updateGood")) {
			int id = Integer.parseInt(request.getParameter("id"));
			String goodname = request.getParameter("goodname");
			int typeid = Integer.parseInt(request.getParameter("typeid"));
			double price = Double.parseDouble(request.getParameter("price"));
			int num = Integer.parseInt(request.getParameter("num"));
			Goods goods = new Goods();
			goods.setId(id);
			goods.setGoods_name(goodname);
			goods.setGoods_num(num);
			goods.setTypeid(id);
			int result = goodservice.updateGoods(goods);
			response.sendRedirect("GoodsUpdate.jsp");
		}
	}
}
