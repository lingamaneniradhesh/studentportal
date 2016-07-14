<footer>
	<br>
	<c:set var="now" value="<%=new java.util.Date()%>" />
	<fmt:formatDate value="${now}" pattern="yyyy" var="currentYear" />
	<fmt:message key="copyright">
		<fmt:param value="${currentYear}" />
	</fmt:message>
	<br>
	<p></p>
</footer>
