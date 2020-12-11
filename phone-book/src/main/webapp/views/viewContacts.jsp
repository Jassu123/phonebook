<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Phone Book</title>

<script type="text/javascript">
function confirmDelete(){
	return confirm("are you sure you wanna delete a record?")
}

</script>
</head>
<body>

	<a href="loadForm">+Add New Contact</a>

	<h3>View Contacts Here</h3>

	<table border="1">
		<thead>
			<tr>
				<th>Contact Name</th>
				<th>Contact Number</th>
				<th>Contact Email</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${contacts}" var="c">

				<tr>
					<td>${c.contactName}</td>
					<td>${c.contactNumber}</td>
					<td>${c.contactEmail}</td>
					<td>
						<a href="/editContact?contactId=${c.contactId}">Edit</a> &nbsp;  &nbsp;
						<a href="/deleteContact?contactId=${c.contactId}" onclick="return confirmDelete()">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>