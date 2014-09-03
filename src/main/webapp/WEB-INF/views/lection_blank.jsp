<%@ page contentType="text/html;charset=UTF-8" language="java" %> 

<%@ include file="../layouts/taglib.jsp" %>
<%@ include file="../layouts/lection-resourses.jsp" %>
<%@page import="java.io.*, java.util.Date, java.util.Enumeration,java.text.DateFormat, java.text.SimpleDateFormat" %> 
<%DateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy");%>
<%long creationDate = new Date().getTime(); %>
<div class="row">
    <div class="col-lg-2 sidebar">
      <ul class="lectionMeta">
      
      <li><b>Имя лекции</b></li>
      <p id="lectionName"></p>
      
      <li> <b>Дата создания:</b></li>
      <p id="lectionCreationDate"><%=new Date(creationDate)%></p>
      
      <li><b>Последнее изменение:</b></li>
      <p id="lectionModifiedDate"><%=new Date(creationDate)%></p>
      
      <li><b>Автор:</b></li>
      <p id="lectionAuthor"><security:authentication property="name" /> </p>
      
      <li><b>Классификация:</b></li>
      <p id="lectionSubjectClassification">Математика</p>
      
      <li><b>Предмет:</b></li>
      <p id="lectionSubject">Математический анализ</p>
      
      </ul>
    <div class="btn-group">
      <button class="btn" id="convertButton">Преобразовать</button>
      <button class="btn btn-primary" data-toggle="modal" data-target="#lectionMetaModal">Изменить данные</button>
      <button class="btn btn-danger" id="saveOnServerButton">Сохранить на сервере</button>
    	
    </div>
    </div>
	  <div class="col-lg-10 main">
	    <div class="col-lg-5" id="markup-div">
	        <textarea id="lection-markup">
	        </textarea>
	    </div>
	    <div class="col-lg-5" well" id="lection-div">
	      <div id="lection">
	        <p>
	        When $a \ne 0$, there are two solutions to \(ax^2 + bx + c = 0\) and they are
	        $$x = {-b \pm \sqrt{b^2-4ac} \over 2a}.$$
	        </p>
	      </div>
	    </div>
	  </div> 
</div>

<!-- Modal -->
<div class="modal fade" id="lectionMetaModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog row">
    <div class="modal-content">
      
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      
      <div class="modal-body">
				<div class="form-group">
					<label for="name" class="col-sm-2 control-label"> Имя лекции:</label>				
					<div class="">
						<input type="text" id="lectionNameModal">
					</div>
				</div>	
				
				<div class="form-group">
					<label for="name" class="control-label"> Классификация:</label>						
					<div class="">
						<select class="form-control" id="subject_class_select">
							<c:forEach items="${classifications}"  var="classification">
							    <option value="${classification.getSubjectClassificationName()}">${classification.getSubjectClassificationName()}</option>
							</c:forEach>
						</select>
					</div>		
				</div>				
				
				
				<div class="form-group">
					<label for="name" class="control-label"> Предмет:</label>	
					<div class="">
						<select class="form-control" id="subject_select">
							<c:forEach items="${subjects}"  var="subject">
							    <option value="${subject.getSubjectName()}">${subject.getSubjectName()}</option>
							</c:forEach>
						</select>
					</div>		
				</div>
																	
      </div>
      
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" id="saveLectionMetaButton" >Save changes</button>
      </div>
      
    </div>
  </div>
</div>

<script>
	$(document).ready(function(){
		$('#lectionMetaModal').modal('show');
		
		$("#saveLectionMetaButton" ).click(function() {
			$('#lectionName').empty();
			$('#lectionSubjectClassification').empty();
			$('#lectionSubject').empty();
			
			$('#lectionName').append($('#lectionNameModal').val());
			$('#lectionSubjectClassification').append($("#subject_class_select option:selected").val());
			$('#lectionSubject').append($("#subject_select option:selected").val());
			$('#lectionMetaModal').modal('hide');
		});
		
	    $("#saveOnServerButton").click(function() {
	        sendLection();
	      });
	    
	    var saveURL = '<spring:url value="/lections/save"/>'; 
	    
	    function sendLection() {
	    	console.log(getLectionJSON());
	        $.ajax({
	            contentType: 'application/json',
	            data: getLectionJSON(),
	            dataType: 'json',
	            processData: false,
	            type: 'POST',
	            url: saveURL
	        });
	      };
	      
	      function getLectionJSON() {	  
	    	  var lection = {};
	    	  lection.lectionName = $('#lectionName').html().toString();
	    	  lection.lectionCreationDate =  $('#lectionCreationDate').html().toString();
	    	  lection.lectionAuthor =  $('#lectionAuthor').html().toString();
	    	  lection.lectionBody = $('#lection-markup').val();	 
	    	  console.log(lection);
	          var lectionJSON = JSON.stringify(lection);
	          console.log(lectionJSON);
	          
	          return lectionJSON;
	        };
	    
	});
</script>

