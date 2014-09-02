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
 <button class="btn btn-primary" data-target="#classificationModal" data-toggle="modal">Add classification</button>
<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th> subject ID</th> 
			<th> subject name</th>
			<th> operation</th>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach items="${classifications}"  var="classification">
			<tr>
			  	<td>
					${classification.subjectClassificationId}
				</td> 
				<td>
						${classification.subjectClassificationName}
				</td>
				<td>
					<a href="<spring:url value="/classifications/remove/${classification.subjectClassificationId}"/>" class="btn btn-danger triggerRemove"> 
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
        <h4 class="modal-title" id="myModalLabel">Remove classification</h4>
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

<!-- Modal -->
<form:form commandName="classification" cssClass="form-horizontal">
<div class="modal fade" id="classificationModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      
      <div class="modal-body">
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label"> Название классификации:</label>
				<div class="col-sm-10">
					<form:input type="text" path="subjectClassificationName"/>
				</div>
			</div>          
      </div>
      
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <input type="submit" class="btn btn-primary" value="save"/>
      </div>
      
    </div>
  </div>
</div>
</form:form>
