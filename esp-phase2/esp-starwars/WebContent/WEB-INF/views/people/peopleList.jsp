<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">    
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Listado de Personajes</title>
   	<spring:url value="/resources" var="publicResourcesUrl" />
	<spring:url value="/movies/create" var="movieFormUrl" />
	<spring:url value="/movies/edit" var="movieEditUrl" />
	<spring:url value="/movies/delete" var="movieDeleteUrl" />
    <link href="${publicResourcesUrl}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${publicResourcesUrl}/bootstrap/css/theme.css" rel="stylesheet">
    
  </head>

  <body>

    <jsp:include page="../includes/menu.jsp"></jsp:include>

    <div class="container theme-showcase" role="main">

		<div class="page-header">
			<h3 class="blog-title">
				<span class="label label-success">Listado de Personajes</span>
			</h3>
		</div>

		<div class="table-responsive">
        <table class="table table-hover table-striped table-bordered">
            <tr>
                <th>Personaje</th>
                <th>N�mero de pel�culas</th>
                <th>T�tulos Pel�culas</th>
            </tr>
            
            <c:forEach var="peopleFilms" items="${peopleFilmsMap}">
            <tr>
                <td>${peopleFilms.key}</td>
                <td>${peopleFilms.value.size()}</td>
                <td>
                	<table>
                    <c:forEach var="film" items="${peopleFilms.value}">
                		<tr>
                			<td>${film}</td>
               			</tr>
           			</c:forEach>
                	</table>
                </td>
            </tr>
            </c:forEach>
        
        </table>
      </div>
          
      <hr class="featurette-divider">

     <jsp:include page="../includes/footer.jsp"></jsp:include>

    </div> <!-- /container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
    <script src="${publicResourcesUrl}/bootstrap/js/bootstrap.min.js"></script>     
  </body>
</html>
