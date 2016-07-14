<security:authorize access="hasRole('ROLE_ADMIN')" var="isAdmin" />

<nav>
	<ul>
		<li><a href="../dashboard/show"><fmt:message key="dashboard" /></a></li>
		<li class="sub"><a href="#"><fmt:message key="time.tracker" /></a>
			<ul>
				<li class="sub"><a href="#"><fmt:message key="timesheet" /></a>
					<ul>
						<li><a href="../timesheet/create"><fmt:message
									key="create" /></a></li>
						<li><a href="../timesheet/update"><fmt:message
									key="update" /></a></li>
						<li><a href="../timesheet/delete"><fmt:message
									key="delete" /></a></li>
					</ul></li>
				<li class="sub"><a href="#"><fmt:message key="time.in.out" /></a>
					<ul>
						<li><a href="../timeinout/create"><fmt:message
									key="create" /></a></li>
						<li><a href="../timeinout/update"><fmt:message
									key="update" /></a></li>
						<li><a href="../timeinout/delete"><fmt:message
									key="delete" /></a></li>
					</ul></li>
				<li class="sub"><a href="#"><fmt:message key="vacation" /></a>
					<ul>
						<li><a href="../vacation/apply"><fmt:message key="apply" /></a></li>
						<li><a href="../vacation/modify"><fmt:message
									key="modify" /></a></li>
						<li><a href="../vacation/delete"><fmt:message
									key="delete" /></a></li>
					</ul></li>
			</ul></li>
		<li class="sub"><a href="#"><fmt:message
					key="appraisal" /></a>
			<ul>
				<li><a href="../appraisal/create"><fmt:message key="create" /></a></li>
				<li><a href="../appraisal/update"><fmt:message key="update" /></a></li>
				<li><a href="../appraisal/review"><fmt:message key="review" /></a></li>
				<li><a href="../appraisal/approve"><fmt:message
							key="approve" /></a></li>
			</ul></li>
		<li class="sub"><a href="#"><fmt:message key="my.profile" /></a>
			<ul>
				<li class="sub"><a href="#"><fmt:message key="phone" /></a>
					<ul>
						<li><a href="../phone/create"><fmt:message key="create" /></a></li>
						<li><a href="../phone/update"><fmt:message key="update" /></a></li>
						<li><a href="../phone/delete"><fmt:message key="delete" /></a></li>
					</ul></li>
				<li class="sub"><a href="#"><fmt:message key="hobby" /></a>
					<ul>
						<li><a href="../hobby/create"><fmt:message key="create" /></a></li>
						<li><a href="../hobby/update"><fmt:message key="update" /></a></li>
						<li><a href="../hobby/delete"><fmt:message key="delete" /></a></li>
					</ul></li>
			</ul></li>

		<security:authorize access="hasRole('ROLE_ADMIN')">
			<li><a href="#"><fmt:message key="reports" /></a></li>
		</security:authorize>
		<c:if test="${isAdmin}">

			<li class="sub"><a href="#"><fmt:message key="admin" /></a>
				<ul>
					<li class="sub"><a href="#"><fmt:message
								key="announcement" /></a>
						<ul>
							<li><a href="../announcement/create"><fmt:message
										key="create" /></a></li>
							<li><a href="../announcement/update"><fmt:message
										key="update" /></a></li>
							<li><a href="../announcement/list"><fmt:message
										key="list" /></a></li>
						</ul></li>
					<li class="sub"><a href="#"><fmt:message key="role" /></a>
						<ul>
							<li><a href="../role/create"><fmt:message key="create" /></a></li>
							<li><a href="../role/update"><fmt:message key="update" /></a></li>
							<li><a href="../role/list"><fmt:message key="list" /></a></li>
						</ul></li>
					<li class="sub"><a href=""><fmt:message key="student" /></a>
						<ul>
							<li><a href="../student/create"><fmt:message
										key="create" /></a></li>
							<li><a href="../student/update"><fmt:message
										key="update" /></a></li>
							<li><a href="../student/list"><fmt:message key="list" /></a></li>
						</ul></li>
					<li class="sub"><a href="#"><fmt:message key="user" /></a>
						<ul>
							<li><a href="../user/create"><fmt:message key="create" /></a></li>
							<li><a href="../user/update"><fmt:message key="update" /></a></li>
							<li><a href="../user/list"><fmt:message key="list" /></a></li>
						</ul></li>
				</ul></li>

			<li><a href="#"><fmt:message key="audit" /></a></li>

		</c:if>
		<li class="sub"><a href="#"><fmt:message key="contact" /></a>
			<ul>
				<li><a href="../contact/about"><fmt:message key="about.us" /></a></li>
				<li><a href="../contact/contact"><fmt:message
							key="contact.us" /></a></li>
			</ul></li>
	</ul>
</nav>