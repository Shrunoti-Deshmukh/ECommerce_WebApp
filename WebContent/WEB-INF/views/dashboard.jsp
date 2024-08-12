<%@page import="com.wu.ecommerce.dto.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.wu.ecommerce.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
<h1>DashBoard</h1>

<%
User user = (User) session.getAttribute("user");
out.print(user);

List<Product> productList = (List<Product>)application.getAttribute("productList");
out.print(productList);
%>


<h1>Welcome</h1>

<h2><a href = "LogOutServlet">LogOut</a></h2>
</body>
</html>