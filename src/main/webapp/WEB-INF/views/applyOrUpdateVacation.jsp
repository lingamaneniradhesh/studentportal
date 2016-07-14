<%@ include file="top.jsp"%>

<section>

	<h2>Vacation</h2>

	<form:form method="POST" modelAttribute="vacation">
		<table>
			<tr>
				<td><label for="fromDate"><fmt:message key="fromdate" />:
				</label></td>
				<td><form:input path="fromDate" id="fromDate" /></td>
				<td><form:errors path="fromDate" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="toDate"><fmt:message key="todate" />:
				</label></td>
				<td><form:input path="toDate" id="toDate" /></td>
				<td><form:errors path="toDate" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="leaveType"><fmt:message key="leavetype" />:
				</label>
				</td>
				<td>
				<select>
				        <option>Choose Vacation Type</option>
				        <c:forEach items="${leaveTypes}" var="leaveType">
						<option>${leaveType}</option>
						</c:forEach>
				</select>
				</td>
				<td><form:errors path="leaveType" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="3"><c:choose>
						<c:when test="${edit}">
							<input type="submit" value='<fmt:message key="update"/>'
								class="button" />
						</c:when>
						<c:otherwise>
							<input type="submit" value='<fmt:message key="apply"/>'
								class="button" />
						</c:otherwise>
					</c:choose></td>
			</tr>
		</table>
	</form:form>
</section>

<%@ include file="bottom.jsp"%>