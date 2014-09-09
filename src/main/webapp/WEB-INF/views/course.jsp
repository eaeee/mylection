<%@ page contentType="text/html;charset=UTF-8" language="java" %> 

<%@ include file="../layouts/taglib.jsp" %>

<br>
<br>
<br>
<br>
<br>
<h1>Курс:${course.getCourseName()}</h1>
<h2>Количество лекций в курсе: ${lections.size()}</h2>
<h2>Автор: ${course.getCourseAuthor().getUserName()}</h2>
 <button class="btn btn-primary" data-target="#courseFollow" >Подписаться</button>
<c:if test="${lections !='null'}" >
	<table class="table table-bordered table-hover table-striped">
		<thead>
			<tr>
				<th> ID лекции</th> 
				<th> Название</th>
				<th> Предмет</th>
				<th> Классификация</th>
				<th> Дата создания</th>
				<th> Автор</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${lections}"  var="lection">
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
						${lection.getAuthor().getUserName()}
					</td>				
			
				
				</tr>
			</c:forEach>
		</tbody>
	</table>

</c:if> 
<script>
var followURL = '<spring:url value="/courses/follow"/>'+'?courseId=${course.getCourseId()}';
</script>
<script src='<spring:url value="/resources/js/course.js"/>'></script>