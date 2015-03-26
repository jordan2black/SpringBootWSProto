<!DOCTYPE HTML>
<#setting number_format="0">
<html>
<head>
<title>user</title>
</head>
<body>
	<div>User page</div>
	
	<div>
		<table>
			<#list model["User"] as user>
			<tr>
				<td>${user.id}</td>
				<td>${user.firstname}</td>
				<td>${user.lastname}</td>
				<td>${user.status}</td>
				<td>${user.type}</td>
			</tr>
			</#list>
		</table>
	</div> 
</body>
</html>