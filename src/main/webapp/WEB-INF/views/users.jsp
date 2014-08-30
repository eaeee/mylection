<%@ page contentType="text/html;charset=UTF-8" language="java" %> 

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<br>
<br>
<br>
<br>
<br>
<br>
<table class="table table-bordered table-hover table-striped">
	<thead> 
		<tr> 
			<th> user name</th>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach items="${users}"  var="user">
			<tr> 
				<td> 
					${user.userName}
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>