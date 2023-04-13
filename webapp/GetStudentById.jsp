<%@page import="com.StudentDataManagement.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get Student By ID</title>
</head>
<body>
	<% Student c=(Student)session.getAttribute("student"); %>
	<table border="1">
		<tr> 
			<th> Id<br/> </th>
			<th> Name<br/> </th>
			<th> Email<br/> </th>
			<th> Standard<br/> </th>
			<th> Section<br/> </th>
			<th> Over All Percentage<br/> </th>
			<th> Gender<br/> </th>
			<th> Parent Contact<br/> </th>
			<th> Remarks<br/> </th>
			<th> Address<br/> </th>
			<th> Password<br/> </th>
		</tr>
		<tr> 
			<td> <%=c.getId() %><br/> </td>
			<td> <%=c.getName() %><br/> </td>
			<td> <%=c.getEmail() %><br/> </td>
			<td> <%=c.getStd() %><br/> </td>
			<td> <%=c.getSec() %><br/> </td>
			<td> <%=c.getOverAllPercentage() %><br/> </td>
			<td> <%=c.getGender() %><br/> </td>
			<td> <%=c.getParentContact() %><br/> </td>
			<td> <%=c.getRemarks() %><br/> </td>
			<td> <%=c.getAddress() %><br/> </td>
			<td> <%=c.getPassword() %><br/> </td>
			<td> <a href="http://localhost:8080/FullProject/EditStudent.html"><input type="button" value="EDIT"></a><br/> </td>
		</tr>
	</table>
</body>
</html>