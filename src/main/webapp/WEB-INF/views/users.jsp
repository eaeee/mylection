<%@ page contentType="text/html;charset=UTF-8" language="java" %> 

<%@ include file="../layouts/taglib.jsp" %>

<br>
<br>
<br>
<br>
<br>
<br>
<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th> user ID</th> 
			<th> user name</th>
			<th> operation</th>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach items="${users}"  var="user">
			<tr>
			  	<td>
					${user.userId}
				</td> 
				<td>
					<a href="<spring:url value="/users/${user.userId}"/>"> 
						${user.userName}
					</a> 
				</td>
				<td>
					<a href="<spring:url value="/users/remove/${user.userId}"/>" class="btn btn-danger"> 
						remove
					</a> 
				</td>				
			</tr>
		</c:forEach>
	</tbody>
</table>