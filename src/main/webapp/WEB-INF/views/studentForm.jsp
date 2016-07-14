<div class="table-responsive">
	<div class="panel panel-primary">
		<div class="panel-heading text-center">
			<fmt:message key="create.student" />
		</div>

		<form:form method="POST" modelAttribute="student">
			<form:input type="hidden" path="id" id="id" />
			<form:input type="hidden" path="dateLeft" id="dateLeft" />

			<table class="table table-striped">
				<tr>
					<td><label for="firstName"><fmt:message
								key="firstname" /></label></td>
					<td><form:input path="firstName" id="firstName" /></td>
					<td><form:errors path="firstName" cssClass="error" /></td>
				</tr>
				<tr>
					<td><label for="middleName"><fmt:message
								key="middlename" /></label></td>
					<td><form:input path="middleName" id="middleName" /></td>
					<td><form:errors path="middleName" cssClass="error" /></td>
				</tr>
				<tr>
					<td><label for="lastName"><fmt:message key="lastname" />
					</label></td>
					<td><form:input path="lastName" id="lastName" /></td>
					<td><form:errors path="lastName" cssClass="error" /></td>
				</tr>
				<tr>
					<td><label for="email"><fmt:message key="email" /></label></td>
					<td><form:input path="email" id="email" /></td>
					<td><form:errors path="email" cssClass="error" /></td>
				</tr>
				<tr>
					<td><label for="dateOfBirth"><fmt:message key="dob" />
					</label></td>
					<td><form:input type="date" path="dateOfBirth"
							id="dateOfBirth" /></td>
					<td><form:errors path="dateOfBirth" cssClass="error" /></td>
				</tr>
				<tr>
					<td><label for="dateOfJoining"><fmt:message key="doj" />
					</label></td>
					<td><form:input type="date" path="dateOfJoining"
							id="dateOfJoining" /></td>
					<td><form:errors path="dateOfJoining" cssClass="error" /></td>
				</tr>
				<tr>
					<td colspan="3"><c:choose>
							<c:when test="${edit}">
								<input type="submit" value="<fmt:message key='update'/>"
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