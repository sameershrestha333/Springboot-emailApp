<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Display Locations</title>
</head>
<body>

<h2>Locations:</h2>
      <table>
        <tr>
            <th>Id</th>
            <th>Code</th>
            <th>Name</th>
            <th>Type</th>
        </tr>
        <tr>
            <c:forEach items="${locations}" var="location">
            <tr>
                <td>${location.id}</td>
                <td>${location.code}</td>
                <td>${location.name}</td>
                <td>${location.type}</td>
                <td><a href="deleteLocation?id=${location.id}">Delete</a> </td>
                <td><a href="showUpdate?id=${location.id}">Edit</a> </td>
            </tr>

            </c:forEach>
        </tr>

      </table>

<a href="showCreate">Add Location</>
</body>
</html>