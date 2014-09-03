(function () {
  var QUEUE = MathJax.Hub.queue;  // shorthand for the queue
  var math = null;                // the element jax for the math output.

  QUEUE.Push(function () {
    math = MathJax.Hub.getAllJax("#wmd-preview")[0];
  });

  window.UpdateMath = function (TeX) {
    QUEUE.Push(["Text",math,"\\displaystyle{"+TeX+"}"]);
  }
})();

$(document).ready(function() {
  $('#convertButton').bind('click', htmlConvert);
	  function htmlConvert () {
	      var markup = $("#lection-markup").val();
	      var converter = new Showdown.converter();
	      var htmltext = converter.makeHtml(markup);
	      $("#lection").empty();
	      $("#lection").append(htmltext);
	      UpdateMath($("#lection").val());
	  }
  $(document).bind('keydown','enter',htmlConvert);
});