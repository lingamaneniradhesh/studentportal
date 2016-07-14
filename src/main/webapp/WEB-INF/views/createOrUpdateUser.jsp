<%@ include file="top.jsp"%>

<div class="table-responsive">
	<div class="panel panel-primary">
		<div class="panel-heading text-center">
			<fmt:message key="create.user" />
		</div>

		<form:form method="POST" modelAttribute="user">

			<table class="table table-striped">
				<tr>
					<td><label for="userName"><fmt:message key="username" />:
					</label></td>
					<td><form:input path="userName" id="userName" /></td>
					<td><form:errors path="userName" cssClass="error" /></td>
				</tr>
				<tr>
					<td><label for="password"><fmt:message key="password" />:
					</label></td>
					<td><form:input path="password" id="password" /></td>
					<td><form:errors path="password" cssClass="error" /></td>
				</tr>
				<tr>
					<td><label for="confirmPassword"><fmt:message
								key="confirmpassword" />: </label></td>
					<td><form:input path="confirmPassword" id="confirmPassword" /></td>
					<td><form:errors path="confirmPassword" cssClass="error" /></td>
				</tr>
				<tr>
					<td><label for="isEnabled"><fmt:message
								key="isenabled" />: </label></td>
					<td><form:input path="isEnabled" id="isEnabled" /></td>
					<td><form:errors path="isEnabled" cssClass="error" /></td>
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
<%@ include file="bottom.jsp"%>