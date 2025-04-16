export function replaceDistInList(newDist, oldDistList) {
	$('#districtlist').find('option[value="' + newDist.code + '"]').remove();
	
	$('#districtlist').append('<option value="' + newDist.code + '">' + newDist.code + '   ' + newDist.name + '</option>');
}