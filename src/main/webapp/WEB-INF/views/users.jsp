<%@ include file="top.jsp"%>

<div class="table-responsive">
	<div class="panel panel-primary">
		<div class="panel-heading text-center">
			<fmt:message key="user.list" />
		</div>

		<table class="table table-striped">
			<tr>
				<th><fmt:message key="id" /></th>
				<th><fmt:message key="username" /></th>
				<th><fmt:message key="enabled" /></th>
				<th><fmt:message key="firstname" /></th>
				<th><fmt:message key="lastname" /></th>
				<th><fmt:message key="rolename" /></th>
				<th><fmt:message key="action" /></th>
			</tr>
			<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.id}</td>
					<td>${user.userName}</td>
					<td>${user.isEnabled}</td>
					<td>${user.student.firstName}</td>
					<td>${user.student.lastName}</td>
					<td>${user.role.roleName}</td>
					<td><a class="btn btn-primary"
						href="<c:url value='../user/edit-${user.id}-user' />"><fmt:message
								key="edit" /></a> / <a class="btn btn-warning"
						href="<c:url value='../user/delete-${user.id}-user' />"><fmt:message
								key="delete" /></a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>

<%@ include file="bottom.jsp"%>