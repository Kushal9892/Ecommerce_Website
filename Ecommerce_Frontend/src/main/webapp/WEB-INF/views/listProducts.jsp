
<div class="container">
	<div class="row">
		
		<!-- To display the products -->
		<div class="col-md-12">
			
			<!-- Adding Breadcrumb components -->
			<div class="row">
				<div class="col-lg-12">
					<c:if test="${ifUserClickedAllProducts == true}">
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All Products</li>
						</ol>
					</c:if>
					
					<c:if test="${ifUserClickedCategoryProducts == true}">
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.categoryName}</li>
						</ol>
					</c:if>
				</div>
			</div>
		</div>
	</div>
</div>