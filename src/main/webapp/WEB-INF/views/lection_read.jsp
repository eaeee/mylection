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
    </div>
	  <div class="col-lg-10 main">
	    <div class="col-lg-10" well" id="lection-div" style="width:100%">
	      <div id="lection">
				${lection.getLectionBody()}
	      </div>
	    </div>
	  </div> 
</div>
<script src='<spring:url value="/resources/js/lection_read.js"/>'></script>



