<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Contact</title>

</head>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<body>
<form:form>&nbsp &nbsp &nbsp &nbsp
<div class="container" style="height: 100% ">
<a href="/" class="alert-link">Add New Contact</a>
<div class="card-body text-primary" 
				style="background-color: hsla(9, 100%, 64%, 0.5); border: 10px;">
				<script type="text/javascript">
function deletePopup() {
	return confirm ("Are you sure, Do you Want to Delete ?");
}
</script>
	<table class="table table-hover">
		<thead >
			<tr >
				<td scope="col">S.No</td>
				<td>NAME</td>
				<td>EMAIL</td>
				<td>NUMBER</td>
				<td>ACTION</td>

			</tr>
		</thead>
		<tbody>
			<tr>
				<c:forEach var="c" items="${listcontact}" varStatus="count"  >
                <tr>
                <td scope="row" style="font: bold;">${count.index+1}</td>
                    <td>${c.name}</td>
                    <td>${c.email}</td>
                    <td>${c.mobNo}</td>
                    <td><a href="editContact?cnctId=${c.pid}">Edit</a>&nbsp &nbsp
                     <a href="delete?cId=${c.pid}" onclick="return deletePopup()">Delete</a></td>
                    
                </tr>
                </c:forEach>
			</tr>

		</tbody>
</table>
</div>
</div>
</form:form>
</body>
</html>