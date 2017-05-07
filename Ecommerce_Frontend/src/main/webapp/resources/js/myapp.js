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
		break;
	}
});