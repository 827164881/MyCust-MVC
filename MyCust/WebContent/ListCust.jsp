<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<html>
<head>
	<script type="text/javascript">
		function checkAll(allC){
			var otherCs=document.getElementsByName("delId");
			for(var i=0;i<otherCs.length;i++){
				otherCs[i].checked=allC.checked;
			}
			
		}
	</script>
</head>
<body>
	<h1>用户管理——查询所有用户</h1><hr>
	<form action="${pageContext.request.contextPath }/servlet/DetailSearch" method="POST">
		用户姓名：<input type="text" name="name" value="${param.name }"/>
		性别：<input type="radio" name="gender" value="男">男
					<input type="radio" name="gender" value="女">女
		用户类型：<select name="type">
						<option value=""></option>
						<option value="类型1">类型1</option>
						<option value="类型2">类型2</option>
						<option value="类型3">类型3</option>
						<option value="类型4">类型4</option>
					</select>
		<input type="submit" value="条件查询">
	</form>
<form action="${pageContext.request.contextPath }/servlet/BatchDelServlet" method="POST">
	<table align="center" border="1" width="100%">
		<tr>
			<th><input type="checkbox" name="delAll" onclick="checkAll(this)"/>全选</th>
			<th>用户姓名</th>
			<th>用户性别</th>
			<th>出生日期</th>
			<th>联系电话</th>
			<th>电子邮箱</th>
			<th>兴趣爱好</th>
			<th>描述信息</th>
			<th>修改信息</th>
			<th>删除用户</th>
		</tr>
		<c:forEach items="${requestScope.list }" var="cust">
			<tr>
				<td><input type="checkbox" name="delId" value="${cust.id }"/></td>
				<td><c:out value="${cust.name }"/></td>
				<td><c:out value="${cust.gender }"/></td>
				<td><c:out value="${cust.birthday }"/></td>
				<td><c:out value="${cust.cellphone }"/></td>
				<td><c:out value="${cust.email }"/></td>
				<td><c:out value="${cust.preference }"/></td>
				<td><c:out value="${cust.description }"/></td>
				<td><a href="${pageContext.request.contextPath }/servlet/CustInfoServlet?id=${cust.id }">修改</a></td>
				<td><a href="${pageContext.request.contextPath }/servlet/DelCustServlet?id=${cust.id }">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	<input type="submit" name="submit" value="批量删除" style="text-align: center;"/>
	</form>
</body>
