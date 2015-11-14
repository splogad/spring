<%@include file="includes/header.jsp"%>
<div class="container">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">Please Signup</h3>
		</div>

		<div class="panel-body">
			<form:form modelAttribute="signupForm" role="form">
				
				<form:errors />
			
				<div class="form-group">
					<form:label path="email">Email address</form:label>
					<form:input path="email" type="email" class="form-control" placeholder="Email address" />
					<form:errors cssClass="error" path="email"/>
					<p class="help-block">Enter a unique email address.</p>
				</div>

				<div class="form-group">
					<form:label path="name">Name</form:label>
					<form:input path="name" class="form-control" placeholder="Name" />
					<form:errors cssClass="error" path="name"/>
					<p class="help-block">Enter a unique name.</p>
				</div>

				<div class="form-group">
					<form:label path="password">Password</form:label>
					<form:password path="password" class="form-control" placeholder="Password" />
					<form:errors cssClass="error" path="password"/>
					<p class="help-block">Enter a unique password.</p>
				</div>
				<button type="submit" class="btn btn-default">Submit</button>
			</form:form>
		</div>
	</div>
</div>
<%@include file="includes/footer.jsp"%>