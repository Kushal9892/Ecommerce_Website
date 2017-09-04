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

<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">

<title>Online Shopping - ${title}</title>
<script>
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}';
</script>

<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap Solar Theme -->
<link href="${css}/bootstrap-solar-theme.css" rel="stylesheet">

<!-- Bootstrap DataTable -->
<!-- This file added the sort option and aligned the table (Search) -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="${css}/myapp.css" rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
	<div class="wrapper">
		<!-- Navigation -->
		<%@include file="./shared/navbar.jsp"%>

		<!-- Page Content -->
		<div class="content">
			
			<!--  Home -->
			<c:if test="${ifUserClickedHome == true}">
				<%@include file="home.jsp"%>
			</c:if>

			<!--  About Us -->
			<c:if test="${ifUserClickedAbout == true}">
				<%@include file="about.jsp"%>
			</c:if>

			<!--  Contact Us -->
			<c:if test="${ifUserClickedContact == true}">
				<%@include file="contact.jsp"%>
			</c:if>
			
			<!--  Products -->
			<c:if test="${ifUserClickedAllProducts == true or ifUserClickedCategoryProducts == true}">
				<%@include file="listProducts.jsp"%>
			</c:if>
			
			<!--  Load only when user clicks show product -->
			<c:if test="${ifUserClickedShowProduct == true}">
				<%@include file="singleProduct.jsp"%>
			</c:if>
			
			<!--  Load only when user clicks manage product -->
			<c:if test="${ifUserClickedManageProducts == true}">
				<%@include file="manageProducts.jsp"%>
			</c:if>
		</div>
		
		<!--  Footer -->
		<%@include file="./shared/footer.jsp"%>

		<!-- jQuery -->
		<script src="${js}/jquery.js"></script>
		
		<!-- jQuery validator -->
		<script src="${js}/jquery.validate.js"></script>

		<!-- Bootstrap Core JavaScript -->
		<script src="${js}/bootstrap.min.js"></script>
		
		<!-- Data Tables (Core dataTable file) -->
		<script src="${js}/jquery.dataTables.js"></script>
		
		<!-- Data Tables Bootstrap Script -->
		<!-- This file added the styling for previous & next buttons -->
		<script src="${js}/dataTables.bootstrap.js"></script>
		
		<!-- Bootbox -->
		<script src="${js}/bootbox.min.js"></script>

		<!-- Self coded JS -->
		<script src="${js}/myapp.js"></script>
	</div>
</body>

</html>