$(document).ready(function() {
		$("#txt").click(function() { 
			if ($("#lection-markup").length) {
				var blob = new Blob([$("#lection-markup").val()], {type: "text/plain;charset=utf-8"});
				saveAs(blob, "Моя лекция.txt");
			} else {
				var blob = new Blob([markup], {type: "text/plain;charset=utf-8"});
				saveAs(blob, $('#lectionName').html().toString()+".txt");
			}
		});
});