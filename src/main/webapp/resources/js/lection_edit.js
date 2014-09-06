$(document).ready(function(){		
	$("#saveLectionMetaButton" ).click(function() {
		$('#lectionName').empty();
		$('#lectionName').append($('#lectionNameModal').val());
		$('#lectionMetaModal').modal('hide');
	});
	
    $("#saveOnServerButton").click(function() {
        sendLection();
      });
        
    function sendLection() {
    	console.log(getLectionJSON());
        $.ajax({
            contentType: 'application/json',
            data: getLectionJSON(),
            dataType: 'json',
            processData: false,
            type: 'POST',
            url: updateURL,
            success: function (data, textStatus) { 
            	lectionId = data;
				alert("Лекция id= "+lectionId + "успешно обновлена!");
            } 
        });
      };
      
      function getLectionJSON() {	  
    	  var lection = {};
    	  lection.lectionName = $('#lectionName').html().toString();
    	  lection.lectionCreationDate =  creationDate;
    	  lection.lectionAuthor =  $('#lectionAuthor').html().toString();
    	  lection.lectionBody = $('#lection-markup').val();	 
    	  console.log(lection);
          var lectionJSON = JSON.stringify(lection);
          console.log(lectionJSON);
          
          return lectionJSON;
        };
    
});