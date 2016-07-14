<%@ include file="top.jsp"%>

<%@ include file="contactForm.jsp"%>

<c:if test="${not empty contacts}">
	<%@ include file="contactList.jsp"%>
</c:if>
<%@ include file="bottom.jsp"%>