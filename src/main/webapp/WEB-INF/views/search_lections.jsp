<%@ page contentType="text/html;charset=UTF-8" language="java" %> 

<%@ include file="../layouts/taglib.jsp" %>

<br>
<br>
<br>
<br>
<br>
<br>

Заполните форму поиска
<form class="form-horisontal" method="post" action='<spring:url value="/searchLectionForm"/>'>
	
	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">Слово содержащиеся в имени лекции</label>
		<div class="col-sm-10">
			<input class="form-control" name="word"/>
		</div>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">Слово содержащиеся в теле лекции</label>
		<div class="col-sm-10">
			<input class="form-control" name="wordInBody"/>
		</div>
	</div>
    <br>
	<br>
	
	 <div class="form-group">
			<label for="name" class="col-sm-2 control-label">Выберите предмет</label>
			<div class="col-sm-10">
					<select name="subejct">
						<option selected value="none">Пожалуйста выберите предемет</option>
						<c:forEach items="${subjects}" var="subject">
							<option value="${subject.getSubjectName()}">${subject.getSubjectName()}</option>
						</c:forEach>
					</select>
			</div>
	</div>
	<div class="form-group">
		<div class="col-sm-2">
		<input type="submit" value="search" class="btn btn-lg btn-primary"/>
		</div>
	</div>
	<br>
</form>

<c:if test="${lections !='null'}" >
	<table class="table table-bordered table-hover table-striped">
		<thead>
			<tr>
				<th> lection ID</th> 
				<th> lection name</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${lections}"  var="lection">
				<tr>
				  	<td>
						${lection.lectionId}
					</td> 
					<td>
						<a href="<spring:url value="/lections/${lection.lectionId}"/>"> 
							<c:out value="${lection.lectionName}"/>
						</a> 
					</td>			
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if> 
