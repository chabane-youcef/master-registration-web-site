<!-- CREATE BY : CHABANE YOUCEF EL AMINE & BOUFAR TAREK -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"   pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,model.*,control.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Specialite Select</title>
</head>
<body>
	<%
			List<specialite> spec_list = (List<specialite>) session.getAttribute("specialites_list");
	%>
		<option selected="selected">--select specialite--</option>
	<%for(specialite s: spec_list){ %>
		<option value="<%=s.getId()%>"><%=s.getName() %>	|	<%=s.getNbr_places()%> post</option>
	<%} %>
</body>
</html>