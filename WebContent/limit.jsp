<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table id="table1" align="center" border="1" width="50%" cellpadding="6">
<tr>
	<th colspan="4" align="center"> 用户信息</th>
</tr>
<tr>
	<th>ID</th>
	<th>姓名</th>
	<th>操作</th>
</tr>
<c:forEach items="${list}" var="item">
<tr align="center">
	<td>${item.id}</td>
	<td>${item.name}</td>
	<td><a>修改</a> <a>删除</a></td>
</tr>
</c:forEach>
<tr>
<td colspan="4">
共有${allinfo.sumCount}条 &nbsp;&nbsp;
第${allinfo.currentPage}/${allinfo.sumPageCount}页 &nbsp;&nbsp;
<a href="ShowServlet?pageNo=${allinfo.firstPage}">首页</a>
<a href="ShowServlet?pageNo=${allinfo.upPage}">上一页</a>
<a href="ShowServlet?pageNo=${allinfo.downPage}">下一页</a>
<a href="ShowServlet?pageNo=${allinfo.lastPage}">尾页</a>
</td>
</tr>
</table>

</body>
</html>