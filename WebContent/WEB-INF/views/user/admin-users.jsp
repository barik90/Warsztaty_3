<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Programming School</title>
</head>
<body>
	<%@	include file="/WEB-INF/views/main/header.jsp"%>
	<p>
		<a href='<c:url value="/user/add" />'>Dodaj użytkownika</a>
	</p>
	<p>
		<a href='<c:url value="/user/edit" />'>Edytuj użytkownika</a>
	</p>
	<h1>Lista użytkowników</h1>
	<table border="1">
		<tr>
			<th scope="col">ID</th>
			<th scope="col">Nazwa</th>
			<th scope="col">Email</th>
			<th scope="col">Akcja</th>
		</tr>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.id}</td>
				<td>${user.username}</td>
				<td>${user.email}</td>
				<td><a href="user/delete?id=${user.id}">Usuń</a></td>
			</tr>
		</c:forEach>
	</table>
	<%@	include file="/WEB-INF/views/main/footer.jsp"%>
</body>
</html>