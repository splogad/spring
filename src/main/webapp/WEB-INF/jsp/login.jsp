<%@include file="includes/header.jsp"%>
<div class="container">
	<div class="panel panel-primary">
	
		<div class="panel-heading">
			<h3 class="panel-title">Please login</h3>
		</div>
	
		<div class="panel-body">
		
			<c:if test="${param.error != null}">
				<div class="alert alert-danger">
					Invalid username or password.
				</div>
			</c:if>
			
			<c:if test="${param.logout != null}">
				<div class="alert alert-danger">
					You have been succesfully logged out.
				</div>
			</c:if>
			
			<form:form role="form" method="post">
				<div class="form-group">
					<label for="username">Email Address:</label>
					<input id="username" name="username" type="email" class="form-control"></label>
					<p class="help-block">Enter your email:</p>
				</div>
				<div class="form-group">
					<label for="password">Password:</label>
					<input id="password" name="password" type="password" class="form-control"></label>
					<form:errors cssClass="error" path="password"/>
				</div>				
				<button type="submit"  class="btn btn-primary">Sign in</button>
			</form:form>
		</div>
	</div>
</div>
<%@include file="includes/footer.jsp"%>