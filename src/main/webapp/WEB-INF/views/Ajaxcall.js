var dis;
var tal;
var vill;
$(document).ready(function () {
$.ajax({
	type: "GET",
	url: "http://localhost:8075/dist",
	data: "json",
	contentType: "application/json",
	success: function (data) {
		let obj = $.parseJSON(data);
		$.each(obj, function (key, value) {
			$('#districtlist').append('<option value="' + value.districtcode + '">' + value.districtcode + '--' + value.districtname + '</option>');
		});
	},

	error: function (data) {
		$('#districtlist').append('<option>District Unavailable</option>');
	},
});

/*$('#districtlist').trigger("change");*/

$('#districtlist').change(function () {

	$('#taluklist').find('option').remove();
	$('#taluklist').append('<option>Select taluk</option>');
	$('#villagelist').find('option').remove();
	$('#villagelist').append('<option>Select village</option>');

	var distid1 = $('#districtlist').val();
	var inputValObj = {};
	alert(distid1);
	inputValObj.Discode = distid1;
	var inputVal = JSON.stringify(inputValObj);
	alert(inputVal);
	var data = inputVal.toString();
	alert(data);

	$.ajax({
		type: "GET",
		url: "http://localhost:8075/taluk?Discode=" + distid1,
		/*data: 1,*/
		contentType: "application/json",
		success: function (data) {
			let obj = $.parseJSON(data);
			$.each(obj, function (key, value) {
			$('#taluklist').append('<option value="' + value.talukcode + '">' + value.talukcode + '--' + value.talukname + '</option>');
			});
		},
		error: function (data) {
			$('#taluklist').append('<option>Taluk Unavailable</option>');
		},
	});
});
$('#taluklist').change(function () {
	$('#villagelist').find('option').remove();
	$('#villagelist').append('<option>Select village</option>');
	var distid1 = $('#districtlist').val();
	var talukid = $('#taluklist').val();
	alert(distid1);
	alert(talukid);
	var inputValObj = {};
	inputValObj.Discode = distid1;
	inputValObj.talucode = talukid;
	var inputVal = JSON.stringify(inputValObj);
	var data = inputVal.toString();
	$.ajax({
		type: "GET", //POST 
		url: "http://localhost:8075/village?Discode=" + distid1 + "&" + "Talukcode=" + talukid,
		contentType: "application/json",
		success: function (data) {
			let obj = $.parseJSON(data);
			$.each(obj, function (key, value) {
			$('#villagelist').append('<option value="' + value.villagecode + '">' + value.villagecode + '--' + value.villagename + '</option>');
			});
		},
		error: function (data) {
			$('#villagelist').append('<option>village Unavailable</option>');
		},
	});
});
});
