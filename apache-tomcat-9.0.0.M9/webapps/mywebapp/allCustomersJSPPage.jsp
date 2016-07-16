<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

	<head>
		<title>All Customers</title>
	</head>

	<body>
		<h1>All Customers</h1>
		
		<em>This is a very poor layout - see the SpringMVC course for a much better one!</em>
		
		<table>
			<tr>
				<th>Title</th>
				<th>Author</th>
			</tr>
			
			<c:forEach items="${customers}" var="customer">
				<tr>
					<td>${customer.companyName}</td>
					<td>${customer.notes}</td>
				</tr>
			</c:forEach>
	 	<table>
	</body>
</html>