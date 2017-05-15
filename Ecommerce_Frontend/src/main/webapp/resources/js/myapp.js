$(function() {
	//Solving the active-menu problem!!
	//using the window.menu property of the page.jsp
	switch(menu) {
	
	case 'About Us':
		$('#about').addClass('active');
		break;
		
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
		
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
		
	default:
		if(menu == "Home")
			break;
		$('#listProducts').addClass('active');
		$('#a_'+menu).addClass('active');
		break;
	}
	
	//code for jquery dataTable!!
	
	//$table is a jquery element, and we are getting the table using the id (#productListTable) and storing in $table
	var $table = $('#productListTable');
	
	//execute this code only where we have this table 
	//This code will be executed only if the table length > 0
	if($table.length) {
		//console.log('Inside the table');
		
		//if the user wants to display all products, then jsonYrl is set to /json/data/all/products!! 
		var jsonUrl='';
		if(window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		}
		else {
			jsonUrl = window.contextRoot + '/json/data/category/'+ window.categoryId +'/products';
		}
		
		//DataTable function is used to display the products in tabular format!!
		$table.dataTable({
			//-1 is used to display all items
			lengthMenu: [[3,5,10,-1],['3 Records','5 Records','10 Records','All Records']],
			//To display the number to entries on a page by default!!
			pageLength: 10,
			
			ajax: {
				url: jsonUrl,
				dataSrc: '' //Because there is no name to the collection of products array in Postman!!
			},
			columns: [
			          {
			        	 data:'productCode',
			        	 mRender: function(data,type,row) {
			        		 return '<img src="'+ window.contextRoot +'/resources/images/'+ data +'.jpg" class="dataTablesImages"/>';
			        	 }
			          },
			          {
			        	  data:'productName'
			          },
			          {
			        	  data:'productBrand'
			          },
			          {
			        	  data:'productUnitPrice',
			        	  //To add the rupee symbol in the unit price column!!
			        	  mRender: function(data,type,row) {
			        		  return '&#8377; '+ data;
			        	  }
			          },
			          {
			        	  data:'productQuantity'
			          },
			          {
			        	  data:'productID',
			        	  bSortable:false, //To remove the sort option over the glyphicons!!
			        	  mRender: function(data,type,row) {
			        		  var str = '';
			        		  str += '<a href = "'+ window.contextRoot +'/show/'+ data +'/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;'; //&#160; is used to add an extra space between the glyphicons!!
			        		  str += '<a href = "'+ window.contextRoot +'/cart/add/'+ data +'/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
			        		  return str;
			        	  }
			          }
			          ]
		});
	}
	
});