<%@page import="ua.com.foxminded.dynamicweb.DatabaseFacade"%>
<%@page import="ua.com.foxminded.dynamicweb.AddBook"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here 1</title>
</head>
<body>
	<h1>List of books 1</h1>

	<%
	for (String book : DatabaseFacade.getBooks()) {
		out.print(book + "<br/>");
	}
	%>

	<br>
	<br>

	<form action=<%AddBook.addBook(request.getParameter("add"));%>>
		<label>Add book
		<input type="text" name="add" placeholder="input book" value="" autocomplete="off">
		<input onclick=listButton() type="submit" value="Submit">
		</label>
	</form>

<br>

	<form action=<%AddBook.deleteBook(Integer.parseInt(request.getParameter("remove")));%>>
	<label>Delete book
	<input type="number" name="id" placeholder="input id" value="id" autocomplete="off">
	<button type="submit" name="remove" value="">Remove</button>
	</label>
	</form>
	
	
</body>
</html>