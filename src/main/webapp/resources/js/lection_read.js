var markup;  
function render () {
      markup = $("#lection").html();
      var converter = new Showdown.converter();
      var htmltext = converter.makeHtml(markup);
      $("#lection").empty();
      $("#lection").append(htmltext);
      UpdateMath($("#lection").val());
  }
  
$(document).ready(function() {
	render();
});