<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product Management Screen</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
      <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link> 
</head>
<body>
    <div align="center" >
        <h1>Product List</h1>
        <h3>
            <a href="newProduct">New Product</a>
        </h3>
        <table border="1"  class="blueTable">
 
            <th>Name</th>
            <th>Date of Purchase</th>
            <th>Description</th>
            <th>Available or not</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Actions</th>
           
            <c:forEach var="product" items="${listProduct}">
                <tr align="center" >
 
                    <td>${product.name}</td>
                    <td>${product.dateOfPurchase}</td>
                    <td>${product.description}</td>
                    <td>${product.available}</td>
                    <td>${product.price}</td>
                    <td>${product.quantity}</td>
                    <td><a href="editProduct?id=${product.id}">Edit</a> 
                             <a href="deleteProduct?id=${product.id}">Delete</a></td>
 
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>