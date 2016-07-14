<div class="table-responsive">
	<div class="panel panel-primary">
		<div class="panel-heading text-center">
			<fmt:message key="create.announcement" />
		</div>

		<form:form method="POST" modelAttribute="announcement">
			<table class="table table-striped">
				<tr>
					<td><label for="title"><fmt:message key="title" /></label></td>
					<td><form:input path="title" id="title" /></td>
					<td><form:errors path="title" cssClass="error" /></td>
				</tr>
				<tr>
					<td><label for="description"><fmt:message
								key="description" /> </label></td>
					<td><form:input path="description" id="description" /></td>
					<td><form:errors path="description" cssClass="error" /></td>
				</tr>
				<tr>
					<td><label for="fromDate"><fmt:message key="fromdate" />
					</label></td>
					<td><form:input type="date" path="fromDate" id="fromDate" /></td>
					<td><form:errors path="fromDate" cssClass="error" /></td>
				</tr>
				<tr>
					<td><label for="toDate"><fmt:message key="todate" />
					</label></td>
					<td><form:input type="date" path="toDate" id="toDate" /></td>
					<td><form:errors path="toDate" cssClass="error" /></td>
				</tr>
				<tr>
					<td colspan="3"><c:choose>
							<c:when test="${edit}">
								<input type="submit" value='<fmt:message key="update"/>'
									class="btn btn-primary" />
							</c:when>
							<c:otherwise>
								<input type="submit" value='<fmt:message key="create"/>'
									class="btn btn-primary" />
							</c:otherwise>
						</c:choose></td>
				</tr>
			</table>
		</form:form>
	</div>
</div>