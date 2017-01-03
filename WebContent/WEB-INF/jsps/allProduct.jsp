<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>

<link rel="stylesheet" href="<c:url value="/css/styles.css" />">
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
</head>
<body>
	<h1> Shirin's Collections</h1>
	
	<table>
		<tr>
			<th>Description</th>
			<th>Price</th>
			<th>Image</th>
			<th>Style</th>
			<th></th>
			<th></th>
		</tr>
			<c:forEach var="product" items="${products}">
				<tr>
					<td>
						<c:out value="${product.description}"/>
					</td>
					<td>
						<c:out value ="${product.price}"/>
					</td>
					<td>
						<c:out value="${product.image}"/>
					</td>
					<td>
						<c:out value="${product.style}"/>
					</td>
					<td>
						<a href="<c:url value="/edit/${product.id}" />">Edit</a>
					</td>
					<td>
						<a href="<c:url value="/delete/${product.id}" />">Delete</a>
					</td>
					
				</tr>
			</c:forEach>
		</table>
</body>
</html>