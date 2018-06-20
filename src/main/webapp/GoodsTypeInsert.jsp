<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GoodsTypeInsert.jsp</title>
</head>
<body>
	<%
			String username = (String) session.getAttribute("username");
			if (username == null || username.length() == 0) {
				response.sendRedirect("login.jsp");
			}
		%>
		<form action="goodstypeServlet?op=insertgoodtype" method = post>
			<table border="2">
				<tr>
					<th>添加商品类别</th>
				</tr>
				<tr>
					<td>商品类别：<input type = "text" name = "typename"></td>
					<td><input type = "submit" name = "submit" value = "提交"></td>
				</tr>
			</table>
		</form>
</body>
</html>