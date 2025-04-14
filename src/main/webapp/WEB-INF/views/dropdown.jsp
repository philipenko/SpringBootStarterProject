<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<script type="text/javascript" src="jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="Ajaxcall.js"></script> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
</head>
<body>
	<table border="1" cellpadding="10px" cellspacing="5px">
		<tr>
			<td>District: </td>
			<td>
			<select id="districtlist" name="districtlist" required>
				<option disabled selected>Select District</option>
			</select>
			</td>
		</tr>
		<tr>
			<td>Taluk: </td>
			<td>
			<select id="taluklist" name="taluklist" required>
				<option disabled>Select Taluk</option>
			</select>
			</td>
		</tr>
		
		<tr>
			<td>Village: </td>
			<td>
			<select id="villagelist" name="villagelist" required>
				<option disabled>Select Village</option>
			</select>
			</td>
		</tr>
	</table>
</body>
</html>
