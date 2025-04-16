<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="module" src="Ajaxcall.js"></script> 
<script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>spring stuff</title>
</head>
<body>
	<h1 class="w-1/2 m-auto text-center text-xl">District, Taluk and Village</h1>
	<br>
	<div class="table-wrapper flex place-content-center">
		<table class="table table-auto ">
			<tr>
				<td class="font-semi-bold">District: </td>
			<td>
				<select id="districtlist" name="districtlist" required>
					<option disabled selected>Select District</option>
				</select>
				</td>
			</tr>
			<tr>
				<td class="font-semi-bold">Taluk: </td>
				<td>
				<select id="taluklist" name="taluklist" required>
					<option disabled>Select Taluk</option>
				</select>
				</td>
			</tr>

			<tr>
				<td class="font-semi-bold">Village: </td>
				<td>
				<select id="villagelist" name="villagelist" required>
					<option disabled>Select Village</option>
				</select>
				</td>
			</tr>
		</table>
	</div>
	<div class="input-wrapper">
		<h1 class="text-xl">Create New District</h1>
		<p class="font-medium">Enter new district</p>
		<input type="text" id="distname" name="distname" placeholder="Enter district name" required>
		<input type="text" id="distcode" name="distcode" placeholder="Enter district code" required>
		<button class="button border" id="submit" name="submit">store new district</button>
	</div>
	<br>
	<div class="update-wrapper">
		<h1 class="text-xl">Update District</h1>
		<p class="font-medium">Enter new district <bold>name</bold></p>
		<input type="text" id="newdistname" name="newdistname" placeholder="Enter new district name" required>
		<table class="table table-auto ">
			<tr>
				<td class="font-semi-bold">District Code: </td>
				<td>
					<select id="updt-districtlist" name="updt-districtlist" required>
						<option disabled selected>Select District</option>
					</select>
				</td>
			</tr>
		</table>
		<button class="button border" id="update" name="update">update district name</button>
	</div>

</body>
</html>
