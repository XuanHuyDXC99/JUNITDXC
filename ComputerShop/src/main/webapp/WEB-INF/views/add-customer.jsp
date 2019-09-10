
<div class="student_form col-md-4">
	<div class="card text-dark">
		<div class="card-header bg-primary">
			<h3 align="center">
				<i class="fa fa-user-plus"></i> Register Customer
			</h3>
		</div>
		<div class="panel-body">
			<c:if test="${customer.id != null}">
				<form action="<%=request.getContextPath()%>/customer/updateCustomer"
					method="post">
			</c:if>
			<c:if test="${customer.id == null}">
				<form action="<%=request.getContextPath()%>/customer/addCustomer"
					method="post">
			</c:if>
			<div class="form-group">
				<label for="id">Customer ID: </label> <input value="${customer.id}"
					name="id" type="text" class="form-control" id="id"
					<c:if test="${customer.id == null}">disabled="1"</c:if>" readonly="1">
			</div>

			<div class="form-group">
				<label for="name">Name:</label> <input
					value="${customer.customerName}" name="name" type="text"
					class="form-control" id="name">
			</div>
			<div class="form-group">
				<label for="birthday">Birthday: </label> <input
					value="${customer.birthday}" name="birthday" type="date"
					class="form-control" id="birthday">
			</div>
			<div class="form-group">
				<label for="address">Address:</label> <input
					value="${customer.address}" name="address" type="text"
					class="form-control" id="address">
			</div>
			<div class="form-group">
				<label for="email">Email:</label> <input
					value="${customer.email}" name="email" type="text"
					class="form-control" id="email">
			</div>
			<div class="form-group">
				<label for="phone">Phone:</label> <input
					value="${customer.phoneNumber}" name="phone" type="text"
					class="form-control" id="phone">
			</div>
			<label for="sex">Sex: </label>
			<div class="form-check form-check-inline">
				<input class="form-check-input" type="radio" name="sex" id="sex"
					value="male" checked> <label class="form-check-label"
					for="sex">Male</label>
			</div>
			<c:if test="${customer.id != null}">
				<button type="submit" class="btn btn-warning">
					<i class="fa fa-edit"></i> Update
				</button>
				<a href="<%=request.getContextPath()%>/customer"
					class="btn btn-primary pull-right"><i class="fa fa-user-plus"></i>
					New</a>
			</c:if>

			<c:if test="${customer.id == null}">
				<button type="submit" class="btn btn-success">
					<i class="fa fa-send"></i> Submit
				</button>
			</c:if>
			</form>

		</div>
		<div class="card-footer"></div>
	</div>
</div>