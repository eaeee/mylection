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
  $("#btn-info").button('toggle');
  $("#btn-markup").button('toggle');
  $("#btn-lection").button('toggle');
  $('#changeButton').bind('click', htmlConvert);
  $('#signin-or-register').bind('click', signinOrRegister);

  function htmlConvert () {
      var text = $("#lection-markup").val();
      var converter = new Showdown.converter();
      var htmltext = converter.makeHtml(text);
      $("#lection").empty();
      $("#lection").append(htmltext);
      UpdateMath($("#lection-markup").val());
      alert("adfasd");
  }
  $(document).bind('keydown','enter',htmlConvert);

  function signinOrRegister () {
      $('#modal-signin-or-register').modal();
  }

});