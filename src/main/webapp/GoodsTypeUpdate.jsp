<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<center>
	<head>
<title>GoodsTypeUpdate.jsp</title>
	</head>
	<body>
		<%!
		Connection con = null;
		Statement stmt;
		ResultSet rs;
		%>
		<%String username = (String)session.getAttribute("username");
		if(username==null||username.length()==0){
			response.sendRedirect("login.jsp");
		}
	%>
	<%			
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
			rs = stmt.executeQuery("SELECT * from goodstype");
			%>
			<table border ="2">
				<tr>
					<th>商品类别id</th>
					<th>商品类别名称</th>
					<th>操作</th>
				</tr>
			<%
			while(rs.next()){
				int i = rs.getInt(1);
				%>
				<tr>
					<td><%=i %></td>
					<td><%=rs.getString(2) %></td>
					<td><a href="updategoodtype.jsp?id=<%=i%>">修改</a></td>
					<td><a href="goodstypeServlet?op=deleteGoodtype&id=<%=i%>">删除</a></td>
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
</center>
</html>