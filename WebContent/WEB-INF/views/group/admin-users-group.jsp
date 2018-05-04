<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
	<%@	include file="/WEB-INF/views/main/header.jsp"%>
	<p>
		<a href='<c:url value="/users-group/add" />'>Dodaj grupę
			użytkowników</a>
	</p>
	<p>
		<a href='<c:url value="/users-group/edit" />'>Edytuj grupę
			użytkowników</a>
	</p>
	<h1>Lista grup użytkowników</h1>
	<table border="1">
		<tr>
			<th scope="col">ID</th>
			<th scope="col">Nazwa grupy</th>
			<th scope="col">Akcje</th>
		</tr>

		<c:forEach items="${groups}" var="group">
			<tr>
				<td>${group.id}</td>
				<td>${group.name}</td>
				<td><a href="users-group/delete?id=${group.id}">Usuń</a></td>
			</tr>
		</c:forEach>


	</table>
	<%@	include file="/WEB-INF/views/main/footer.jsp"%>
</body>
</html>