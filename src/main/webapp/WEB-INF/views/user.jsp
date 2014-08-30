<%@ page contentType="text/html;charset=UTF-8" language="java" %> 

<%@ include file="../layouts/taglib.jsp" %>

<br>
<br>
<br>
<br>
<br>
<br>

<h1>${user.userName}</h1>


<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th> lection ID</th> 
			<th> lection Body</th>
			<th> lection Date</th>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach items="${user.lections}"  var="lection">
			<tr>
			  	<td>
					${lection.lectionId}
				</td> 
			  	<td>
					${lection.lectionBody}
				</td> 
			  	<td>
					${lection.lectionDate}
				</td> 				
			</tr>
		</c:forEach>
	</tbody>
</table>