<div class="table-responsive">
	<div class="panel panel-primary">
		<div class="panel-heading text-center">
			<fmt:message key="create.contact" />
		</div>

		<form:form method="POST" modelAttribute="contact">
			<table class="table table-striped">
				<tr>
					<td><label for="firstName"><fmt:message
								key="firstname" /></label></td>
					<td><form:input path="firstName" id="firstName" /></td>
					<td><form:errors path="firstName" cssClass="error" /></td>
				</tr>
				<tr>
					<td><label for="lastName"><fmt:message key="lastname" />
					</label></td>
					<td><form:input path="lastName" id="lastName" /></td>
					<td><form:errors path="lastName" cssClass="error" /></td>
				</tr>
				<tr>
					<td><label for="email"><fmt:message key="email" /> </label></td>
					<td><form:input path="email" id="email" /></td>
					<td><form:errors path="email" cssClass="error" /></td>
				</tr>
				<tr>
					<td><label for="phoneNumber"><fmt:message
								key="phonenumber" /></label></td>
					<td><form:input path="phoneNumber" id="phoneNumber" /></td>
					<td><form:errors path="phoneNumber" cssClass="error" /></td>
				</tr>
				<tr>
					<td><label for="description"><fmt:message key="description" />
					</label></td>
					<td><form:textarea rows="10" cols="50" path="description"
							id="description" /></td>
					<td><form:errors path="description" cssClass="error" /></td>
				</tr>
				<tr>
					<td colspan="3"><c:choose>
							<c:when test="${edit}">
								<input type="submit" value="<fmt:message key='update'/>"
									class="btn btn-primary" />
							</c:when>
							<c:otherwise>
								<input type="submit" value='<fmt:message key="submit"/>'
									class="btn btn-primary" />
							</c:otherwise>
						</c:choose></td>
				</tr>
			</table>
		</form:form>
	</div>
</div>