<div class="col-sm-12">

				<div class="card">
					<div class="card-header bg-primary"></div>
					<div class="card-body">
						<div class="col-sm-4">
							Order No: <input name="orderId" type="text" class="form-control"
								ng-model="orderId" ng-init="orderId=${orderNo}" value="${orderNo}" />
						</div>
						<div class="col-sm-4">
							Order Date: <input ng-init="orderDate" ng-model="orderDate" name="orderDate"
								type="date" class="form-control" />
						</div>
					</div>
				</div>

			</div>





			<div class="col-sm-12">
				<div class="row">Select Product
					<div class="col-sm-4" style="height: 360px;">
						<div class="card text-dark" style="height: 100%">
							<div class="card-header bg-primary">
								<i class="fa fa-product-hunt"></i> Select Product
							</div>
							<div class="card-body">
								<div class="form-group">
									<label for="Product Name">Product Name:</label> <select
										name="pName" class="form-control" ng-model="clickedProduct"
										ng-options="product.pName for product in products">
									</select>
								</div>
								<div class="form-group">
									<label for="pid">Product ID: </label> <input readonly="1"
										name="pid" type="text" class="form-control" id="pid"
										value="{{clickedProduct.pid}}">
								</div>
								<div class="form-group">
									<label for="price">Price: </label> <input readonly="1"
										name="price" type="text" class="form-control" id="price"
										value="{{clickedProduct.price}}">
								</div>
								<div class="form-group">
									<label for="quantity">Stock: </label> <input readonly="1" name="quantity"
										type="text" class="form-control" id="quantity"
										value="{{clickedProduct.quantity}}">
								</div>
							</div>
						</div>
					</div>
					<div class="col-sm-4" style="height: 360px;">
						<div class="card text-dark" style="height: 100%">
							<div class="panel-header bg-primary">
								<i class="fa fa-user-circle"></i> Select Customer
							</div>
							<div class="card-body">
								<div class="form-group">
									<label for="Customer Name">Customer Name:</label> <select
										name="customerName" class="form-control" ng-model="clickedCustomer"
										ng-options="customer.customerName for customer in customers">
									</select>
								</div>
								<div class="form-group">
									<label for="id">Customer ID: </label> <input readonly="1"
										name="id" type="text" class="form-control" id="id"
										value="{{clickedCustomer.id}}">
								</div>
								<div class="form-group">
									<label for="phone">Phone: </label> <input readonly="1"
										name="phoneNumber" type="text" class="form-control" id="phoneNumber"
										value="{{clickedCustomer.phoneNumber}}">
								</div>
							</div>
						</div>
					</div>
					<div class="col-sm-4" style="height: 360px;">
						<div class="card text-dark" style="height: 100%">
							<div class="card-header">
								<i class="fa fa-sellsy"></i> Order Details
							</div>
							<div class="card-body">
								<div class="form-group" ng-show="clickedProduct.pid != null">
									<label for="qty">Quantity:</label> <input readonly="1"
										name="orderQty" ng-model="quantity" ng-init="quantity=1" type="text"
										class="form-control" id="quantity" placeholder="Enter Quantity">
								</div>
								<div class="form-group"
									ng-show="quantity != 0 && clickedProduct.pid != null">
									<label for="total">Total:</label> <input readonly="1"
										name="total" value="{{clickedProduct.price * quantity}}"
										type="text" class="form-control" id="total">
								</div>
								<div class="form-group"
									ng-show="clickedProduct.pid != null && clickedCustomer.id != null">
									<button ng-click="addToCart()" type="submit"
										class="btn btn-success">
										<i class="fa fa-cart-plus"></i> Add To Cart
									</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="col-sm-12" style="text-align: center; margin-top: 20px;">
				<div class="card text-dark">
					<div class="card-header">
						<h3>
							<i class="fa fa-cart-plus"></i> Cart
							<button class="btn btn-sm btn-success">
								{{cartProduct.length}}</button>
						</h3>
					</div>
					<div class="card-body">
						<table class="table table-bordered table-striped table-responsive">
							<thead>
								<tr>
									<th>S.No</th>
									<th>Product Name</th>
									<th>Price</th>
									<th>Quantity</th>
									<th>Action</th>
									<th>Total</th>
								</tr>
							</thead>
							<tbody>
								<tr ng-repeat="product in cartProduct">
									<td>{{$index + 1}}</td>
									<td>{{product.pName}}</td>
									<td>{{product.price}}</td>
									<td>
										<button type="button" ng-click="decreaseQty(product)"
											class="btn btn-danger">
											<i class="fa fa-minus"></i>
										</button> &nbsp; &nbsp; {{product.cartQty}} &nbsp; &nbsp;
										<button type="button" ng-click="increaseQty(product)"
											class="btn btn-success">
											<i class="fa fa-plus"></i>
										</button>
									</td>
									<td><button ng-click="removeProduct(product)"
											class="btn btn-danger">
											<i class="fa fa-remove"></i> Remove
										</button></td>
									<td>{{product.subTotal}}</td>
								</tr>
							</tbody>
							<tfoot>
								<tr ng-show="cartProduct.length != 0">
									<td colspan="5" style="text-align: right">Final Total:</td>
									<td>{{finalTotal}}</td>
								</tr>
								<tr ng-show="cartProduct.length != 0">
									<td colspan="6" style="text-align: right">
										<button data-toggle="modal" data-target="#checkoutModal"
											type="button" ng-show="cartProduct.length != 0"
											class="btn btn-success">
											<i class="fa fa-check"></i> Check Out
										</button>
									</td>
								</tr>
							</tfoot>
						</table>
					</div>
				</div>
			</div>



		<!-- checkoutModal -->
		<div id="checkoutModal" class="modal fade" role="dialog">
			<div class="modal-dialog modal-lg">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title" align="center">
							<i class="fa fa-eye"></i> Review Your Order
						</h4>
					</div>
					<div class="modal-body">
						<table class="table table-bordered table-striped">
							<tr>
								<td>Order ID</td>
								<td>{{orderId}}</td>
							</tr>
							<tr>
								<td>Order Date</td>
								<td>{{orderDate | date}}</td>
							</tr>
							<tr>
								<td>Customer ID</td>
								<td>{{clickedCustomer.customerId}}</td>
							</tr>
							<tr>
								<td>Total Amount</td>
								<td>{{finalTotal}}</td>
							</tr>
						</table>
						<br /> <br /> <br /> Order Details: <br />
						<table class="table table-bordered table-striped">
							<thead>
								<tr>
									<th>NO</th>
									<th>Product Name</th>
									<th>Price</th>
									<th>Qty</th>
									<th>Total</th>
								</tr>
							</thead>
							<tbody>
								<tr ng-repeat="product in cartProduct">
									<td>{{$index + 1}}</td>
									<td>{{product.pName}}</td>
									<td>{{product.price}}</td>
									<td>{{product.cartQty}}</td>
									<td>{{product.price * product.quantity}}</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="modal-footer">
						<button data-toggle="modal" data-target="#messageModal"
							ng-click="checkOut()" type="button" class="btn btn-success"
							data-dismiss="modal">
							<i class="fa fa-check"></i> Confirm
						</button>
						<button type="button" class="btn btn-danger" data-dismiss="modal">
							<i class="fa fa-times"></i> Cancel
						</button>
					</div>
				</div>

			</div>
		</div>


		<!-- Modal -->
		<div id="messageModal" class="modal fade" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title" align="center">Congratulation</h4>
					</div>
					<div class="modal-body">
						<h1 style="color: green; text-align: center">Order Complete
							Successfully</h1>
					</div>
					<div class="modal-footer">
						<a href="<%=request.getContextPath()%>/home" class="btn btn-default">Close</a>
					</div>
				</div>

			</div>
		</div>