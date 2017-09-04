<!-- Adding the taglib to use spring form -->
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<div class="container">
	<div class="row">

		<c:if test="${not empty message}">
			<div class="col-xs-12">
				<div class="alert alert-success alert-dismissible">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${message}
				</div>
			</div>
		</c:if>

		<div class="col-md-offset-2 col-md-8">
			<!-- Offset is to leave margins from both sides -->
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Product Management</h4>
				</div>
				<div class="panel-body">
					<!-- Form Elements -->
					<sf:form class="form-horizontal" modelAttribute="product"
						action="${contextRoot}/manage/products" method="POST"
						enctype="multipart/form-data">
						<div class="form-group">
							<label class="control-label col-md-4" for="productName">Enter
								Product Name: </label>
							<div class="col-md-8">
								<sf:input type="text" path="productName" id="productName"
									placeholder="Product Name" class="form-control"></sf:input>
								<sf:errors path="productName" cssClass="help-block"
									elements="em"></sf:errors>
								<!-- For Hibernate Validation implementation -->
								<!-- <em class="help-block">Please enter Product Name!!</em> -->
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="productBrand">Enter
								Brand Name: </label>
							<div class="col-md-8">
								<sf:input type="text" path="productBrand" id="productBrand"
									placeholder="Brand Name" class="form-control"></sf:input>
								<sf:errors path="productBrand" cssClass="help-block"
									elements="em"></sf:errors>
								<!-- For Hibernate Validation implementation -->
								<!-- <em class="help-block">Please enter Brand Name!!</em> -->
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="productdescription">Enter
								Product Description: </label>
							<div class="col-md-8">
								<sf:textarea path="productDescription" id="productDescription"
									rows="4" placeholder="Product Description" class="form-control"></sf:textarea>
								<sf:errors path="productDescription" cssClass="help-block"
									elements="em"></sf:errors>
								<!-- For Hibernate Validation implementation -->
								<!-- <em class="help-block">Please enter Product Description!!</em> -->
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="productUnitPrice">Enter
								Unit Price: </label>
							<div class="col-md-8">
								<sf:input type="number" path="productUnitPrice"
									id="productUnitPrice" placeholder="Unit Price in &#8377;  "
									class="form-control"></sf:input>
								<sf:errors path="productUnitPrice" cssClass="help-block"
									elements="em"></sf:errors>
								<!-- For Hibernate Validation implementation -->
								<!-- <em class="help-block">Please enter Unit Price!!</em> -->
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="productQuantity">Enter
								Quantity: </label>
							<div class="col-md-8">
								<sf:input type="number" path="productQuantity"
									id="productQuantity" placeholder="Quantity Available"
									class="form-control"></sf:input>
								<!-- <em class="help-block">Please enter Product Quantity Available!!</em> -->
							</div>
						</div>

						<!-- File element to upload an image -->
						<div class="form-group">
							<label class="control-label col-md-4" for="file">Select
								an Image to Upload: </label>
							<div class="col-md-8">
								<sf:input type="file" path="file" id="file" class="form-control"></sf:input>
								<sf:errors path="file" cssClass="help-block" element="em" />
								<!-- <em class="help-block">Please enter Product Quantity Available!!</em> -->
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="categoryID">Select
								Category: </label>
							<div class="col-md-8">
								<sf:select path="categoryID" id="categoryID"
									class="form-control" items="${categories}"
									itemLabel="categoryName" itemValue="categoryID">
								</sf:select>

								<c:if test="${product.productID == 0}">
									<br />
									<div class="text-right">
										<button type="button" data-toggle="modal"
											data-target="#myCategoryModal"
											class="btn btn-warning btn-xs">Add Category</button>
									</div>
								</c:if>
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<input type="submit" name="submit" id="submit" value="Submit"
									class="btn btn-primary">
							</div>
						</div>

						<!-- Hidden Fields to ensure that it does not reset to default while editing the details of any product -->
						<sf:hidden path="productID" />
						<sf:hidden path="productCode" />
						<sf:hidden path="supplierID" />
						<sf:hidden path="productPurchases" />
						<sf:hidden path="productViews" />
						<sf:hidden path="productIsActive" />
					</sf:form>
				</div>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-xs-12">
			<h3>Available Products</h3>
			<hr />
		</div>

		<div class="col-xs-12">
			<div class="container-fluid">
				<div class="table-responsive">
					<!-- Products table for admin -->
					
					<table id="adminProductsTable"
						class="table table-striped table-bordered">
	
						<thead>
							<tr>
								<th>Id</th>
								<th>&#160;</th>
								<th>Name</th>
								<th>Brand</th>
								<th>Quantity</th>
								<th>Unit Price</th>
								<th>Active</th>
								<th>Edit</th>
							</tr>
						</thead>
	
						<tfoot>
							<tr>
								<th>Id</th>
								<th>&#160;</th>
								<th>Name</th>
								<th>Brand</th>
								<th>Quantity</th>
								<th>Unit Price</th>
								<th>Active</th>
								<th>Edit</th>
							</tr>
						</tfoot>
					</table>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="myCategoryModal" role="dialog"
		tabindex="-1">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span>&times;</span>
						<!-- For the 'X' symbol -->
					</button>
					<h4 class="modal-title">Add New Category</h4>
				</div>
				
				<div class="modal-body">
					<!-- Category form -->
					<sf:form id="categoryForm" modelAttribute="category" action="${contextRoot}/manage/category"
						method="POST" class="form-horizontal">
						
							<div class="form-group">
								<label for="categoryName" class="control-label col-md-4">Category Name</label>
								<div class="col-md-8">
									<sf:input type="text" id="categoryName" path="categoryName" class="form-control"/>
								</div>
							</div>
							
							<div class="form-group">
								<label for="categoryDescription" class="control-label col-md-4">Category Description</label>
								<div class="col-md-8">
									<sf:textarea cols="" rows="5" path="categoryDescription" id="categoryDescription" class="form-control"/>
								</div>
							</div>
							
							<div class="col-md-offset-4 col-md-8">
								<input type="submit" value="Add Category" class="btn btn-primary"/>
							</div>
						
					</sf:form>
				</div>
			</div>
		</div>
	</div>