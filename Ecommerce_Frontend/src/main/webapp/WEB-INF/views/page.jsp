<%--Tag libraries --%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<spring:url value="/resources/images" var="images" />
<spring:url value="/resources/css" var="css" />
<spring:url value="/resources/js" var="js" />
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<!--<link rel="icon" href="../../favicon.ico">-->

<title>Ecommerce Website - ${title}</title>

<link href="${css}/bootstrap.css" rel="stylesheet" />
<link href="${css}/bootstrap-theme.css" rel="stylesheet" />
<link href="${css}/app.css" rel="stylesheet" />

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<!-- Header containing the nav file -->
	<%@include file="./shared/menu.jsp"%>

	<%-- Load the file based based on what the user is clicking --%>
	<%-- Load Index --%>
	<c:if test="${ifUserClickedHome == true}">
		<%@include file="home.jsp"%>
	</c:if>
	
	<%-- Load About --%>
	<c:if test="${ifUserClickedAbout == true}">
		<%@include file="about.jsp"%>
	</c:if>
	
	<%-- Load Contact --%>
	<c:if test="${ifUserClickedContact == true}">
		<%@include file="contact.jsp"%>
	</c:if>
	
	<%-- Load Login --%>
	<c:if test="${ifUserClickedLogin == true}">
		<%@include file="login.jsp"%>
	</c:if>

	<!-- Footer here -->
	<%@include file="./shared/footer.jsp"%>

	<%-- Load jQuery before bootstrap --%>
	<script src="${js}/jquery.js"></script>
	<script src="${js}/bootstrap.js}"></script>

</body>
</html>
