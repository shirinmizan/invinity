<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add product</title>

<link rel="stylesheet" href="<c:url value="/css/styles.css" />">
<script src="<c:url value="/scripts/script.js" />"></script>

</head>
<body>
	<c:url var="url" value="/addProduct"/>
	<div class="form-style-5">
		<form:form commandName="product" action="${url}" method="post">
		<fieldset>
			<legend><span class="number"></span>Add a New Collection</legend>		
			<form:input path="description" placeholder="Description *"/></td>
			<form:input path="price" placeholder="Price *"/></td>
			
			<label for="style">Styles</label>
			<form:select path="style" items="${product.styles}" id="style" name="field4"/><br>
			
			<input type="file" name="file" id="file"><br><br>
			
		</fieldset>
			<input type="submit" value="Add Product"/>
		</form:form>
		
		<c:url value="/allProduct" var="url" />
		<a href="${url}">Full Collections</a>
		
		
	</div>
</body>
</html>