<div class="header col-lg-auto" style="margin-top: 50px;">
	<table
		class="table table-bordered table-responsive-lg table-striped w-auto la-table">
		<thead>
			<tr>
				<th colspan="14" style="text-align: center;"><h2>
						<i class="fa fa-users"></i> Product List
					</h2></th>
			</tr>
			<tr>
				<th>Id</th>
				<th>Product Name</th>
				<th>Price</th>
				<th>Category</th>
				<th>Brand</th>
				<th>Quantity</th>
				<th colspan="2">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="row" items="${products}">
				<tr>
					<td>${row.pid}</td>
					<td>${row.pName}</td>
					<td>${row.price}</td>
					<td>${row.category.categoryName}</td>
					<td>${row.brand.brandName}</td>
					<td>${row.quantity}</td>
					<td><a href="${contextRoot}/product/editProduct/${row.pid}"
						class="btn btn-warning"><i class="fa fa-edit"></i> Edit</a></td>
					<td><a
						onclick="return confirm('Are you want to delete this item?')"
						href="${contextRoot}/product/deleteProduct/${row.pid}" class="btn btn-danger"><i
							class="fa fa-trash"></i> Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>