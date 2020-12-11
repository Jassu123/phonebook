<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Phone Book</title>
</head>
<body>

	<h4>Save Contact</h4>
		${successMsg} ${errorMsg}

	<form:form action="saveContact?contactId=${contact.contactId}" method="POST" modelAttribute="contact">
		<table>
			<tr>
				<td>Contact Name</td>
				<td><form:input path="contactName" /></td>
			</tr>
			<tr>
				<td>Contact Number</td>
				
				<td><form:input path="contactNumber"/></td>
			</tr>
			<tr>
				<td>Contact Email</td>
				<td><form:input path="contactEmail"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Submit"/></td>
			</tr>
		</table>

			<a href="viewContacts">View All Contacts</a>
	</form:form>

</body>
</html>