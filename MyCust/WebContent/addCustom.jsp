<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<h1>用户管理_添加用户</h1><hr>
	<form action="${pageContext.request.contextPath }/servlet/addCustServlet" method="POST">
		<table border="1">
			<tr>
				<td>用户名</td>
				<td><input type="text" name="name"/></td>
			</tr>
			<tr>
				<td>性别</td>
				<td>
					<input type="radio" name="gender" value="男">男
					<input type="radio" name="gender" value="女">女
				</td>
			</tr>
			<tr>
				<td>出生年月</td>
				<td><input type="text" name="birthday"/></td>
			</tr>
			<tr>
				<td>电话号码</td>
				<td><input type="text" name="cellphone"/></td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td><input type="text" name="email"/></td>
			</tr>
			<tr>
				<td>爱好</td>
				<td>
					<input type="checkbox" name="preference" value="篮球">篮球
					<input type="checkbox" name="preference" value="足球">足球
					<input type="checkbox" name="preference" value="乒乓球">乒乓球
					<input type="checkbox" name="preference" value="羽毛球">羽毛球
				</td>
			</tr>
			<tr>
				<td>用户类型</td>
				<td>
					<select name="type">
						<option value="类型1">类型1</option>
						<option value="类型2">类型2</option>
						<option value="类型3">类型3</option>
						<option value="类型4">类型4</option>
					</select>
				</td>
			</tr>
			 <tr>
				<td>描述</td>
				<td><textarea name="description" rows="7" cols="40" ></textarea></td>
			</tr> 
			
			<tr>
				<td colspan="2"><input type="submit" value="提交"/></td>
			</tr>
		
		
		
		
		</table>
	
	</form>
</div>
</body>
</html>