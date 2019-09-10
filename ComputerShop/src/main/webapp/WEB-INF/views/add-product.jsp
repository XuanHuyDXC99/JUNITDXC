<div class="student_form col-md-4">
	<div class="card text-dark">
		<div class="card-header bg-primary">
			<h3 align="center">
				<i class="fa fa-product-hunt"></i> Insert Product
			</h3>
		</div>
		<div class="panel-body">
			<c:if test="${product.pid != null}">
				<form action="<%=request.getContextPath()%>/product/updateProduct"
					method="post">
			</c:if>
			<c:if test="${product.pid == null}">
				<form action="<%=request.getContextPath()%>/product/addProduct"
					method="post">
			</c:if>
			<div class="form-group">
				<label for="pid">Product ID: </label> <input value="${product.pid}"
					name="pid" type="text" class="form-control" id="pid"
					<c:if test="${product.pid == null}">disabled="1"</c:if>" readonly="1">
			</div>

			<div class="form-group">
				<label for="pname">Product Name:</label> <input
					value="${product.pName}" name="pname" type="text"
					class="form-control" id="pname">
			</div>

			<div class="form-group">
				<label for="price">Price:</label> <input value="${product.price}"
					name="price" type="text" class="form-control" id="price">
			</div>
			<div class="form-group">
				<label for="category">Category: </label> <select name="category" value="${product.category.categoryName }"
					class="form-control" id="category">
					<c:forEach var="row" items="${categories}">
						<option>${row.categoryName }</option>
					</c:forEach>
					
				</select>
			</div>
			<div class="form-group">
				<label for="brand">Brand: </label> <select name="brand" value="${product.brand.brandName }"
					class="form-control" id="brand">
					<c:forEach var="row" items="${brands}">
						<option>${row.brandName }</option>
					</c:forEach>
					
				</select>
			</div>
			<div class="form-group">
				<label for="qty">Quantity:</label> <input value="${product.quantity}"
					name="qty" type="text" class="form-control" id="qty">
			</div>

			<c:if test="${product.pid != null}">
				<button type="submit" class="btn btn-warning">
					<i class="fa fa-edit"></i> Update
				</button>
				<a href="<%=request.getContextPath()%>/product"
					class="btn btn-primary pull-right"><i class="fa fa-user-plus"></i>
					New</a>
			</c:if>

			<c:if test="${product.pid == null}">
				<button type="submit" class="btn btn-success">
					<i class="fa fa-send"></i> Submit
				</button>
			</c:if>


			</form>

		</div>
		<div class="card-footer"></div>
	</div>
</div>