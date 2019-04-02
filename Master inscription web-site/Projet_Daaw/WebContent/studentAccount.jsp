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
				<a href="#" class="navbar__logo">Master</a>
				<nav class="navbar__menu">
					<ul>
						
						<li><a href="main.jsp">Logout</a></li>
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
					<% student s = (student) session.getAttribute("studentOK"); %>
					
					
					<h3 class="app__main__title">hello <%= s.getFname() %> </h3><br><br>
					<%if(s.getMaster1() == null || s.getMaster2() == null || s.getMaster3() == null){ %>
						<h2 class="app__main__title"> you must complete your registrations !!</h2>
						
						<c:url var="selectF" value="SelectMasterServlet">
							<c:param name="command" value="listuniv" />
						</c:url>
						<a href="${selectF }">Complete Registrations here</a>
					<%}else{ %>
						<h3>The masters Degrees that you have choosed:</h3>
							<p>Fisrt Choice : <b><%=s.getMaster1() %></b></p>
							<p>Second Choice : <b><%=s.getMaster2() %></b> </p>
							<p>Third Choice : <b><%=s.getMaster3() %></b></p>
							<br><br>
						
						<c:url var="deletedMaster" value="StudentServlet">
							<c:param name="command" value="deletemaster" />
							<c:param name="studentEmail" value="<%=s.getEmail() %>" />
						</c:url>
						
				  		<a href="${deletedMaster }">Delete inscription</a>	
					<%} %>	
						
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>





















