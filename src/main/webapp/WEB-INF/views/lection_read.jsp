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
      <p id="lectionSubjectClassification">${lection.getSubject().getClassification().getSubjectClassificationName()}</p>
      
      <li><b>Предмет:</b></li>
      <p id="lectionSubject">Математический анализ</p>
      
      </ul>
      <security:authentication var="user" property="principal" />
     <security:authorize access="hasRole('ROLE_ADMIN') or '${user.getUsername()}'=='${lection.getAuthor().getUserName()}'">
    <div class="btn-group">
      <a href='<spring:url value="/lections/edit/${lection.getLectionId()}"/>'><button class="btn btn-primary" data-toggle="modal" >редактировать</button></a>
      
    </div>
    </security:authorize>
    <button class="btn btn-primary" data-target="#modalCourse"  data-toggle="modal" >Добавить в курс</button>
    </div>
	  <div class="col-lg-10 main">
	    <div class="col-lg-10" well" id="lection-div" style="width:100%">
	      <div id="lection">
				${lection.getLectionBody()}
	      </div>
	    </div>
	  </div> 
</div>
<!-- Modal -->
<div class="modal fade" id="modalCourse" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">Добавить в курс</h4>
      </div>
      
      <div class="modal-body">
			<div class="form-group">
					<label for="name" class="control-label"> Курс:</label>	
					<div class="">
						<select class="form-control" id="course_select">
							<c:forEach items="${courses}"  var="course">
								<option value="${course.getCourseId()}">${course.getCourseName()}</option>
							</c:forEach>
						</select>
					</div>		
				</div>        
      </div>
      
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" id="saveInCourseBtn">Save</button>
      </div>
      
    </div>
  </div>
</div>
<script>
var saveURL = '<spring:url value="/lections/saveincourse"/>'+'?lectionId=${lection.getLectionId()}&courseId=';
console.log(saveURL);
</script>
<script src='<spring:url value="/resources/js/lection_read.js"/>'></script>