<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport"
	content="width = device-width, initial-scale = 1.0">

<link href="../resources/css/sportal.css" rel="stylesheet">
<link href="../webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="../webjars/bootstrap-social/4.12.0/bootstrap-social.css">
<link href="../webjars/font-awesome/4.6.1/css/font-awesome.css"
	rel="stylesheet">

<title><fmt:message key="app.title" /></title>
</head>
<body>
	<header>
		<fmt:message key="signin.title" />
	</header>
	<section>

		<label class="error">${fail}</label>
		<form:form method="POST" modelAttribute="user">
			<table>
				<tr>
					<td><label for="userName"><fmt:message key="username" />:
					</label></td>
					<td><form:input path="userName" id="userName" /></td>
					<td><form:errors path="userName" cssClass="error" /></td>
				</tr>
				<tr>
					<td><label for="password"><fmt:message key="password" />:
					</label></td>
					<td><form:password path="password" id="password" /></td>
					<td><form:errors path="password" cssClass="error" /></td>
				</tr>
				<tr>
					<td><input type="submit" value='<fmt:message key="signin"/>'
						class="btn btn-primary" /></td>

					<td colspan="2"><input type="submit"
						value='<fmt:message key="clear"/>' class="btn btn-warning" /></td>

				</tr>
			</table>
		</form:form>
	</section>
</body>
</html>