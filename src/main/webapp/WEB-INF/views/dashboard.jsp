<%@ include file="top.jsp"%>

<div class="row">
	<div class="col-xs-12 col-sm-6 col-md-8">
		<div class="panel panel-primary">
			<div class="panel-heading text-center">
				<fmt:message key="announcement.list" />
			</div>

			<table class="table table-striped">
				<tr>
					<th><fmt:message key="title" /></th>
					<th><fmt:message key="fromdate" /></th>
					<th><fmt:message key="todate" /></th>
				</tr>
				<c:forEach items="${announcements}" var="announcement">
					<tr>
						<td><a class="btn .btn-link" href="#" data-toggle="popover"
							title="${announcement.title}"
							data-content="${announcement.description}" data-trigger="hover">${announcement.title}</a></td>
						<td>${announcement.fromDate}</td>
						<td>${announcement.toDate}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<div class="col-xs-6 col-md-4">
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
				<li data-target="#myCarousel" data-slide-to="3"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img
						src="../resources/images/dashboard/dashboard${dashboardImages[0]}.png"
						alt="Alt1">
					<div class="carousel-caption">
						<h3>First</h3>
						<p>First Image</p>
					</div>
				</div>
				<div class="item">
					<img
						src="../resources/images/dashboard/dashboard${dashboardImages[1]}.png"
						alt="Alt2">
					<div class="carousel-caption">
						<h3>Second</h3>
						<p>Second Image</p>
					</div>
				</div>
				<div class="item">
					<img
						src="../resources/images/dashboard/dashboard${dashboardImages[2]}.png"
						alt="Alt3">
					<div class="carousel-caption">
						<h3>Third</h3>
						<p>Third Image</p>
					</div>
				</div>
				<div class="item">
					<img
						src="../resources/images/dashboard/dashboard${dashboardImages[3]}.png"
						alt="Alt4">
					<div class="carousel-caption">
						<h3>Fourth</h3>
						<p>Fourth Image</p>
					</div>
				</div>
			</div>

			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" role="button"
				data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel" role="button"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-xs-6 col-sm-4">
		<img class="img-rounded"
			src="../resources/images/dashboard/dashboard${lastimageid}.png" />
	</div>
	<div class="col-xs-6 col-sm-4">
		<img class="img-circle"
			src="../resources/images/dashboard/dashboard${firstimageid}.png" />
	</div>
	<!-- Optional: clear the XS cols if their content doesn't match in height -->
	<div class="clearfix hidden-sm-up">
		<img class="img-rounded"
			src="../resources/images/dashboard/dashboard${lastimageid}.png" />
	</div>
</div>
<%@ include file="bottom.jsp"%>