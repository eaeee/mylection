<%@ page contentType="text/html;charset=UTF-8" language="java" %> 

<%@ include file="../layouts/taglib.jsp" %>
<%@ include file="../layouts/lection-resourses.jsp" %>
<%@page import="java.io.*, java.util.Date, java.util.Enumeration,java.text.DateFormat, java.text.SimpleDateFormat" %> 
<%DateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy");%>
<div class="row">
    <div class="col-lg-2 sidebar">
      <ul class="lectionMeta">
      
      <li><b>Имя лекции</b></li>
      <p id="lectionName">${lection.getLectionName()}</p>
      
      <li> <b>Дата создания:</b></li>
      <p id="lectionCreationDate">${lection.getLectionDate().getCreationDate()}</p>
      
      <li><b>Последнее изменение:</b></li>
      <p id="lectionModifiedDate">${lection.getLectionDate().getModifiedDate()}</p>
      
      <li><b>Автор:</b></li>
      <p id="lectionAuthor">${lection.getAuthor().getUserName() }</p>
      
      <li><b>Классификация:</b></li>
      <p id="lectionSubjectClassification">${lection.getSubject().getSubjectName() }</p>
      
      <li><b>Предмет:</b></li>
      <p id="lectionSubject">${lection.getSubject().getClassification().getSubjectClassificationName()}</p>
      
      </ul>
    <div class="btn-group">
      <button class="btn btn-primary" data-toggle="modal" data-target="#lectionMetaModal">Изменить данные</button>
      <button class="btn btn-danger" id="saveOnServerButton">Сохранить на сервере</button>
    	
    </div>
    </div>
	  <div class="col-lg-10 main">
	    <div class="col-lg-5" id="markup-div">
	        <textarea id="lection-markup">
	        	${lection.getLectionBody()}
	        </textarea>
	    </div>
	    <div class="col-lg-5" well" id="lection-div">
	      <div id="lection">
	        <p>
	        	
	        </p>
	      </div>
	    </div>
	  </div> 
</div>

<!-- Modal -->
<div class="modal fade" id="lectionMetaModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      
      <div class="modal-body">
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label"> Имя лекции:</label>
				<div class="col-sm-10">
					<input type="text" id="lectionNameModal">
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
	var subjectsURL = '<spring:url value="/lections/getSubjects"/>';
	var updateURL = '<spring:url value="/lections/update/${lection.getLectionId()}"/>'; 
	var creationDate = ${lection.getLectionDate().getCreationDate().getTime()};
</script>
<script src='<spring:url value="/resources/js/lection_edit.js"/>'></script>