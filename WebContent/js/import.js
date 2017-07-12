$(document).ready(SetUp);

function SetUp() {
	$("button").click(getCompanies);

	$("#services").change( function(){
			getCitiesByServiceId($(this).val());
	});

}


function getCompanies() {
	var cityId = $("#cities").val();
	var serviceId = $("#services").val();
	
	var url = "http://localhost:8080/VirtualConcierge/home/list?serviceId="+serviceId+"&cityId="+cityId;
	//displayList(ajaxCaller(url)); synchronicznie
	ajaxGet(url, displayList);// wywołaj ajaxem urla, wez odpowiedz z
									// ervera i wrzuc do funkcji displayList
}

function displayList(result) {// result = homeList.jsp
	// zamiana zawartosci diva
	$('#lista').html(result);
}


///////////////////////////////
function getCitiesByServiceId(id) {
	var url = "http://localhost:8080/VirtualConcierge/home/getCities?serviceId="+id;
	//displayList(ajaxCaller(url)); synchronicznie

	ajaxGet(url, displayCities);// wywołaj ajaxem urla, wez odpowiedz z
									// ervera i wrzuc do funkcji displayList
}

function displayCities(result) {// result = homeList.jsp
	 $('#cities').empty();
	 $('#cities').append($('<option disabled selected>').text("Select City").attr('value', ""));
	 $.each(result, function(i, city) {
		 $('#cities').append($('<option>').text(city.name).attr('value', city.id));
	 });
}

function ajaxGet(url, inputFunction) {
	$.ajax({
		url : url,
		type : 'GET'
	}).done(inputFunction);
}
