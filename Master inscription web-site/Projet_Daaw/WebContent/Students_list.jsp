<!-- CREATE BY : CHABANE YOUCEF EL AMINE & BOUFAR TAREK -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,model.*,control.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang='en'>

<head>
    <meta class="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>Accepted Students | Responsable</title>
    <link rel='stylesheet' href='css/style.min.css' />
</head>

<body>
    <!-- navbar -->
    <div class="navbar navbar--extended">
        <div class="container">
            <div class="navbar__inner">
                <a href="#" class="navbar__logo">master</a>
                <nav class="navbar__menu">
                    <ul>
                        <li><a href="#"><%= session.getAttribute("responsable_fname") %></a></li>
                        <li><a href="main.jsp">log out</a></li>
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
                        <h1 class="page__header__title">Accepted Students table</h1>
                        
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
                    
                    <c:url var="deletedList" value="ResponsableServlet">
						<c:param name="command" value="deletedLink" />			
					</c:url>
					
					<c:url var="acceptedList" value="ResponsableServlet">
						<c:param name="command" value="acceptedLink" />			
					</c:url>
					
					
					<c:url var="acceptedList1" value="ResponsableServlet">
						<c:param name="command" value="acceptedLink1" />				
					</c:url>
					
                        <li><a href="${ acceptedList}">see all Students</a></li>
                        <li><a href="${ acceptedList1}" class="vMenu--active">see accepted Students</a></li>
                        <li><a href="${ deletedList}">See deleted Students</a></li>
                       

                    </ul>
                </div>
                <div class="page__main">
                    <div class="text-container">
                    <%
						List<student> x = (List<student>) request.getAttribute("StudentsAccepted");
					%>
                        <h3 class="page__main__title">---accepted student's list---</h3>
                        
                        <table cellspacing="5">
							<tr>
								<th>ID</th>
								<th>First name</th>
								<th>Last name</th>
								<th>specialite</th>
								<th>Email</th>
								<th>mark</th>
								<th>action</th>
							</tr>
							<%for(student tempStudent : x){ %>
								<c:url var="RefuseLink" value="ResponsableServlet">
									<c:param name="command" value="Reject" />
									<% String E = tempStudent.getEmail();	%>
									
									<c:param name="studentId" value="<%= E %>" />
								</c:url>
								
							
								<tr>
									
									<td><%= tempStudent.getId() %></td>
									<td><%= tempStudent.getFname() %></td>
									<td><%= tempStudent.getLname() %></td>
									<td><%= tempStudent.getSpecialite() %></td>
									<td><%= tempStudent.getMoy() %></td>
									<td><%= tempStudent.getEmail() %></td>
									<td><a href="${RefuseLink }">&#10005;</a></td>
									
								</tr>
							
							<%} %>
							<% session.setAttribute("student_xls", x); %>
						</table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

</html>