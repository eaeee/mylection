<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html lang="en">
<head>
<%@ include file="../layouts/taglib.jsp" %>


  <meta charset="UTF-8">
  <title> <tiles:getAsString name="title"/></title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	
    <script src=" http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/jquery.validate.min.js"></script>
    <script src="http://cdn.jsdelivr.net/filesaver.js/0.2/FileSaver.min.js"></script>
    <% 
	    String down="<span class='glyphicon glyphicon-arrow-down'></span>";  				
		String ic="<span class='glyphicon glyphicon-user'></span>";
		String ic_auth = "<span class='glyphicon glyphicon-log-in'></span>"; 
		String ic_home = "<span class='glyphicon glyphicon-home'></span>";
		String ic_reg = "<span class='glyphicon glyphicon-registration-mark'></span>";
		String ic_search="<span class='glyphicon glyphicon-search'></span>";
		String ic_dwnld="<span class='glyphicon glyphicon-download'></span>";
		String ic_warn="<span class='glyphicon glyphicon-warning-sign'></span>";
		String ic_acc = "<span class='glyphicon glyphicon-list-alt'>";
	%>
	<security:authorize access="isAuthenticated()">
		<% ic_auth = "<span class='glyphicon glyphicon-log-out'></span>";%>
	</security:authorize> 
	
	<security:authorize access="hasRole('ROLE_ADMIN')">
		 <%	ic="<span class='glyphicon glyphicon-star'></span>";%>
	</security:authorize>  
	
</head>
<body>
<tilesx:useAttribute name="current"/>
 <div class="container-fluid">
  <!-- Static navbar -->
      <div class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href='<spring:url value="/"/>'>MyLection</a>
          </div>
          <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li class="${current == 'index' ? 'active':''}"><a href='<spring:url value="/"/>'><%=ic_home%> Home</a></li>
              
              <li class="${current == 'register' ? 'active':''}"><a href='<spring:url value="/register"/>'><%=ic_reg%> Registration</a></li>
                            
              <security:authorize access="! isAuthenticated()">
              	<li class="${current == 'login' ? 'active':''}"><a href='<spring:url value="/login"/>'><%=ic_auth%> Login</a></li>
              </security:authorize>
              
              <security:authorize access="isAuthenticated()">
              	 <li><a href='<spring:url value="/logout"/>'><%=ic_auth %> Logout</a></li>
              
              </security:authorize>
              
             <security:authorize access="isAuthenticated()">
              	 <li class="${current == 'account' ? 'active':''}"><a href='<spring:url value="/account"/>'><%=ic%> My account</a></li>              
              </security:authorize>
              
              <security:authorize access="isAuthenticated()">
              	 <li><a href='<spring:url value="/addlection"/>'><span class="glyphicon glyphicon-plus"></span> Create lection</a></li>
              </security:authorize>
                      

                
               
              
             <security:authorize access="hasRole('ROLE_ADMIN')">
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><%=ic_warn%> For admin<span class="caret"></span></a>
                <ul class="dropdown-menu ${current == 'users'||'all_lections'||'subjects' ? 'active':''}" role="menu">
					<li class="${current == 'users' ? 'active':''}"><a href='<spring:url value="/users"/>'> <%=down%> All Users</a></li>
	              	<li class="${current == 'all_lections' ? 'active':''}"><a href='<spring:url value="/all_lections"/>'><%=down%>All lections</a></li>
	              	<li class="${current == 'subjects' ? 'active':''}"><a href='<spring:url value="/subjects"/>'><%=down%> All subjects</a></li>
	              	<li class="${current == 'classifications' ? 'active':''}"><a href='<spring:url value="/classifications"/>'><%=down%> All classification</a></li>
                </ul>
              </li>
            </security:authorize>
            
            </ul>
            
            <ul class="nav navbar-nav navbar-right">
            <c:if test="${
            			  (current == 'lection_blank')||
            			  (current =='lection_edit')||
            			  (current =='lection_read')
            }">
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><%=ic_dwnld%>Скачать<span class="caret"></span></a>
                <ul class="dropdown-menu" role="menu">
                  <li id="html"><a href="#">HTML</a></li>
                  <li id="txt"><a href="#">TXT</a></li>
                </ul>
              </li>
			<script src='<spring:url value="/resources/js/lection_download.js"/>'></script>
            
            </c:if>
              
            </ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </div>
 	<tiles:insertAttribute name="body"/>
 </div>	
 	<br>
 	<tiles:insertAttribute name="footer"/>
</body>
</html>