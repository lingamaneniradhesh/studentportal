<header>
	<div class="responsive">
		<div>
			<img src="../resources/images/logo.png" />
			<security:authorize access="isAuthenticated()">
				<fmt:message key="welcome">
					<fmt:param value="${signedInUser.student.firstName}" />
					<fmt:param value="${signedInUser.student.lastName}" />
				</fmt:message>
				<a class="btn btn-danger" href="<c:url value='/login/logout' />">
					<fmt:message key="signout" />
				</a>
			</security:authorize>
			<security:authorize access="!isAuthenticated()">
				<a class="btn btn-primary" href="<c:url value='/login/login' />">
					<fmt:message key="signin" />
				</a>
			</security:authorize>
			<a class="btn btn-social-icon btn-facebook"> <span
				class="fa fa-facebook"></span>
			</a> <a class="btn btn-social-icon btn-twitter"> <span
				class="fa fa-twitter"></span>
			</a> <a class="btn btn-social-icon btn-linkedin"> <span
				class="fa fa-linkedin"></span>
			</a> <a class="btn btn-social-icon btn-youtube-square"> <span
				class="fa fa-youtube-square"></span>
			</a> <a class="btn btn-social-icon btn-instagram"> <span
				class="fa fa-instagram"></span>
			</a> <a class="btn btn-social-icon btn-pinterest"> <span
				class="fa fa-pinterest"></span>
			</a> <a class="btn btn-social-icon btn-flickr"> <span
				class="fa fa-flickr"></span>
			</a><a class="btn btn-social-icon btn-paypal"> <span
				class="fa fa-paypal"></span>
			</a><a class="btn btn-social-icon btn-cc-visa"> <span
				class="fa fa-cc-visa"></span>
			</a>
			<a class="btn btn-social-icon btn-cc-mastercard"> <span
				class="fa fa-cc-mastercard"></span>
			</a>
		</div>
	</div>
</header>