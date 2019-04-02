<!-- CREATE BY : CHABANE YOUCEF EL AMINE & BOUFAR TAREK -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,model.*,control.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AJAX's Filiere select</title>
</head>
<body>
	<%
			List<Filiere> fil_list = (List<Filiere>) session.getAttribute("filiere_list");
	%>
	
	<option selected="selected">--select Filiere--</option>
	<%for(Filiere f: fil_list){ %>
		<option value="<%=f.getId()%>"><%=f.getFiliere() %></option>
	<%} %>
</body>
</html>