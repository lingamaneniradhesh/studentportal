<%@ include file="top.jsp"%>

<div class="table-responsive">
	<div class="panel panel-primary">
		<div class="panel-heading text-center">
			<fmt:message key="create.role" />
		</div>

		<form:form method="POST" modelAttribute="role">

			<table class="table table-striped">
				<tr>
					<td><label for="roleName"><fmt:message
								key="rolename" />: </label></td>
					<td><form:input path="roleName" id="roleName" /></td>
					<td><form:errors path="roleName" cssClass="error" /></td>
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