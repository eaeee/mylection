<%@ page contentType="text/html;charset=UTF-8" language="java" %> 

<%@ include file="../layouts/taglib.jsp" %>

<script type="text/javascript">
	$(document).ready(function(){
		$(".triggerRemove").click(function(e){
			e.preventDefault();
			$("#modalRemove .removeBtn").attr("href",$(this).attr("href"));
			$("#modalRemove").modal();
		});
		$(".triggerEdit").click(function(e){
			e.preventDefault();
			$("#modalEdit .editBtn").attr("href",$(this).attr("href"));
			$("#modalEdit").modal();
		});
	});
</script>

<br>
<br>
<br>
<br>
<br>
<br>

<h1>${user.userName} </h1> 
<h2>Количество лекций: ${user.lections.size()}</h2>


<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th> ID лекции</th> 
			<th> Название</th>
			<th> Предмет</th>
			<th> Классификация</th>
			<th> Дата создания</th>
			<th> Действия</th>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach items="${user.lections}"  var="lection">
			<tr>
			  	<td>
					${lection.lectionId}
				</td> 
			  	<td>
					<a href="<spring:url value="/lections/${lection.lectionId}"/>">  ${lection.lectionName}     </a>
				</td> 
			  	
			  	<td>
					${lection.getSubject().getSubjectName()}
				</td> 
				<td>
					${lection.getSubject().getClassification().getSubjectClassificationName()}
				</td> 
			  	
			  	<td>
					${lection.lectionDate.getCreationDate()}
				</td>				
				<td>
					<a href="<spring:url value="/lections/remove/${lection.lectionId}"/>" class="btn btn-danger triggerRemove"> 
						remove
					</a> 
					<a href="<spring:url value="/lections/edit/${lection.lectionId}"/>" class="btn btn-primary triggerEdit"> 
						edit
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
        <h4 class="modal-title" id="myModalLabel">Remove lection</h4>
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
<div class="modal fade" id="modalEdit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">Remove lection</h4>
      </div>
      <div class="modal-body">
        Really edit?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">cancel</button>
        <a href="" class="btn btn-primary editBtn">edit</a>
      </div>
    </div>
  </div>
</div>