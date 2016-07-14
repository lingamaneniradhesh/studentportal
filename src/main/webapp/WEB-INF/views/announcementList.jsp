<div class="table-responsive">
	<div class="panel panel-primary">
		<div class="panel-heading text-center">
			<fmt:message key="announcement.list" />
		</div>

		<table class="table table-striped">
			<tr>
				<th><fmt:message key="id" /></th>
				<th><fmt:message key="title" /></th>
				<th><fmt:message key="description" /></th>
				<th><fmt:message key="fromdate" /></th>
				<th><fmt:message key="todate" /></th>
				<th><fmt:message key="action" /></th>
			</tr>
			<c:forEach items="${announcements}" var="announcement">
				<tr>
					<td>${announcement.id}</td>
					<td>${announcement.title}</td>
					<td>${announcement.description}</td>
					<td>${announcement.fromDate}</td>
					<td>${announcement.toDate}</td>
					<td><a class="btn btn-primary"
						href="<c:url value='../announcement/edit-${announcement.id}-announcement' />"><fmt:message
								key="edit" /></a> / <a class="btn btn-warning"
						href="<c:url value='../announcement/delete-${announcement.id}-announcement' />"><fmt:message
								key="delete" /></a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
