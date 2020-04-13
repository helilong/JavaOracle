<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<body>
		<table border="1" width="60%" cellspacing="0" align="center">
			<caption>用户信息</caption>
			<tr>
				<th>编号</th>
				<th>用户名</th>
				<th>操作</th>
			</tr>
	<c:forEach items="${list}" var="items">
		<tr>
		<td>${items.id}</td>
		<td>${items.name}</td>
		<td> <a href="">删除</a> <a href="">修改</a> </td>
		</tr>	
	</c:forEach>
	<tr>
		<td><a href="userinfoServlet?op=toadd">添加</a></td>
	</tr>
		</table>
	</body>
</html>