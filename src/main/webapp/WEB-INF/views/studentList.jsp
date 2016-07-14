<div class="table-responsive">
	<div class="panel panel-primary">
		<div class="panel-heading text-center">
			<fmt:message key="student.list" />
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
			<c:forEach items="${students}" var="student">
				<tr>
					<td>${student.id}</td>
					<td>${student.firstName}</td>
					<td>${student.middleName}</td>
					<td>${student.lastName}</td>
					<td>${student.email}</td>
					<td>${student.dateOfBirth}</td>
					<td>${student.dateOfJoining}</td>
					<td>${student.dateLeft}</td>
					<td><a class="btn btn-primary"
						href="<c:url value='../student/edit-${student.id}-student' />"><fmt:message
								key="edit" /></a> / <a class="btn btn-warning"
						href="<c:url value='../student/delete-${student.id}-student'  />"><fmt:message
								key="delete" /></a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>

