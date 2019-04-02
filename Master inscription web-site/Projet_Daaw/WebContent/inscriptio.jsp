<!-- CREATE BY : CHABANE YOUCEF EL AMINE & BOUFAR TAREK -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang='en'>
<head>
	<meta class="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<title>Register</title>
	<link rel='stylesheet' href='css/style.min.css' />
</head>
<body>
	<!-- navbar -->
	<div class="navbar">
		<div class="container">
			<div class="navbar__inner">
				<a href="main.jsp" class="navbar__logo">master</a>
				<nav class="navbar__menu">
					<ul>
						<li><a href="inscriptio.jsp">Sign In</a></li>
						<li><a href="login-section.html">Log In</a></li>
					</ul>
				</nav>
			</div>
		</div>
	</div>
	<!-- Authentication pages -->
	<div class="auth">
		<div class="container">
			<div class="auth__inner">
				<div class="auth__media">
					<img src="./images/login.svg">
				</div>
				<div class="auth__auth">
					<h1 class="auth__title">Login into your account</h1>
					<p>Fill in the needed informations</p>
					<form method='post' action="StudentServlet" enctype="multipart/form-data"   class="form">
						<input name="email" class="fakefield">
						<label>First name:</label>
						<input type="text" name="fname" id='fname' placeholder="chabane">
						<label>Last name:</label>
						<input type="text" name="lname" id='lname' placeholder="youcef">
						<label>Birthday Date:</label>
						<input type="text" name="BdDate" id='BdDate' placeholder="year-month-day">
						<label>Birthday Place:</label>
						<input type="text" name="DbPlace" id='DbPlace' placeholder="Batna">
						<label>Email:</label>
						<input type="text" name="Email" placeholder="chabaneyoucef@gmail.com">
						<label>Password</label>
						<input type="password" name="password" id='password' placeholder="&#9679;&#9679;&#9679;&#9679;&#9679;&#9679;&#9679;&#9679;&#9679;" autocomplete="off">
						<label>bachelore degree:</label>
						<input type="text" name="specialite" id='specialite' placeholder="informatique">
						<label>CV:</label>
						<input type="file" name="cv" id='cv' placeholder="informatique">
						<label>Mark:</label>
						<input type="text" name="moy" id='moy' placeholder="15">
						<label>Redoublement:</label>
						<input type="number" name="nbrRed" id='nbrRed' placeholder="0">
						<label>Progression:</label>
						<input type="text" name="nbrPrg" id='nbrPrg' placeholder="0">
						<label>RAttrapage:</label>
						<input type="text" name="nbrRat" id='nbrRat' placeholder="0">
						<p></p>
						<input type="hidden" name="command" value="inscritpion">
                        <input type="submit" class="button button__accent" value="sigin">
                        
                        
						<a href="login-section.html"><h6 class="left-align" >already have an account?</h6></a>
						<% String m = (String)request.getAttribute("message"); %>
						<%if(m != null){ %>
							<p><%= m %></p>
						<% } %>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>