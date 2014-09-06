$(document).ready(function() {
		$("#txt").click(function() { 
			var blob = new Blob([$("#lection-markup").val()], {type: "text/plain;charset=utf-8"});
			saveAs(blob, "Моя лекция.txt");
		});
});