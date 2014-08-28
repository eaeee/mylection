<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>MyLections</title>

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
		
		<link href="resources/css/non-responsive.css" rel="stylesheet">
	    <link href="resources/css/lections.css" rel="stylesheet">
	
		<script src="resources/js/showdown.js"></script>
		<script src="resources/js/markdown.js"></script>
	
	</head>

<body>

	<!--modal windows -->
	<div class="contanier" id="content">
		<div class="modal fade" id="modal-signin-or-register">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title">Доступ к системе</h4>
					</div>
					<div class="modal-body">
						<ul id="tabs" class="nav nav-tabs" data-tabs="tabs">
							<li class="active"><a href="#signin" data-toggle="tab">Войти</a></li>
							<li><a href="#register" data-toggle="tab">Зарегистрироваться</a></li>
						</ul>
						<div id="my-tab-content" class="tab-content">
							<div class="tab-pane active" id="signin">
								<h5>Пожалуйста заполните форму</h5>
								<form>
								    <div class="form-group">
								        <input type="text" class="form-control" name="username" placeholder="Username" />
								    </div>
								    <div class="form-group">
								        <input type="text" class="form-control" name="email" placeholder="Email address" />
								    </div>
								</form>
							</div>
							<div class="tab-pane" id="register">
								<h5>Пожалуйста заполните форму</h5>
								<form>
									<div class="form-group">
										<input type="text" class="form-control" name="username" placeholder="Username" />
									</div>
									<div class="form-group">
										<input type="text" class="form-control" name="email" placeholder="Email address" />
									</div>
									<div class="form-group">
										<input type="text" class="form-control" name="email" placeholder="Email address" />
									</div>									
								</form>           
							</div>
						</div>
					</div>
				</div><!-- /.modal-content -->
			</div><!-- /.modal-dialog -->
		</div><!-- /.modal -->



			<!--navbar -->
			<div class="navbar navbar-default navbar-fixed-top" role="navigation">
				<div class="container">
					<div class="navbar-header">
						<a class="navbar-brand well" href="#">MyLections</a>
					</div>
					<div class="navbar-collapse collapse">
						 <ul class="nav navbar-nav navbar-left">
						<a href="" >Выйти из системы</a>
						<button type="button" class="btn btn-default" id="signin-or-register" style="display:none;"></button>
						</ul>
						<div class="nav navbar-nav navbar-right">
									 Скачать в различных форматах:
								<div class="btn-group">
									<button type="button" class="btn btn-default">PDF</button>
									<button type="button" class="btn btn-default">HTML</button>
									<button type="button" class="btn btn-default">TXT</button>
								</div>
						</div>
					</div><!--/.nav-collapse -->
				</div>
			</div>
			<!--subnavbar -->
			<div class="subnav subnav-fixed">
				<div class="btn-group nav nav-pills" data-toggle="buttons-checkbox" id="subnav">
					<button class="btn" id="btn-info">Информация</button>
					<button class="btn" id="btn-markup">Разметка</button>
					<button class="btn" id="btn-lection">Итоговый вид</button>
				</div>
			</div>
			<!--main part -->
			<div class="contanier" id="main-part">
				<div class="row" id="main-part-row">
					<div class="col-md-2 well" id="info-div">
						<div id="sidebar" class="nav nav-stacked affix">
							<h5>Имя лекции</h5>
							<ul class="nav nav-pills nav-stacked">
									<li> <b>Создано:</b></li>
									<li>11 мар 2014</li>
									<li><b>Последнее изменение:</b></li>
									<li>12 мар 2014</li>
									<li><b>Автор:</b></li>
									<li>Евстафьев Александр</li>
									<li><b>Классификация:</b></li>
									<li> Математика</li>
									<li><b>Предмет:</b></li>
									<li> Математический анализ</li>
									<li><b>Редактирование:</b></li>
									<li>Запрещено</li>
									<li>      </li>
									<li>      </li>
									<li>      </li>
									<li>      </li>
							</ul>
							<div class="btn-group">
								<button class="btn  btn-success">Создать лекцию</button>
								<button class="btn" id="changeButton">Преобразовать</button>
								<button class="btn">Сохранить изменения</button>
								<button class="btn btn-danger">Удалить</button>
							</div>
						</div><!-- /#sidebar -->
							</div>
					<div class="col-md-5" id="markup-div">
						<textarea cols="85" rows="27" id="lection-markup">
							
						</textarea>
					</div>
					<div class="col-md-5 well" id="lection-div">
						<div id="lection">
							<p>
							When $a \ne 0$, there are two solutions to \(ax^2 + bx + c = 0\) and they are
							$$x = {-b \pm \sqrt{b^2-4ac} \over 2a}.$$
							</p>
						</div>
					</div>
				</div>
			</div>
	</div>
</body>
</html>