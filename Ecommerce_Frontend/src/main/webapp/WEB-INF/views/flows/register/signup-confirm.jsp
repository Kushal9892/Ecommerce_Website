<%@include file="../shared/flows-header.jsp" %>			
	
	<div class="container">
		
		<div class="row">
		
			<!-- Column to display personal details -->
			<div class="col-sm-6">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h4>Personal Details</h4>
					</div>
					
					<div class="panel-body">
						<!-- Code to display personal details -->
						<div class="text-center">
							<h4>${registerModel.user.userFirstName} ${registerModel.user.userLastName}</h4>
							<h5>Email: ${registerModel.user.userEmail}</h5>
							<h5>Contact Number: ${registerModel.user.userContactNumber}</h5>
							<h5>Role: ${registerModel.user.userRole}</h5>
						</div>
						
					</div>
					
					<div class="panel-footer">
						
						<!-- Anchor to move to the edit of personal details -->
						<a href="${flowExecutionUrl}&_eventId_personal" class="btn btn-primary">Edit</a>
						
					</div>
					
				</div>
			
			</div>
			
			<!-- Column to display the address -->
			<div class="col-sm-6">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h4>Address Details</h4>
					</div>
					
					<div class="panel-body">
						<!-- Code to display Address details -->
						<div class="text-center">
							<h4>${registerModel.billing.addressLineOne} ${registerModel.billing.addressLineTwo}</h4>
							<h5>City: ${registerModel.billing.city}</h5>
							<h5>Postal Code: ${registerModel.billing.postalCode}</h5>
							<h5>State: ${registerModel.billing.state}</h5>
							<h5>Country: ${registerModel.billing.country}</h5>
						</div>
					</div>
					
					<div class="panel-footer">
						
						<!-- Anchor to move to the edit of Address details -->
						<a href="${flowExecutionUrl}&_eventId_billing" class="btn btn-primary">Edit</a>
						
					</div>
					
				</div>
			
			</div>
			
		</div>
		
		<!-- Confirm button after displaying the details -->
		<div class="row">
			<div class="col-sm-4 col-sm-offset-4">
				<div class="text-center">
					
					<!-- Anchor to move to the success page!! -->
					<a href="${flowExecutionUrl}&_eventId_submit" class="btn btn-primary">Confirm</a>
					
				</div>
			</div>
		</div>
						
	</div>
	
<%@include file="../shared/flows-footer.jsp"%>