<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.sql.*"%>
<html>
<head>
<title>GoodsUpdate.jsp</title>
</head>
<body>
	<%String username = (String)session.getAttribute("username");
		if(username==null||username.length()==0){
			response.sendRedirect("login.jsp");
		}
	%>
	<%
		Connection con=null;
		Statement stmt;
		ResultSet rs;
					
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(Exception e){
			out.print(e);
		}
		try{
			String url="jdbc:mysql://localhost/shopdb?useSSL=false";
			String user="root";
			String password = "123456";
			con = DriverManager.getConnection(url,user,password);
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT goods.id,goods.goods_name,goodstype.typename,goods.goods_price,goods.goods_num FROM GoodsType,goods WHERE goodstype.typeid = goods.typeid");
			%>
			<table border ="2">
				<tr>
					<th>商品id</th>
					<th>商品名称</th>
					<th>商品类别</th>
					<th>商品价格</th>
					<th>库存数量</th>
					<th>操作</th>
				</tr>
			<%
			while(rs.next()){
				int i = rs.getInt(1);
				%>
				<tr>
					<td><%=i %></td>
					<td><%=rs.getString(2) %></td>
					<td><%=rs.getString(3) %></td>
					<td><%=rs.getDouble(4) %></td>
					<td><%=rs.getInt(5) %>
					<td><a href="updategood.jsp?id=<%=i%>">修改</a></td>
					<td><a href="goodstypeServlet?op=deleteGood&id=<%=i%>">删除</a></td>
				</tr>
				<%
			}%>
			</table>
			<%
		}
		catch(Exception e){
			out.print(e);
		}
		%>
</body>
</html>