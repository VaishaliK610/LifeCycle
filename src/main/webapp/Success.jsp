<%@page import="java.util.List"%>
<%@page import="dto.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%Student student=(Student)request.getAttribute("student"); %>
<%List<Student> list=(List<Student>)request.getAttribute("list"); %>





<br>
<div style="background-color:yellow">
<table border="1">
<tr>
	<th>ID</th>
	<th>NAME</th>
	<th>MOBILE</th>
	<th>EMAIL</th>
	<th>GENDER</th>
	<th>PASSWORD</th>
	<th>EDIT</th>
	<th>DELETE</th>
	
</tr>
<tr>
	<th><%=student.getId() %></th>
	<th><%=student.getName() %></th>
	<th><%=student.getPhone() %></th>
	<th><%=student.getEmail() %></th>
	<th><%=student.getPassword() %></th>
	<th><%=student.getGender() %></th>
	<th><button>EDIT</button></th>
	<th><a href="delete?id=<%=student.getId() %>"><button>DELETE</button></a></th>
	
</tr>
</table>
</div>

</body>
</html>