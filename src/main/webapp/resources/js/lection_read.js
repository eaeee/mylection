var markup;

$(document).ready(function() {
	render();
});

function render () {
    markup = $("#lection").html();
    var converter = new Showdown.converter();
    var htmltext = converter.makeHtml(markup);
    $("#lection").empty();
    $("#lection").append(htmltext);
    UpdateMath($("#lection").val());
}

$("#saveInCourseBtn").click(function() {
	console.log("TEST1");
	  saveInCourse();
});

function saveInCourse() {
	console.log("TEST");
    $.ajax({
        type: 'POST',
        url: saveURL+$('#course_select').find(":selected").val(),
        success: function (data, textStatus) { 
			alert("Лекция успешно сохранена в курсе " +data);
        } 
    });
	
}