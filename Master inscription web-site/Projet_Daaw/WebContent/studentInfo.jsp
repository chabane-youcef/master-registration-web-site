<!-- CREATE BY : CHABANE YOUCEF EL AMINE & BOUFAR TAREK -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,model.*,control.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang='en'>
<head>
	<meta class="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<title>user's profil</title>
	<link rel='stylesheet' href='css/style.min.css' />
</head>
<body>
	<!-- navbar -->
	<div class="navbar">
		<nav class="nav__mobile"></nav>
		<div class="container">
			<div class="navbar__inner">
				<a href="main.jsp" class="navbar__logo">Master</a>
				<nav class="navbar__menu">
					<ul>
						
						<li><a href="login-section.html">Logout</a></li>
					</ul>
				</nav>
				<div class="navbar__menu-mob"><a href="" id='toggle'><svg role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512"><path fill="currentColor" d="M16 132h416c8.837 0 16-7.163 16-16V76c0-8.837-7.163-16-16-16H16C7.163 60 0 67.163 0 76v40c0 8.837 7.163 16 16 16zm0 160h416c8.837 0 16-7.163 16-16v-40c0-8.837-7.163-16-16-16H16c-8.837 0-16 7.163-16 16v40c0 8.837 7.163 16 16 16zm0 160h416c8.837 0 16-7.163 16-16v-40c0-8.837-7.163-16-16-16H16c-8.837 0-16 7.163-16 16v40c0 8.837 7.163 16 16 16z" class=""></path></svg></a></div>
			</div>
		</div>
	</div>
	<!-- Page content -->
	<div class="app">
		<div class="container">
			<div class="app__inner">
				
				<div class="app__main">
					<div class="text-container">
						<h3 class="app__main__title">Student's info	</h3>
						<br><br>
						<%
							student x = (student) session.getAttribute("studentInfo");
						%>
						<c:url var="downlloadFile" value="ResponsableServlet">
							<c:param name="command" value="file" />
							<% String E = x.getEmail();	%>	
							<c:param name="studentId" value="<%= E %>" />
						</c:url>
						<ul>
							<li>First name: <%=x.getFname() %> </li>
							<li>Last name: <%=x.getLname() %></li>
							<li>Birthday Date: <%=x.getBdDate() %></li>
							<li>Birthday Place: <%=x.getBdPlace() %></li>
							<li>Email: <%=x.getEmail() %></li>
							<li>Specialite: <%=x.getSpecialite() %></li>
							<li><a href="${downlloadFile }">Download File</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>

<script src='js/app.min.js'></script>
</body>
</html>