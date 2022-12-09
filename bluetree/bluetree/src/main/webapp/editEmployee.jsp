<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="x" uri="http://www.springframework.org/tags/form" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Employee</title>
</head>
<body>
<h1 style="text-decoration: solid;">Hello Employee Enter Your Details Below To Edit</h1><br>

<x:form action="updateEmployee" modelAttribute="employee" style="background-color: cornsilk;">
Id:<x:input path="id" readonly='true'/><br>
Name:<x:input path="name"/><br>
Email:<x:input type="email" path="email"/><br>
DOB:<x:input type="date" path="dob"/><br>
Salary:<x:input path="salary"/><br>
Change Status:<x:checkbox path="status"/><br>
<button>Update</button>
<button type="reset">Cancel</button>
</x:form>
</body>
</html>