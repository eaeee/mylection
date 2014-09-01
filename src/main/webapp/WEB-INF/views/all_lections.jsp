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
			<th> lection ID</th> 
			<th> lection Body</th>
			<th> lection Date</th>
			<th> operation</th>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach items="${lections}"  var="lection">
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
				<td>
					<a href="<spring:url value="/lections/remove/${lection.lectionId}"/>" class="btn btn-danger triggerRemove"> 
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