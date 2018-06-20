<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>login.jsp</title>
</head>
<body><center>
	<form action="" method = post>
	<table border = "2">
	<tr>
		<td>ID:<input type = text name = "username"></td>
	</tr>
	<tr>
		<td>用户名:<input type = text name = "user"></td>
	</tr>
	
	<tr>
		<td>密码：<input type = password name = "password"></td>
	</tr>	
	<tr>
		<td><input type = submit value = "提交"></td>
	</tr>	
		
	</table>
	</form>
	</center>
	<%
		String username = request.getParameter("username");
		if(username==null) {
			username = "";
		}
		String user = request.getParameter("user");
		if(user==null) {
			user = "";
		}
		String password = request.getParameter("password");
		if(password == null) {
			password = "";
		}
		if(user.equals("")==false && password.equals("")==false){
			if(user.equals("root") && password.equals("123456")) {
				session.setAttribute("username", username);
				response.sendRedirect("index.jsp");
			}
			else {
				out.print("账号或密码错误");
			}
		}
	%>
	
</body>
</html>