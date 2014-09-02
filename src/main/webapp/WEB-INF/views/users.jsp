<%@ page contentType="text/html;charset=UTF-8" language="java" %> 

<%@ include file="../layouts/taglib.jsp" %>

<script type="text/javascript">
	$(document).ready(function(){
		$(".triggerRemove").click(function(e){
			e.preventDefault();
			$("#modalRemove .removeBtn").attr("href",$(this).attr("href"));
			$("#modalRemove").modal();
		});
	});
</script>
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
						<c:out value="${user.userName}"/>
					</a> 
				</td>
				<td>
					<a href="<spring:url value="/users/remove/${user.userId}"/>" class="btn btn-danger triggerRemove"> 
						remove
					</a> 
				</td>				
			</tr>
		</c:forEach>
	</tbody>
</table>




<!-- Modal -->
<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">Remove user</h4>
      </div>
      <div class="modal-body">
        Really remove?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">cancel</button>
        <a href="" class="btn btn-danger removeBtn">remove</a>
      </div>
    </div>
  </div>
</div>