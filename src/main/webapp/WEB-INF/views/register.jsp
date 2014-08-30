<%@ page contentType="text/html;charset=UTF-8" language="java" %> 

<%@ include file="../layouts/taglib.jsp" %>

<br>
<br>
<br>
<br>
<br>
<br>

<form:form commandName="user" cssClass="form-horisontal">
	
	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">Name</label>
		<div class="col-sm-10">
			<form:input path="userName" cssClass="form-control"/>
		</div>
	</div>
	<br>
	<div class="form-group">
		<label for="password" class="col-sm-2 control-label">Password:</label>
		<div class="col-sm-10">
			<form:password path="userPassword" cssClass="form-control"/>
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