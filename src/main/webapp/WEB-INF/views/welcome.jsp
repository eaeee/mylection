<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@ include file="../layouts/taglib.jsp" %>
<br>
<br>
<br>
<br>
<br>
<br>
<br>

<div>


<h1>Добро пожаловать на проект Mylection.</h1>

<p>Вы можете зарегистрироваться, войти под своим именем пользователя, просто просмотреть на этой странице список последних лекций</p>



<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th> ID лекции</th> 
			<th> Название</th>
			<th> Предмет</th>
			<th> Классификация</th>
			<th> Дата изменения</th>
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
					${lection.lectionDate.getModifiedDate()}
				</td>	
			  	<td>
					${lection.getAuthor().getUserName()}
				</td>				
						
			
			</tr>
		</c:forEach>
	</tbody>
</table>

</div>	
