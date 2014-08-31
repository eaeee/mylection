<style>
	body {
	  padding-top: 50px;
	  position: fixed;
	  width: 100%;
	}
	html, body, .container-fluid, .row, .main {
    height: 100%;
	}
	  @media (min-width: 768px) {
    .sidebar {
      position: fixed;
      top: 51px;
      bottom: 0;
      left: 0;
      z-index: 1000;
      display: block;
      padding: 20px;
      overflow-x: hidden;
      overflow-y: auto; /* Scrollable contents if viewport is shorter than content. */
      background-color: #f5f5f5;
      border-right: 1px solid #eee;
    }
  }
  
  
    /*
   * Main content
   */
  
  .main {
    position: fixed;
    margin-top: 5px;
    margin-right: 0px;
    margin-left: 230px;
  }
  @media (min-width: 768px) {
    .main {
      padding-right: 0px;
      padding-left: 0px;
    }
  }
  .main .page-header {
    margin-top: 0;
  }
  .row {
    position: fixed;
    width: 100%;
    height: 100%;
  }
  textarea {
    border:1px solid #999999;
    width:100%;
    height: 100%;
    margin:5px 0;
    padding:3px;
}
#markup-div {
	height:85%;
}
#lection-div {
	width:50%;
}
</style>

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