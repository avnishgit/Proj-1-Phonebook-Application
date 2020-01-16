<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Info</title>
</head>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<body>

	<form:form action="contactInfo" method="POST"
		modelAttribute="contactFormBean">
		<div class="container" style="height: 100% ">
			<div class="card-header" style="background-color: orange;">
				<h2>Contact Information</h2>
				<h3 align="center" style="color: green;">${successMsg}</h3>
				<h3 align="center" style="color: red;">${failMsg}</h3>

							<h3 align="center" style="color: red;">${dMsg}</h3>
			
			<div class="card-body text-primary" 
				style="background-color: hsla(9, 100%, 64%, 0.5); border: 10px;">
				
				<table
					style="color: black; background-color: hsla(9, 100%, 64%, 0.5);">
					<form:hidden path="pid"/>
					<thead>

						<tr>

							<td>Name:</td>
							<td><form:input type="text" placeholder="Name" path="name"
									required="required" /></td>
						</tr>
						<tr>
							<td>Email:</td>
							<td><form:input type="email" placeholder="name@example.com"
									path="email" /></td>
						</tr>
						<tr>
							<td>Mobile:</td>
							<td><form:input type="number" placeholder="9999999999"
									path="mobNo" /></td>
						</tr>

						<tr>
							<td class="btn btn-outline-warning"><input type="reset"
								value="Reset"></td>

							<td class="btn btn-outline-success"><input type="submit"
								value="Save" /></td>

						</tr>
					</thead>
				</table>

			</div>
			<div class="alert alert-warning" role="alert">
				<a href="viewAll" class="alert-link"> View All Contact Detail</a>
			</div>
		</div>
		</div>
	</form:form>

	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>

</body>
</html>