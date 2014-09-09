
$("#courseFollow").click(function() {
	  followCourse();
});

function followCourse() {
    $.ajax({
        type: 'POST',
        url: followURL,
        success: function (data, textStatus) { 
			alert("Вы успшешно подписаны на курс " +data);
        } 
    });
	
}