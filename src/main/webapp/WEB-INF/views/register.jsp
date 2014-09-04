<%@ page contentType="text/html;charset=UTF-8" language="java" %> 

<%@ include file="../layouts/taglib.jsp" %>

<br>
<br>
<br>
<br>
<br>
<br>

<form:form commandName="user" cssClass="form-horisontal regForm">

	<c:if test="${param.success eq true}">
		
		<div class="alert alert-success"> Registration successfull!</div>
	</c:if>
	
	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">Name</label>
		<div class="col-sm-10">
			<form:input path="userName" cssClass="form-control"/>
			<form:errors path="userName"></form:errors>
		</div>
	</div>
	<br>
	<div class="form-group">
		<label for="password" class="col-sm-2 control-label">Password:</label>
		<div class="col-sm-10">
			<form:password path="userPassword" cssClass="form-control"/>
			<form:errors path="userPassword"></form:errors>
		</div>
	</div>
	<div class="form-group">
		<label for="password" class="col-sm-2 control-label">Password again:</label>
		<div class="col-sm-10">
			<input type="password" name="password_again" id="password_again" class="form-control">
		</div>
	</div>	
	<br>
	<div class="form-group">
		<div class="col-sm-2">
		<input type="submit" value="Register" class="btn btn-lg btn-primary"/>
		</div>
	</div>
	<br>
</form:form>

<script>
	$(document).ready(function() {
		$(".regForm").validate({
			rules: {
					userName: {
						required : true,
						minlength : 5,
						remote : {
							url : "<spring:url value='/available' />",
							type: "get",
							data : {
								userName : function() {
									return $("#userName").val();
								}
							}
						}
					},
					userPassword: {
						required : true,
						minlength: 8
					},
					password_again: {
						required : true,
						minlength: 8,
						equalTo: "#userPassword"
					}
				},
			highlight: function(element){
				$(element).closest(".form-group").removeClass('has-success').addClass('has-error');
			},
			unhighlight: function(element){
				$(element).closest(".form-group").removeClass('has-error').addClass('has-success');
			},
			messages: {
					userName: {
						remote: "This username already exists!"
					}
			}
		});
	});
</script>