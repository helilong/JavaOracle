<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<body>
	<form action="userinfoServlet?op=add" method="post">
	编号:<input type="text" name="id" id="id" value="" /><br /><br />
	用户名：<input type="text" name="name" id="name" value="" /><br /><br />
		<input type="submit" value="添加"/>
	</form>
	</body>
</html>
