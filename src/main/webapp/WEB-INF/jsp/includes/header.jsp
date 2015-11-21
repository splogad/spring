<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Page</title>
<link href="/public/lib/bootstrap-3.3.5-dist/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="/public/css/style.css" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-default">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
			</div>
			<a class="navbar-brand" href="/">SplogadAPP</a>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Dropdown <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#">Separated link</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#">One more separated link</a></li>
						</ul></li>
				</ul>
				<form class="navbar-form navbar-left" role="search">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>

				<ul class="nav navbar-nav navbar-right">
					<c:if test="${pageContext.request.userPrincipal.name != null}">
						<li><a href="#"> Welcome :
								${pageContext.request.userPrincipal.name} </a></li>
					</c:if>

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Account <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<sec:authorize access="isAnonymous()"><!-- se anonymo mostrami i link di login e registrazione -->
								<li><a href="<c:url value='/login'/>"><span
										class="glyphicon glyphicon-log-in">&nbsp;</span>Login</a></li>
								<li><a href="<c:url value='/signup'/><span>
											class="glyphicon glyphicon-log-in">&nbsp;</span>Sign Up</a></li>
							</sec:authorize>
							<sec:authorize access="isAuthenticated()"><!-- Se autenticato mostra il logout -->
								<li><c:url var="logoutVar" value="/Logout" /> <form:form
										id="logoutForm" action="${logoutVar}" method="post">
									</form:form> <a href="#"
									onclick="document.getElementById('logoutForm').submit()"> <span
										class="glyphicon glyphicon-log-out">&nbsp;</span> Log Out
								</a></li>
							</sec:authorize>
						</ul>
					</li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid --> </nav>
	</div>

	<div class="container">
		<c:if test="${not empty flashMessage}">
			<div class="alert alert-${flashKind} alert-dismissable">
				<button type="button" class="close" data-dismiss="alsert"
					aria-hidden="true">&times;</button>
				${flashMessage}
			</div>
		</c:if>
	</div>