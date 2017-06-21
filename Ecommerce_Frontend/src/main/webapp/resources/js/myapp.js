$(function() {
	// Solving the active-menu problem!!
	// using the window.menu property of the page.jsp
	switch (menu) {

	case 'About Us':
		$('#about').addClass('active');
		break;

	case 'Contact Us':
		$('#contact').addClass('active');
		break;

	case 'All Products':
		$('#listProducts').addClass('active');
		break;

	case 'Manage Products':
		$('#manageProducts').addClass('active');
		break;

	default:
		if (menu == "Home")
			break;
		$('#listProducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;
	}

	// code for jquery dataTable!!

	// $table is a jquery element, and we are getting the table using the id
	// (#productListTable) and storing in $table
	var $table = $('#productListTable');

	// execute this code only where we have this table
	// This code will be executed only if the table length > 0
	if ($table.length) {
		// console.log('Inside the table');

		// if the user wants to display all products, then jsonYrl is set to
		// /json/data/all/products!!
		var jsonUrl = '';
		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.categoryId + '/products';
		}

		// DataTable function is used to display the products in tabular
		// format!!
		$table
				.dataTable({
					// -1 is used to display all items
					lengthMenu : [
							[ 3, 5, 10, -1 ],
							[ '3 Records', '5 Records', '10 Records',
									'All Records' ] ],
					// To display the number to entries on a page by default!!
					pageLength : 10,

					ajax : {
						url : jsonUrl,
						dataSrc : '' // Because there is no name to the
										// collection of products array in
										// Postman!!
					},
					columns : [
							{
								data : 'productCode',
								mRender : function(data, type, row) {
									return '<img src="'
											+ window.contextRoot
											+ '/resources/images/'
											+ data
											+ '.jpg" class="dataTablesImages"/>';
								}
							},
							{
								data : 'productName'
							},
							{
								data : 'productBrand'
							},
							{
								data : 'productUnitPrice',
								// To add the rupee symbol in the unit price
								// column!!
								mRender : function(data, type, row) {
									return '&#8377; ' + data;
								}
							},
							{
								data : 'productQuantity',
								mRender : function(data, type, row) {
									if (data < 1) {
										return '<span style="color:red">Out of Stock!!</span>';
									}
									return data;
								}
							},
							{
								data : 'productID',
								bSortable : false, // To remove the sort option
													// over the glyphicons!!
								mRender : function(data, type, row) {
									var str = '';
									str += '<a href = "'
											+ window.contextRoot
											+ '/show/'
											+ data
											+ '/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;'; 
									// &#160; is used
																																					// to
																																					// add
																																					// an
																																					// extra
																																					// space
																																					// between
																																					// the
																																					// glyphicons!!

									if (row.quantity < 1) {
										str += '<a href = "javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
									} else {
										str += '<a href = "'
												+ window.contextRoot
												+ '/cart/add/'
												+ data
												+ '/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
									}
									return str;
								}
							} ]
				});
	}

	// Dismissing the alert element after 10 seconds!!
	var $alert = $('.alert');
	if ($alert.length) {
		setTimeout(function() {
			$alert.fadeOut('slow');
		}, 10000)
	}

	// Toggle Switch

	// ---------------------
	// Data Table for Admin
	// ---------------------

	// $table is a jquery element, and we are getting the table using the id
	// (#productListTable) and storing in $table
	var $adminProductsTable = $('#adminProductsTable');

	// execute this code only where we have this table
	// This code will be executed only if the table length > 0
	if ($adminProductsTable.length) {
		// console.log('Inside the table');

		// if the user wants to display all products, then jsonYrl is set to
		// /json/data/all/products!!
		var jsonUrl = window.contextRoot + '/json/data/admin/all/products';

		// DataTable function is used to display the products in tabular
		// format!!
		$adminProductsTable
				.dataTable({
					// -1 is used to display all items
					lengthMenu : [
							[ 10, 30, 50, -1 ],
							[ '10 Records', '30 Records', '50 Records',
									'All Records' ] ],
					// To display the number to entries on a page by default!!
					pageLength : 30,

					ajax : {
						url : jsonUrl,
						dataSrc : '' // Because there is no name to the
										// collection of products array in
										// Postman!!
					},
					columns : [
							{
								data : 'productID'
							},
							{
								data : 'productCode',
								bSortable : false,
								mRender : function(data, type, row) {
									return '<img src="'
											+ window.contextRoot
											+ '/resources/images/'
											+ data
											+ '.jpg" class="adminDataTableImg"/>';
								}
							},
							{
								data : 'productName'
							},
							{
								data : 'productBrand'
							},
							{
								data : 'productQuantity',
								mRender : function(data, type, row) {
									if (data < 1) {
										return '<span style="color:red">Out of Stock!!</span>';
									}
									return data;
								}
							},
							{
								data : 'productUnitPrice',
								// To add the rupee symbol in the unit price
								// column!!
								mRender : function(data, type, row) {
									return '&#8377; ' + data;
								}
							},
							{
								data : 'productIsActive',
								bSortable : false,
								mRender : function(data, type, row) {

									var str = '';

									str += '<label class="switch">';

									if (data) {
										str += '<input type="checkbox" checked="checked" value="'
												+ row.productID + '"/>';
									} else {
										'<input type="checkbox" value="'
												+ row.productID + '"/>';
									}
									str += '<div class="slider"></div></label>';
									return str;

								}
							},
							{
								data : 'productID',
								bSortable : false,
								mRender : function(data, type, row) {

									var str = '';
									str += '<a href="'
											+ window.contextRoot
											+ '/manage/'
											+ data
											+ '/product" class="btn btn-warning">';
									str += '<span class="glyphicon glyphicon-pencil"></span></a>';
									return str;
								}
							} ],

					initComplete : function() {
						var api = this.api();
						api
								.$('.switch input[type="checkbox"]')
								.on(
										'change',
										function() {
											var checkbox = $(this);
											var checked = checkbox.prop('checked'); 
											
											// Returns true if checked false if unchecked!!
											var dMsg = (checked) ? 'Are you sure you want to activate the product?'
													: 'Are you sure you want to de-activate the product?';
											var value = checkbox.prop('value');

											bootbox.confirm({
														size : 'medium',
														title : 'Product Activation & De-activation',
														message : dMsg,
														callback : function(
																confirmed) {
															if (confirmed) {
																console.log(value);

																var activationUrl = window.contextRoot
																		+ '/manage/product/'
																		+ value
																		+ '/activation';
																$
																		.post(activationUrl,function(data) {
																					bootbox.alert({
																								size : 'medium',
																								title : 'Information',
																								message : data
																							});
																				});

															} else {
																checkbox.prop('checked',!checked); 
																// !check is used to go to the previous state!!
															}
														}
													})

										});
					}
				});
	}

	// -----------------------
	// jQuery Validation code for Category

	var $categoryForm = $('#categoryForm');
	if ($categoryForm.length) {

		$categoryForm.validate({

			rules : {

				categoryName : {
					required : true,
					minlength : 2
				},

				categoryDescription : {
					required : true
				}
			},

			messages : {
				
				categoryName: {
					required : 'Category Name cannot be blank!!',
					minlength : 'Category Name should be minimum 2 characters!!'
				},
				
				categoryDescription : {
					required : 'Category Description cannot be blank!!'
				}
			},
			
			errorElement: 'em',
			errorPlacement: function(error, element) {
				// Add the class of help-block!!
				error.addClass("help-block");
				
				// Add the error element after the input element!!
				error.insertAfter(element);
			}

		});
	}
	
	//----------------------------------------
	
	
	
	
	

});