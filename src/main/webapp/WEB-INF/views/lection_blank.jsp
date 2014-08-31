<%@ page contentType="text/html;charset=UTF-8" language="java" %> 

<%@ include file="../layouts/taglib.jsp" %>
<link rel="stylesheet" href="resources/css/lection_blank.css">
<div class="row">
    <div class="col-lg-2 sidebar">
      <ul class="testtest">
      <li><h5>Имя лекции</h5></li>
      <li> <b>Создано:</b></li>
      <li>11 мар 2014</li>
      <li><b>Последнее изменение:</b></li>
      <li>12 мар 2014</li>
      <li><b>Автор:</b></li>
      <li>Евстафьев Александр             sdfsdfs            sdfsdfs            sdfsdfs            sdfsdfs</li>
      <li><b>Классификация:</b></li>
      <li> Математика</li>
      <li><b>Предмет:</b></li>
      <li> Математический анализ</li>
      </ul>
    <div class="btn-group">
      <button class="btn" id="changeButton">Преобразовать</button>
      <button class="btn">Сохранить изменения</button>
      <button class="btn btn-danger">Удалить</button>
    </div>
    </div>
	  <div class="col-lg-10 main">
	    <div class="col-lg-5" id="markup-div">
	        <textarea id="lection-markup">
	        </textarea>
	    </div>
	    <div class="col-lg-5" well" id="lection-div">
	      <div id="lection">
	        <p>
	        When $a \ne 0$, there are two solutions to \(ax^2 + bx + c = 0\) and they are
	        $$x = {-b \pm \sqrt{b^2-4ac} \over 2a}.$$
	        </p>
	      </div>
	    </div>
	  </div> 
</div>