
$("#courseFollow").click(function() {
	  followCourse();
});

$("#courseUnfollow").click(function() {
	  unfollowCourse();
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

function unfollowCourse() {
    $.ajax({
        type: 'POST',
        url: unfollowURL,
        success: function (data, textStatus) { 
			alert("Вы успшешно отписаны от курса " +data);
        } 
    });
	
}




