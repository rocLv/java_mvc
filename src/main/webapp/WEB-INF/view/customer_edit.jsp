<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="BASE" value="${pageContext.request.contextPath}"/>

<html>
<head>
  <title>Customer manager</title>
</head>
<body>
<table>
<tr>
  <form action="customer_edit" method="POST">
     <label>Name</label>
     <input type="hidden" name="id" value="${customer.id}"></input>
     <input type="text" value="${customer.name}" name="name"></input>
     <input type="submit">Submit</input>
  </form>
  <td>${customer.contact}</td>
  <td>${customer.telephone}</td>
  <td>${customer.email}</td>
  <td>
     <a href="${BASE}/customer_edit?id=${customer.id}">Edit</a>
     <a href="${BASE}/customer_delete?id=${customer.id}">Delete</a>
  </td>
</tr>
</table>
</body>
</html>