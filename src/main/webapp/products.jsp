<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<h2>Products</h2>
   <table>
       <tr>
           <th>ID</th>
           <th>Title</th>
           <th>Price</th>
       </tr>
       <c:forEach items="${products}" var="product">
           <tr>
               <td>${product.getId()}</td>
               <td>${product.getTitle()}</td>
               <td>${product.getCost()}</td>
           </tr>
       </c:forEach>
   </table>
</body>
</html>
