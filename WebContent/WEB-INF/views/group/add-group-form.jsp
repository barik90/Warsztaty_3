<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/main/header.jsp"%>
	<p>Dodaj nową grupę</p>
	<form action="#" method="post">
		<p>
			Nazwa grupy: <input type="text" name="username">
		</p>
		<p>
			<input type="submit">
		</p>
	</form>
	<%@	include file="/WEB-INF/views/main/footer.jsp"%>
</body>
</html>