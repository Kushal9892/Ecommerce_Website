<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<%@include file="../shared/flows-header.jsp"%>

<div class="container">

	<div class="row">

		<div class="col-md-6 col-md-offset-3">

			<div class="panel panel-primary">

				<div class="panel-heading">
					<h4>Sign Up - Personal</h4>
				</div>

				<div class="panel-body">
					<sf:form method="POST" class="form-horizontal" id="registerForm"
						modelAttribute="user">

						<div class="form-group">
							<label class="control-label col-md-4">First Name</label>
							<div class="col-md-8">
								
								<!-- The 'path' field belongs to the defined fields in User.java file -->
								<sf:input type="text" path="userFirstName" class="form-control"
									placeholder="First Name" />
									
								<sf:errors path="userFirstName" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Last Name</label>
							<div class="col-md-8">
								
								<!-- The 'path' field belongs to the defined fields in User.java file -->
								<sf:input type="text" path="userLastName" class="form-control" placeholder="Last Name" />
									
								<sf:errors path="userLastName" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Email</label>
							<div class="col-md-8">
								
								<!-- The 'path' field belongs to the defined fields in User.java file -->
								<sf:input type="text" path="userEmail" class="form-control" placeholder="abc.xyz.com" />
									
								<sf:errors path="userEmail" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Contact Number</label>
							<div class="col-md-8">
								
								<!-- The 'path' field belongs to the defined fields in User.java file -->
								<sf:input type="text" path="userContactNumber" class="form-control" placeholder="Mobile Number" maxlength="10" />
									
								<sf:errors path="userContactNumber" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Password</label>
							<div class="col-md-8">
								
								<!-- The 'path' field belongs to the defined fields in User.java file -->
								<sf:input type="password" path="userPassword"
									class="form-control" placeholder="Password" />
									
								<sf:errors path="userPassword" cssClass="help-block" element="em" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4">Confirm Password</label>
							<div class="col-md-8">
								
								<!-- The 'path' field belongs to the defined fields in User.java file -->
								<sf:input type="password" path="userConfirmPassword"
									class="form-control" placeholder="Password" />
									
								<sf:errors path="userConfirmPassword" cssClass="help-block" element="em" />
							</div>
						</div>

						<!-- Radio Buttons using bootstrap class of radio-inline -->
						<div class="form-group">
							<label class="control-label col-md-4">Select Role</label>
							<div class="col-md-8">
								
								<label class="radio-inline">
									<sf:radiobutton path="userRole" value="USER" checked="checked" />User
								</label>
								<label class="radio-inline">
									<sf:radiobutton path="userRole" value="SUPPLIER" />Supplier
								</label>
								
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<button type="submit" class="btn btn-primary"
									name="_eventId_billing">
									Next - Billing <span class="glyphicon glyphicon-chevron-right"></span>
								</button>

								<!-- Submit button inside form -->
							</div>
						</div>

					</sf:form>
				</div>

			</div>

		</div>

	</div>

</div>

<%@include file="../shared/flows-footer.jsp"%>