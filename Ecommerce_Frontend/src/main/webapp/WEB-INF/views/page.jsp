<%--Tag libraries --%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />


<!--  specifies the root directory of the project which is Ecommerce_Frontend -->
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>SalesRack.in - ${title}</title>

<script>
	window.menu = '${title}';
</script>

<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap Slate Theme -->
<link href="${css}/bootstrap-slate-theme.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="${css}/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link href="${css}/family-lora.css" rel="stylesheet" type="text/css">
<link href="${css}/family-montserrat.css" rel="stylesheet"
	type="text/css">

<!-- Theme CSS -->
<link href="${css}/myapp.css" rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">

	<!-- Navigation -->
	<%@include file="./shared/navbar.jsp"%>

	<!-- Page Content -->
	<c:if test="${ifUserClickedHome == true}">
		<%@include file="home.jsp"%>
	</c:if>

	<!-- Load this page only when user clicks 'About Us' link -->
	<c:if test="${ifUserClickedAbout == true}">
		<%@include file="about.jsp"%>
	</c:if>

	<!-- Load this page only when user clicks 'Contact Us' link -->
	<c:if test="${ifUserClickedContact == true}">
		<%@include file="contact.jsp"%>
	</c:if>

	<!-- Load this page only when user clicks 'All Products' link -->
	<c:if test="${ifUserClickedAllProducts == true}">
		<%@include file="listProducts.jsp"%>
	</c:if>

	<!-- Map Section -->
	<div id="map"></div>

	<!-- Footer -->
	<%@include file="./shared/footer.jsp"%>

	<!-- jQuery -->
	<script src="${js}/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="${js}/bootstrap.min.js"></script>



	<!-- Plugin JavaScript -->
	<script src="${js}/jquery.easing.min.js"></script>

	<!-- Google Maps API Key - Use your own API key to enable the map feature. More information on the Google Maps API can be found at https://developers.google.com/maps/ -->
	<script type="text/javascript"
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCRngKslUGJTlibkQ3FkfTxj3Xss1UlZDA&sensor=false"></script>

	<!-- Theme JavaScript -->
	<script src="${js}/grayscale.min.js"></script>

	<!-- Self-Coded JavaScript -->
	<script src="${js}/myapp.js"></script>

</body>

</html>
