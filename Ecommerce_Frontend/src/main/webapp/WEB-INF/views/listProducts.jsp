
<div class="container">
	<div class="row">

		<!-- To display the sidebar -->
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp"%>
		</div>

		<!-- To display the products -->
		<div class="col-md-9">

			<!-- Adding Breadcrumb components -->
			<div class="row">
				<div class="col-lg-12">
					<c:if test="${ifUserClickedAllProducts == true}">
						<script>
							window.categoryId = '';
						</script>
						
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All Products</li>
						</ol>
					</c:if>

					<c:if test="${ifUserClickedCategoryProducts == true}">
						<script>
							window.categoryId = '${category.categoryID}';
						</script>
					
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.categoryName}</li>
						</ol>
					</c:if>
				</div>
			</div>

			<div class="row">
				<div class="col-xs-12">
					<table id="productListTable"
						class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Images</th>
								<th>Name</th>
								<th>Brand</th>
								<th>Unit Price</th>
								<th>Quantity Available</th>
								<th></th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th>Name</th>
								<th>Brand</th>
								<th>Unit Price</th>
								<th>Quantity Available</th>
								<th></th>
							</tr>
						</tfoot>
					</table>
				</div>
			</div>
		</div>
	</div>