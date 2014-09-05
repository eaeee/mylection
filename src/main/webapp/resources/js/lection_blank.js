	$(document).ready(function(){
		$('#lectionMetaModal').modal('show');
		document.getElementById("subject_class_select").selectedIndex = "-1"; 
		$("#saveLectionMetaButton" ).click(function() {
			$('#lectionName').empty();
			$('#lectionSubjectClassification').empty();
			$('#lectionSubject').empty();
			
			$('#lectionName').append($('#lectionNameModal').val());
			$('#lectionSubjectClassification').append($("#subject_class_select option:selected").val());
			$('#lectionSubject').append($("#subject_select option:selected").val());
			$('#lectionMetaModal').modal('hide');
		});
		
	    $("#saveOnServerButton").click(function() {
	        sendLection();
	      });
	    var saveURL = '<spring:url value="/lections/save"/>'; 
	    var subjectsURL = '<spring:url value="/lections/getSubjects"/>'; 
	    function sendLection() {
	    	console.log(getLectionJSON());
	        $.ajax({
	            contentType: 'application/json',
	            data: getLectionJSON(),
	            dataType: 'json',
	            processData: false,
	            type: 'POST',
	            url: saveURL,
	            success: function (data, textStatus) { 
					alert("Лекция сохранена");
	            } 
	        });
	      };
	      $( "#subject_class_select" ).change(function() {
	    	  sendSubjectsRequest();
	    	});
	      function sendSubjectsRequest() {
	    	  $.getJSON(subjectsURL+"/"+$('#subject_class_select').find(":selected").text(),
	    			  function(data){
	    				  var optionsAsString = "";
	    				  for(var i = 0; i < data.length; i++) {
	    				      optionsAsString += "<option value='" + data[i] + "'>" + data[i] + "</option>";
	    				  }
	    				  $( '#subject_select' ).append( optionsAsString );
	    	 		 });  
	      }	      
	      function getLectionJSON() {	  
	    	  var lection = {};
	    	  lection.lectionName = $('#lectionName').html().toString();
	    	  lection.lectionCreationDate =  creationDate;
	    	  lection.lectionAuthor =  $('#lectionAuthor').html().toString();
	    	  lection.lectionBody = $('#lection-markup').val();
	    	  lection.subject =  $('#lectionSubject').html();
	    	  lection.classification= $('#lectionSubjectClassification').html();
	          var lectionJSON = JSON.stringify(lection);
	          console.log(lection);
	          console.log(lectionJSON);
	          return lectionJSON;
	        };
	    
	});