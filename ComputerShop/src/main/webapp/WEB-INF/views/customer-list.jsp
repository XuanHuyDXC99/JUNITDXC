<div class="header col-lg-auto" style="margin-top: 50px;">
	<table
		class="table table-bordered table-responsive-lg table-striped w-auto la-table">
		<thead>
			<tr>
				<th colspan="14" style="text-align: center;"><h2>
						<i class="fa fa-users"></i> Customer List
					</h2></th>
			</tr>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Birthday</th>
				<th>Address</th>
				<th>Email</th>
				<th>Sex</th>
				<th>Phone</th>
				<th colspan="2">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="row" items="${customers}">
				<tr>
					<td>${row.id}</td>
					<td>${row.customerName}</td>
					<td>${row.birthday}</td>
					<td>${row.address}</td>s
					<td>${row.email}</td>
					<c:choose>
						<c:when test="${row.sex == true }">
							<td>Male</td>
						</c:when>
						<c:when test="${row.sex == false }">
							<td>Female</td>
						</c:when>
					</c:choose>
					<td>${row.phoneNumber}</td>
					<td><a href="${contextRoot}/customer/editCustomer/${row.id}"
						class="btn btn-warning"><i class="fa fa-edit"></i> Edit</a></td>
					<td><a
						onclick="return confirm('Are you want to delete this item?')"
						href="${contextRoot}/customer/deleteCustomer/${row.id}" class="btn btn-danger"><i
							class="fa fa-trash"></i> Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>