<%@ include file="top.jsp"%>

<%@ include file="announcementForm.jsp"%>

<c:if test="${not empty announcements}">
	<%@ include file="announcementList.jsp"%>
</c:if>
<%@ include file="bottom.jsp"%>