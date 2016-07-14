<div class="table-responsive">
	<div class="panel panel-primary">
		<div class="panel-heading text-center">
			<fmt:message key="contact.list" />
		</div>

		<table class="table table-striped">
			<tr>
				<th><fmt:message key="id" /></th>
				<th><fmt:message key="firstname" /></th>
				<th><fmt:message key="middlename" /></th>
				<th><fmt:message key="lastname" /></th>
				<th><fmt:message key="email" /></th>
				<th><fmt:message key="dob" /></th>
				<th><fmt:message key="doj" /></th>
				<th><fmt:message key="dateleft" /></th>
				<th><fmt:message key="action" /></th>
			</tr>
			<c:forEach items="${contacts}" var="contact">
				<tr>
					<td>${contact.id}</td>
					<td>${contact.firstName}</td>
					<td>${contact.middleName}</td>
					<td>${contact.lastName}</td>
					<td>${contact.email}</td>
					<td>${contact.dateOfBirth}</td>
					<td>${contact.dateOfJoining}</td>
					<td>${contact.dateLeft}</td>
					<td><a class="btn btn-primary"
						href="<c:url value='../contact/edit-${contact.id}-contact' />"><fmt:message
								key="edit" /></a> / <a class="btn btn-warning"
						href="<c:url value='../contact/delete-${contact.id}-contact'  />"><fmt:message
								key="delete" /></a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>

