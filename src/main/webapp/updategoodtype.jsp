<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>updategoodtype.jsp</title>
</head>
<body>
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
			int id = Integer.parseInt(request.getParameter("id"));
			rs = stmt.executeQuery("SELECT * FROM GoodsType WHERE typeid = "+id);
			%>					
			<form action="goodstypeServlet?op=updateGoodtype&id=<%=id%>" method = post>
			<table border ="2">
				<tr>
					<th>商品类别id</th>
					<th>商品类别名称</th>
					<th>操作</th>
				</tr>
			<%
			while(rs.next()){
				int i =rs.getInt(1);
				%>
				<tr>
					<td><%=i %></td>
					<td><input type = text name = "typename" value = <%=rs.getString(2) %> ></td>
					<td><input type = submit name = "submmit" value = "确认"></td>
				</tr>
				<%
			}%>
			</table>
			</form>
			<%
		}
		catch(Exception e){
			out.print(e);
		}
		%>
</body>
</html>