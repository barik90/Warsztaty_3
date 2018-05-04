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
	<h1>Ostatnie rozwiązania</h1>
	<table border="1">
		<tr>
			<th scope="col">tytuł</th>
			<th scope="col">Nazwa</th>
			<th scope="col">Data dodania</th>
			<th scope="col">Details</th>
		</tr>
		<c:forEach items="${load5}" var="loaded">
			<tr>
				<td>${loaded.exerciseTitle}</td>
				<td>${loaded.username}</td>
				<td>${loaded.created}</td>
				<td><a href="details?id=${loaded.id}">Szczegóły</a></td>
			</tr>
		</c:forEach>
	</table>
	<%@	include file="/WEB-INF/views/main/footer.jsp"%>
</body>
</html>