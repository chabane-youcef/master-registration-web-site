<!-- CREATE BY : CHABANE YOUCEF EL AMINE & BOUFAR TAREK -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,model.*,control.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta class="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	
	<title>Master Selection</title>
	<link rel='stylesheet' href='css/style.min.css' />
	<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
</head>
<body>
		<!-- navbar -->
    <div class="navbar">
        <div class="container">
            <div class="navbar__inner">
                <a href="main.jsp" class="navbar__logo">master</a>
                <nav class="navbar__menu">
                    <ul>
                        
                        <li><a href="login-section.html">Log out</a></li>
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

                    <img src="./images/select_master.svg">
                </div>
                <div class="auth__auth">
                    <h1 class="auth__title">Login into your account</h1>
                    <p>Fill in the needed informations</p>
                    <% 
                    	student s = (student) session.getAttribute("studentOK"); 
                    
			            List<Universite> univs_list = (List<Universite>) session.getAttribute("univs_list");
		            %>
                    <form method="post" action="StudentServlet" class="form">
                        <input name="email" class="fakefield">
                        <label>Chose Universite</label>
                        <select class="univs" onchange="univ_change()">
                            <option>--select universite--</option>
                            <%for(Universite u : univs_list){ %>
                            <option value="<%=u.getId()%>">
                                <%= u.getName() %>
                            </option>
                            <%} %>
                        </select>

                        <label>Chose Filiere</label>
                        <select class="fils" onchange="fil_change()">
                            <option selected="selected">--select Filiere--</option>
                        </select>

                        <label>Chose Specialite</label>
                        <select class="specs" name="spec">
                            <option selected="selected" value="non selected">--select specialite--</option>
                        </select>
                        
                        <br><br>
                        <label>select your Second master choice</label>
                        
                        <label>Chose Universite</label>
                        <select class="univs1" onchange="univ_change1()">
                            <option>--select universite--</option>
                            <%for(Universite u1 : univs_list){ %>
                            <option value="<%=u1.getId()%>">
                                <%= u1.getName() %>
                            </option>
                            <%} %>
                        </select>

                        <label>Chose Filiere</label>
                        <select class="fils1" onchange="fil_change1()">
                            <option selected="selected">--select Filiere--</option>
                        </select>

                        <label>Chose Specialite</label>
                        <select class="specs1" name="spec1">
                            <option selected="selected">--select specialite--</option>
                        </select>
                        
                        <br><br>
                        <label>select your third master choice</label>
                        
                        
                        <label>Chose Universite</label>
                        <select class="univs2" onchange="univ_change2()">
                            <option>--select universite--</option>
                            <%for(Universite u1 : univs_list){ %>
                            <option value="<%=u1.getId()%>">
                                <%= u1.getName() %>
                            </option>
                            <%} %>
                        </select>

                        <label>Chose Filiere</label>
                        <select class="fils2" onchange="fil_change2()">
                            <option selected="selected">--select Filiere--</option>
                        </select>

                        <label>Chose Specialite</label>
                        <select class="specs2" name="spec2">
                            <option selected="selected">--select specialite--</option>
                        </select>
                        
                        
                        <input type="submit" class="button button__accent" value="log in">
                        <input type="hidden" name="command" value="masterChoice">
                        <input type="hidden" name="StudentEmail" value="<%=s.getEmail() %>">
                        
                    </form>
                </div>
            </div>
        </div>
    </div>


    <script type="text/javascript">
        function univ_change() {
            var universite = $(".univs").val();

            $.ajax({
                type: "POST",
                url: 'SelectMasterServlet',
                data: "univ_id=" + universite,
                cache: false,
                success: function (response) {
                    $(".fils").html(response);
                }
            });
        }

        function fil_change() {
            var filiere = $(".fils").val();

            $.ajax({
                type: "POST",
                url: 'SpecialiteSelect',
                data: "fil_id=" + filiere,

                cache: false,
                success: function (response) {
                    $(".specs").html(response);
                }
            });
        }
        
//          aja functions for the second option 
        
        function univ_change1() {
            var universite = $(".univs1").val();

            $.ajax({
                type: "POST",
                url: 'SelectMasterServlet',
                data: "univ_id=" + universite,
                cache: false,
                success: function (response) {
                    $(".fils1").html(response);
                }
            });
        }

        function fil_change1() {
            var filiere = $(".fils1").val();

            $.ajax({
                type: "POST",
                url: 'SpecialiteSelect',
                data: "fil_id=" + filiere,

                cache: false,
                success: function (response) {
                    $(".specs1").html(response);
                }
            });
        }
        
//          aja functions for the third option 
        
        function univ_change2() {
            var universite = $(".univs2").val();

            $.ajax({
                type: "POST",
                url: 'SelectMasterServlet',
                data: "univ_id=" + universite,
                cache: false,
                success: function (response) {
                    $(".fils2").html(response);
                }
            });
        }

        function fil_change2() {
            var filiere = $(".fils2").val();

            $.ajax({
                type: "POST",
                url: 'SpecialiteSelect',
                data: "fil_id=" + filiere,

                cache: false,
                success: function (response) {
                    $(".specs2").html(response);
                }
            });
        }
    </script>
		
</body>
</html>











