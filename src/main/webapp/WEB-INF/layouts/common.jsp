<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html lang="en">
<head>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>


  <meta charset="UTF-8">
  <title> <tiles:getAsString name="title"/></title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	
   <script src="http://cdn.mathjax.org/mathjax/latest/MathJax.js?config=TeX-AMS-MML_HTMLorMML"></script>
    <script type="text/x-mathjax-config">
      MathJax.Hub.Config({
        tex2jax: {inlineMath: [["$","$"],["\\(","\\)"]]}
      });
    </script>
    
  
    <script src="resources/js/showdown.js"></script>
    <script src="resources/js/markdown.js"></script>
</head>

<body>
<tilesx:useAttribute name="current"/>
 <div class="container">
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
              <li class="${current == 'index' ? 'active':''}"><a href='<spring:url value="/"/>'>Home</a></li>
			  <li class="${current == 'login' ? 'active':''}"><a href='<spring:url value="/"/>'>Login</a></li>
              <li class="${current == 'registration' ? 'active':''}"><a href='<spring:url value="/"/>'>Registration</a></li>
             <li class="${current == 'users' ? 'active':''}"><a href='<spring:url value="/users"/>'>Users</a></li>
            </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Поск по лекциям">
          </form>
            
            <ul class="nav navbar-nav navbar-right">
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Скачать в различных форматах <span class="caret"></span></a>
                <ul class="dropdown-menu" role="menu">
                  <li><a href="#">PDF</a></li>
                  <li><a href="#">HTML</a></li>
                  <li><a href="#">TXT</a></li>
                  <li><a href="#">MARKDOWN</a></li>
                </ul>
              </li>
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