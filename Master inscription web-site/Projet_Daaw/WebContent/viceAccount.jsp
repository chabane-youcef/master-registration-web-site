<!-- CREATE BY : CHABANE YOUCEF EL AMINE & BOUFAR TAREK -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,model.*,control.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang='en'>

<head>
    <meta class="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>Vide Doyen</title>
    <link rel='stylesheet' href='css/style.min.css' />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
    <!-- navbar -->
    <div class="navbar navbar--extended">
        <div class="container">
            <div class="navbar__inner">
                <a href="main.jsp" class="navbar__logo">master</a>
                <nav class="navbar__menu">
                    <ul>
                        
                        <li><a href="login-section.html">Logout</a></li>
                    </ul>
                </nav>

            </div>
        </div>
    </div>
    <!-- Hero unit -->
    <div class="page__header">
        <div class="hero__overlay hero__overlay--gradient"></div>
        <div class="hero__mask"></div>
        <div class="page__header__inner">
            <div class="container">
                <div class="page__header__content">
                    <div class="page__header__content__inner" id='navConverter'>
                        <h1 class="page__header__title">vice doyen page</h1>
                        <p class="page__header__text"></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Page content -->
    <div class="page">
        <div class="container">
            <div class="page__inner">
                <div class="page__menu">
                    <ul class="vMenu">
                    <% List<specialite> specialites = (List<specialite>)session.getAttribute("specialites_list"); %>
                    
					
					<%for(specialite x : specialites){ %>
						
						<c:url var="specialiteLink" value="ViceDoyenServlet">
							<c:param name="command" value="SpecialiteList" />
							<%String S = x.getName(); %>	
							<c:param name="specName" value="<%=S %>"/>			
						</c:url>
						
                        <li><a href="${ specialiteLink}"><%=x.getName() %></a></li>
					<%} %>
                    </ul>
                </div>
                <div class="page__main">
                    <div class="text-container">
                    
                        <h3 class="page__main__title">---see every master's students---</h3>
                        	
                       
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

</html>