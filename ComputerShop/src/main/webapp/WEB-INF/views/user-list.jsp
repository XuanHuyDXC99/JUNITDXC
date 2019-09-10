<!-- CUSTOMER LIST -->
<div class="header col-lg-auto" style="margin-top: 50px;">
	<table
		class="table table-bordered table-responsive-lg table-striped w-auto la-table">
		<thead>
			<tr>
				<th colspan="14" style="text-align: center;"><h2>
						<i class="fa fa-users"></i> User List
					</h2></th>
			</tr>
			<tr>
				<th>Id</th>
				<th>User Name</th>
				<th>Password</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Position</th>
				<th>Birthday</th>
				<th>Start Date</th>
				<th>Address</th>
				<th>Identity ID</th>
				<th>Sex</th>
				<th>Phone</th>
				<th colspan="2">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="row" items="${users}">
				<tr>
					<td>${row.id}</td>
					<td>${row.userName}</td>
					<td>${row.passWord}</td>
					<td>${row.firstName}</td>
					<td>${row.lastName}</td>
					<c:choose>
						<c:when test="${row.userRole == 1 }">
							<td>Manager</td>
						</c:when>
						<c:when test="${row.userRole == 2 }">
							<td>Employee</td>
						</c:when>
					</c:choose>
					<td>${row.birthday}</td>
					<td>${row.dayToWork}</td>
					<td>${row.address}</td>
					<td>${row.peopleId}</td>
					<c:choose>
						<c:when test="${row.sex == true }">
							<td>Male</td>
						</c:when>
						<c:when test="${row.sex == false }">
							<td>Female</td>
						</c:when>
					</c:choose>
					<td>${row.phoneNumber}</td>
					<td><a href="${contextRoot}/editUser/${row.id}"
						class="btn btn-warning"><i class="fa fa-edit"></i> Edit</a></td>
					<td><a
						onclick="return confirm('Are you want to delete this item?')"
						href="${contextRoot}/deleteUser/${row.id}" class="btn btn-danger"><i
							class="fa fa-trash"></i> Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>