<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
</head>
<body>
	<body>
<div align="center">
	<h1>用户管理_修改用户</h1><hr>
	<form action="${pageContext.request.contextPath }/servlet/UpdateCustServlet" method="POST">
		<input type="hidden" name="id" value="${cust.id }"/>
		<table border="1">
			<tr>
				<td>用户名</td>
				<td><input type="text" name="name" value="${cust.name }" readonly="readonly" style="background: silver;"/></td>
			</tr>
			<tr>
				<td>性别</td>
				<td>
					<input type="radio" name="gender" value="男"  
						<c:if test="${cust.gender=='男' }">checked="checked"</c:if>
					>男
					<input type="radio" name="gender" value="女"
						<c:if test="${cust.gender=='女' }">checked="checked"</c:if>
					>女
				</td>
			</tr>
			<tr>
				<td>出生年月</td>
				<td><input type="text" name="birthday" value="${cust.birthday }"/></td>
			</tr>
			<tr>
				<td>电话号码</td>
				<td><input type="text" name="cellphone" value="${cust.cellphone }"/></td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td><input type="text" name="email" value="${cust.email }"/></td>
			</tr>
			<tr>
				<td>爱好</td>
				<td>
					<input type="checkbox" name="preference" value="篮球" 
						<c:if test="${fn:contains(cust.preference,'篮球') }">checked="checked"</c:if>
					>篮球
					<input type="checkbox" name="preference" value="足球"
						<c:forTokens items="${cust.preference }" delims="," var="pref">
							<c:if test="${pref=='足球' }">
								checked="checked"
							</c:if>
						</c:forTokens>
					>足球
					<input type="checkbox" name="preference" value="乒乓球"
						<c:if test="${fn:contains(cust.preference,'乒乓球') }">checked="checked"</c:if>
					>乒乓球
					<input type="checkbox" name="preference" value="羽毛球"
						<c:if test="${fn:contains(cust.preference,'羽毛球') }">checked="checked"</c:if>
					>羽毛球
				</td>
			</tr>
			<tr>
				<td>用户类型${cust.type }</td>
				<td>
					<select name="type">
						<option value="类型1" 
							<c:if test="${cust.type=='类型1' }">selected="selected"</c:if>
						>类型1</option>
						<option value="类型2"
						<c:if test="${cust.type=='类型2' }">selected="selected"</c:if>
						>类型2</option>
						<option value="类型3"
							<c:if test="${cust.type=='类型3' }">selected="selected"</c:if>
						>类型3</option>
						<option value="类型4"
							<c:if test="${cust.type=='类型4' }">selected="selected"</c:if>
						>类型4</option>
					</select>
				</td>
			</tr>
			 <tr>
				<td>描述</td>
				<td><textarea name="description" rows="7" cols="40" >${cust.description }</textarea></td>
			</tr> 
			
			<tr>
				<td colspan="2"><input type="submit" value="提交"/></td>
			</tr>
		
		
		
		
		</table>
	
	</form>
</div>
</body>
</body>
</html>