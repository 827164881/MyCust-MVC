<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
</head>
<body>
	<form action="${pageContext.request.contextPath }/servlet/UploadServlet" method="post" enctype="multipart/form-data">
		请选择文件：<input type="file" name="file1"/><br>
		描述信息：<textarea rows="5" cols="45" name="description"></textarea><br>
		<input type="submit" value="上传">
	</form>
</body>
</html>