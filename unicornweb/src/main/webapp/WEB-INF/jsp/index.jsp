<html>

<head>
	<title>Welcome</title>
	<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
	
	<script src="webjars/jquery/2.2.4/jquery.min.js"></script>
	
	<script>
	
		function clickandsave(obj){
			
			var unicornId = obj.id;
			var unicornZone = $("#unicornid" + unicornId).val();
			
			$.ajax({
                url: 'http://localhost:8080/service/api/unicorn/changezone',
                type: 'post',
                contentType: 'application/json',
                data: '{ "id" : ' + unicornId + ', "zoneId" : ' + unicornZone +' }',
                success: function(response){
                	if(response == true) {
                		location.reload();
                	} else {
                		
                	}
                },
                error: function (xhr, ajaxOptions, thrownError) {
                   	var errorMsg = 'Ajax request failed: ' + xhr.responseText;
                   	alert(errorMsg);
                }
        	}); // end of ajax
			
	   	}
		
		$(document).ready(function(){
            //Perform Ajax request.
            $.ajax({
                url: 'http://localhost:8080/service/api/unicorn/list',
                type: 'get',
                success: function(data){
                	
                	var html = '';
                	
                	$.each( data, function( key, value ) {
                		
                	  html += '<tr>'	
                	  html += '<td>' + value.id + '</td>';
                	  html += '<td>' + value.name + '</td>';
                	  html += '<td>' + value.color + '</td>';
                	  html += '<td><input id="unicornid' + value.id + '" type="text" class="form-control" value=' + value.zoneId.id + '></input></td>';
                	  html += '<td>' + value.zoneId.name + '</td>';
                	  html += '<td><input onclick="clickandsave(this);" id="' + value.id + '" type="submit" class="btn btn-warning" /></td>';
                	  html += '</tr>';
               		});
                    
                    $('#tablecontent').html(html);
                },
                error: function (xhr, ajaxOptions, thrownError) {
                   	var errorMsg = 'Ajax request failed: ' + xhr.responseText;
                   	$('#content').html(errorMsg);
                }
        	}); // end of ajax

       	});
		
		$(document).ready(function(){
			
            //Perform Ajax request.
            $.ajax({
                url: 'http://localhost:8080/service/api/zone/list',
                type: 'get',
                success: function(data){
                	
                	var html = '';
                	$.each( data, function( key, value ) {
                		
                		html += '<tr>'	
                    	html += '<td>' + value.id + '</td>';
                    	html += '<td>' + value.name + '</td>';
                    	html += '<td>' + value.longtitude + '</td>';
                    	html += '<td>' + value.latitude + '</td>';
                    	html += '</tr>';
                	  
               		});
                	
                	$("#zonecontent").html(html);
                	

                },
                error: function (xhr, ajaxOptions, thrownError) {
                   	var errorMsg = 'Ajax request failed: ' + xhr.responseText;
                   	$('#content').html(errorMsg);
                }
        	}); // end of ajax
       	});

		
	</script>
	
</head>

<body>
	<div class="container">
		<table class="table table-striped">
			<caption>Unicorn Ranch</caption>
			<thead>
				<tr>
					<th>ID</th>
					<th>Unicorn Name</th>
					<th>Unicorn Color</th>
					<th>Zone Id</th>
					<th>Zone Name</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody id="tablecontent">
				<tr>
					<td>Todo 1</td>
					<td>10/12/2017</td>
					<td>No</td>
					<td>No</td>
					<td id="zoneId"><input type="text" class="number"></input></td>
					<td><a class="btn btn-warning" href="/delete-todo">Delete Todo</a></td>
				</tr>
			</tbody>
		</table>
		
		<table class="table table-striped">
			<caption>Zones Information</caption>
			<thead>
				<tr>
					<th>ID</th>
					<th>Zone Name</th>
					<th>Longitude</th>
					<th>Latitude</th>
				</tr>
			</thead>
			<tbody id="zonecontent">
				<tr>
					<td>Todo 1</td>
					<td>10/12/2017</td>
					<td>No</td>
					<td>No</td>
				</tr>
			</tbody>
		</table>
		
	</div>
	
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	
</body>
</html>