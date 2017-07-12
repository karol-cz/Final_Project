$(document).ready(SetUp);

function SetUp() {

	$("#date").change( function(){
			getHours($(this).val());
	});

}


function getHours(date) {
	var id = $("#company\\.id").val();
	$("#date").val(date);
	var url = "http://localhost:8080/VirtualConcierge/appointments/retriveHour?date="+date+"&companyId="+id;
	ajaxGet(url, displayList);
	console.log(id);
	
}

function displayList(result) {// result = homeList.jsp
	// zamiana zawartosci diva
	$('#hours').html(result);
}

function ajaxGet(url, inputFunction) {
	$.ajax({
		url : url,
		type : 'GET'
	}).done(inputFunction);
}
