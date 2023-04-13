<%@page import="com.StudentDataManagement.dto.Teacher"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teacher Details</title>
</head>
<body>
	<% List<Teacher> list=(List)session.getAttribute("list"); %>
	<table border="1">
		<tr> 
			<th> Id<br/> </th>
			<th> Name<br/> </th>
			<th> Email<br/> </th>
			<th> Contact<br/> </th>
			<th> Subject<br/> </th>
			<th> ClassTeacher<br/> </th>
			<th> Salary<br/> </th>
			<th> Address<br/> </th>
			<th> Password<br/> </th>
		</tr>
		<%for(Teacher c:list) {%>
		<tr> 
			<td> <%=c.getId() %><br/> </td>
			<td> <%=c.getName() %><br/> </td>
			<td> <%=c.getEmail() %><br/> </td>
			<td> <%=c.getContact() %><br/> </td>
			<td> <%=c.getSubject() %><br/> </td>
			<td> <%=c.getClassTeacher() %><br/> </td>
			<td> <%=c.getSalary() %><br/> </td>
			<td> <%=c.getAddress() %><br/> </td>
			<td> <%=c.getPassword() %><br/> </td>
			<td> <a href="http://localhost:8080/FullProject/EditTeacher.html"><input type="button" value="EDIT"></a><br/> </td>
		</tr>
		<%} %>
		
	</table>
</body>
</html>