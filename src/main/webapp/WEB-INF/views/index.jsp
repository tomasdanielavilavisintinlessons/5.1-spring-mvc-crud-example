<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Customer Manager</h1>
		<form method="get" action="customer/search">
			<input type="text" name="keyword" /> 
			<input type="submit"
				value="Search" />
		</form>
		<h3><a href="customer/new">New Customer</a></h3>
		<table border="1" >
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>E-Mail</th>
					<th>Address</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${customers}" var="customer">
					<tr>
						<td>${customer.id}</td>
						<td>${customer.name}</td>
						<td>${customer.email}</td>
						<td>${customer.address}</td>
						<td>
							<a href="customer/edit/${customer.id}">Edit</a>
							<a href="customer/delete?id=${customer.id}">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>