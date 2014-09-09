<%@ page contentType="text/html;charset=UTF-8" language="java" %> 

<%@ include file="../layouts/taglib.jsp" %>

<br>
<br>
<br>
<br>
<br>
<br>

Заполните форму поиска
<form class="form-horisontal" method="post" action='<spring:url value="/searchCourseForm"/>'>
	
	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">Слово содержащиеся в имени курса</label>
		<div class="col-sm-10">
			<input class="form-control" name="word"/>
		</div>
	</div>
	<br>
	<br>
	<div class="form-group">
		<div class="col-sm-2">
		<input type="submit" value="search" class="btn btn-lg btn-primary"/>
		</div>
	</div>
	<br>
</form>

<c:if test="${courses !='null'}" >
	<table class="table table-bordered table-hover table-striped">
		<thead>
			<tr>
				<th> course ID</th> 
				<th> course name</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${courses}"  var="course">
				<tr>
				  	<td>
						${course.courseId}
					</td> 
					<td>
						<a href="<spring:url value="/courses/${course.courseId}"/>"> 
							<c:out value="${course.courseName}"/>
						</a> 
					</td>			
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if> 
