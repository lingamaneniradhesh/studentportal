<%@ include file="top.jsp"%>

<%@ include file="studentForm.jsp"%>

<c:if test="${not empty students}">
	<%@ include file="studentList.jsp"%>
</c:if>
<%@ include file="bottom.jsp"%>