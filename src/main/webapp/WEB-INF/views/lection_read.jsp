<%@ page contentType="text/html;charset=UTF-8" language="java" %> 

<%@ include file="../layouts/taglib.jsp" %>
<%@ include file="../layouts/lection-resourses.jsp" %>
<%@page import="java.io.*, java.util.Date, java.util.Enumeration,java.text.DateFormat, java.text.SimpleDateFormat" %> 
<%DateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy");%>
<div class="row">
    <div class="col-lg-2 sidebar">
      <ul class="lectionMeta">
      
      <li><b>Имя лекции</b></li>
      <p id="lectionName">>${lection.getLectionName()}</p>
      
      <li> <b>Дата создания:</b></li>
      <p id="lectionCreationDate">${lection.getLectionDate().getCreationDate()}</p>
      
      <li><b>Последнее изменение:</b></li>
      <p id="lectionModifiedDate">${lection.getLectionDate().getModifiedDate()}</p>
      
      <li><b>Автор:</b></li>
      <p id="lectionAuthor">${lection.getAuthor().getUserName() }</p>
      
      <li><b>Классификация:</b></li>
      <p id="lectionSubjectClassification"></p>
      
      <li><b>Предмет:</b></li>
      <p id="lectionSubject">Математический анализ</p>
      
      </ul>
    <div class="btn-group">
      <a href='<spring:url value="/lections/edit/${lection.getLectionId()}"/>'><button class="btn btn-primary" data-toggle="modal" >редактировать</button></a>

    	
    </div>
    </div>
	  <div class="col-lg-10 main">
	    <div class="col-lg-10" well" id="lection-div" style="width:100%">
	      <div id="lection">
				${lection.getLectionBody()}
	      </div>
	    </div>
	  </div> 
</div>
	<script>
		  function render () {
		      var markup = $("#lection").html();
		      var converter = new Showdown.converter();
		      var htmltext = converter.makeHtml(markup);
		      $("#lection").empty();
		      $("#lection").append(htmltext);
		      UpdateMath($("#lection").val());
		  }
		  
		$(document).ready(function() {
			render();
		});
	</script>



