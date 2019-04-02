<!-- CREATE BY : CHABANE YOUCEF EL AMINE & BOUFAR TAREK -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<head>
	<meta class="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<title>Master | Home</title>
	<!-- Don't forget to add your metadata here -->
	<link rel='stylesheet' href='css/style.min.css' />
</head>
<body>
	<%session.invalidate(); %>
	<!-- Hero(extended) navbar -->
	<div class="navbar navbar--extended">
		<nav class="nav__mobile"></nav>
		<div class="container">
			<div class="navbar__inner">
				<a href="index.html" class="navbar__logo">Master</a>
				<nav class="navbar__menu">
					<ul>
						<li><a href="inscriptio.jsp">Sign in</a></li>
						<li><a href="login-section.html">Log in</a></li>
					</ul>
				</nav>
				<div class="navbar__menu-mob"><a href="" id='toggle'><svg role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512"><path fill="currentColor" d="M16 132h416c8.837 0 16-7.163 16-16V76c0-8.837-7.163-16-16-16H16C7.163 60 0 67.163 0 76v40c0 8.837 7.163 16 16 16zm0 160h416c8.837 0 16-7.163 16-16v-40c0-8.837-7.163-16-16-16H16c-8.837 0-16 7.163-16 16v40c0 8.837 7.163 16 16 16zm0 160h416c8.837 0 16-7.163 16-16v-40c0-8.837-7.163-16-16-16H16c-8.837 0-16 7.163-16 16v40c0 8.837 7.163 16 16 16z" class=""></path></svg></a></div>
			</div>
		</div>
	</div>
	<!-- Hero unit -->
	<div class="hero">
		<div class="hero__overlay hero__overlay--gradient"></div>
		<div class="hero__mask"></div>
		<div class="hero__inner">
			<div class="container">
				<div class="hero__content">
					<div class="hero__content__inner" id='navConverter'>
						<h1 class="hero__title">MASTER</h1>
						<p class="hero__text">Choose the right Degree for your Future in a simple way.</p>
						<a href="login-section.html" class="button button__accent">Get Started</a>
						
						
						
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="hero__sub">
		<span id="scrollToNext" class="scroll">
			<svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" class='hero__sub__down' fill="currentColor" width="512px" height="512px" viewBox="0 0 512 512" style="enable-background:new 0 0 512 512;" xml:space="preserve"><path d="M256,298.3L256,298.3L256,298.3l174.2-167.2c4.3-4.2,11.4-4.1,15.8,0.2l30.6,29.9c4.4,4.3,4.5,11.3,0.2,15.5L264.1,380.9c-2.2,2.2-5.2,3.2-8.1,3c-3,0.1-5.9-0.9-8.1-3L35.2,176.7c-4.3-4.2-4.2-11.2,0.2-15.5L66,131.3c4.4-4.3,11.5-4.4,15.8-0.2L256,298.3z"/></svg>
		</span>
	</div>
	<!-- Steps -->
	<div class="steps landing__section">
		<div class="container">
			<h2>Who can use Master?</h2>
			<p>Here's who we can think of.</p>
		</div>
		<div class="container">
			<div class="steps__inner">
				<div class="step">
					<div class="step__media">
						<img src="./images/undraw_designer.svg" class="step__image">
					</div>
					<h4>Students</h4>
					<p class="step__text">every one who is intressted in compliting his master degree</p>
				</div>
				<div class="step">
					<div class="step__media">
						<img src="./images/undraw_responsive.svg" class="step__image">
					</div>
					<h4>Teachers</h4>
					<p class="step__text">if you are a teacher then you can be a part of their future.</p>
				</div>
				
			</div>
		</div>
	</div>
	
	
	<!-- Footer -->
	<div class="footer footer--dark">
		<div class="container">
			<div class="footer__inner">
				<a href="index.html" class="footer__textLogo">Master</a>
				<div class="footer__data">
					<div class="footer__data__item">
						<div class="footer__row">
							Created by <a href="https://twitter.com/ninalimpi" target="_blank" class="footer__link">Boufar Tarek</a>
						</div>
						<div class="footer__row">
						Code/design by <a href="https://twitter.com/anges244" target="_blank" class="footer__link">Chabane youcef El Amine</a>
						</div>
					</div>
					<div class="footer__data__item">
						<div class="footer__row">Created for <a href="https://undraw.co" target="_blank" class="footer__link">Master</a>
						</div>
					</div>
					<div class="footer__data__item">
					<div class="footer__row">
						<a href="https://twitter.com/undraw_co" target="_blank" class="footer__link">Twitter</a>
					</div>
					<div class="footer__row">
						<a href="https://www.facebook.com/undraw.co/" target="_blank" class="footer__link">Facebook</a>
					</div>
				</div>
			</div>
		</div>
	</div>
<script src='js/app.min.js'></script>
</body>
</html>