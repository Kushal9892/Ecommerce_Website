<div class="container">

	<!-- Breadcrumb component -->

	<div class="row">
		<div class="col-xs-12">

			<ol class="breadcrumb">
				<li><a href="${contextRoot}/home">Home</a></li>
				<li><a href="${contextRoot}/show/all/products">Products</a></li>
				<li class="active">${product.productName}</li>

			</ol>

		</div>

	</div>

	<div class="row">

		<!-- Display the product image -->
		<div class="col-xs-12 col-sm-4">

			<div class="thumbnail">

				<img src="${images}/${product.productCode}.jpg"
					class="img img-responsive" />

			</div>

		</div>

		<!-- Display the product description -->
		<div class="col-xs-12 col-sm-8">

			<h3>${product.productName}</h3>
			<hr />

			<p>${product.productDescription}</p>
			<hr />

			<h4>
				Price: <strong> &#8377; ${product.productUnitPrice} /-</strong>
			</h4>
			<hr />

			<h6>Quantity Available : ${product.productQuantity}</h6>
			<a href="${contextRoot}/cart/add/${product.productID}/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span> Add to Cart</a>
			<a href="${contextRoot}/show/all/products" class="btn btn-primary">Back</a>
		</div>

	</div>

</div>