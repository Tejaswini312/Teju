<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee</title>
</head>
<body>
<h1 style="color: crimson;">Employee Details</h1><br>
<table border="1" style="font-family: Arial, Helvetica, sans-serif;">
<tr>
<th>Employee Id</th>
<th>Employee Name</th>
<th>Employee Email</th>
<th>Employee DOB</th>
<th>Employee Salary</th>
<th>Employee Age</th>
<th>Employee Status</th>
<th>Edit</th>
<th>Delete</th>
</tr>
<x:forEach var="employee" items="${list}">
<tr>
<th>${employee.getId()}</th>
<th>${employee.getName()}</th>
<th>${employee.getEmail()}</th>
<th>${employee.getDob()}</th>
<th>${employee.getSalary()}</th>
<th>${employee.getAge()}</th>
<th>${employee.isStatus()}</th>
<th><a href="editEmployee?id=${employee.getId()}"><button>Edit</button></a></th>
<th><a href="deleteEmployee?id=${employee.getId()}"><button>Delete</button></a></th>
</tr>
</x:forEach>
</table>
<br>
<a href="loadEmployee"><button>Add Employee</button></a>
</body>
</html>