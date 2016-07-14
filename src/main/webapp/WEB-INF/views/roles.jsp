<%@ include file="top.jsp"%>

<div class="table-responsive">
	<div class="panel panel-primary">
		<div class="panel-heading text-center">
			<fmt:message key="role.list" />
		</div>

		<table class="table table-striped">
			<tr>
				<th><fmt:message key="id" /></th>
				<th><fmt:message key="rolename" /></th>
				<th><fmt:message key="action" /></th>
			</tr>
			<c:forEach items="${roles}" var="role">
				<tr>
					<td>${role.id}</td>
					<td>${role.roleName}</td>
					<td><a class="btn btn-primary"
						href="<c:url value='../role/edit-${role.id}-role' />"><fmt:message
								key="edit" /></a> / <a class="btn btn-warning"
						href="<c:url value='../role/delete-${role.id}-role' />"><fmt:message
								key="delete" /></a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>

<%@ include file="bottom.jsp"%>