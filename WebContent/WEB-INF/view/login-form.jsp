<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html.
<html>
<head>
<title>Login page</title>
<style>
.error {
	color: red
}
p{
 font-style: italic; 
 color: red;
}
</style>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Registered applicant/employer? Login here</h2>
		</div>
	</div>
	<div id="container">
		<form:form action="loginUser" modelAttribute="user" method="POST">
		<p>${message}</p>
			<table>
				<tbody>				
					<tr>
						<td><label>User Name:</label></td>
						<td><form:input path="username" /></td>
						<td><form:errors path="username" cssClass="error" /></td>
					</tr>
					<tr>
						<td><label>Password:</label></td>
						<td><form:password path="password" /></td>
						<td><form:errors path="password" cssClass="error" /></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Login" class="save"></td>
					</tr>
				</tbody>
			</table>
		</form:form>
	</div>
</body>

</html>