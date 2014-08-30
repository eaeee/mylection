<%@ page contentType="text/html;charset=UTF-8" language="java" %> 

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

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
			</tr>
		</c:forEach>
	</tbody>
</table>