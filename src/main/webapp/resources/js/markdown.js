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


//валидатор
$(document).ready(function() {
    $('#tryitForm').bootstrapValidator({
        fields: {
            firstName: {
                validators: {
                    notEmpty: {
                        message: 'The first name is required and cannot be empty'
                    }
                }
            },
            lastName: {
                validators: {
                    notEmpty: {
                        message: 'The last name is required and cannot be empty'
                    }
                }
            },
            email: {
                validators: {
                    notEmpty: {
                        message: 'The email address is required'
                    },
                    emailAddress: {
                        message: 'The input is not a valid email address'
                    }
                }
            },
            gender: {
                validators: {
                    notEmpty: {
                        message: 'The gender is required'
                    }
                }
            }
        },
        submitHandler: function(validator, form, submitButton) {
            var fullName = [validator.getFieldElements('firstName').val(),
                            validator.getFieldElements('lastName').val()].join(' ');
            $('#helloModal')
                .find('.modal-title').html('Hello ' + fullName).end()
                .modal();
        }
    });
});