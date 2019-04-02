<!-- CREATE BY : CHABANE YOUCEF EL AMINE & BOUFAR TAREK -->
<!DOCTYPE html>
<html lang='en'>
<head>
	<meta class="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<title>Edite</title>
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
					<img src="./images/updatenbr.svg">
				</div>
				<div class="auth__auth">
					<h1 class="auth__title"></h1>
					<%String Sname = (String) session.getAttribute("specName"); %>
					<p>Change number of places for <%=Sname %></p>
					<form method='get' action="ViceDoyenServlet"   class="form">
						<input name="email" class="fakefield">
						<label>Number of places limited:</label>
						<input type="text" name="nbr"  placeholder="50">
						<input type="hidden" name="command" value="UpdatePlaces">
						<input type="hidden" name="specName" value="<%=Sname%>">
						<input type="submit" class="button button__accent" value="Change">
                        
						
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>