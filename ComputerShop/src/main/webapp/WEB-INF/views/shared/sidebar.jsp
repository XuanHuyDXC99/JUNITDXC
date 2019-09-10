
<div class="la-width sidebar left ">
	<div class="user-panel">
		<div class="pull-left image">
			<img src="http://via.placeholder.com/160x160" class="rounded-circle"
				alt="User Image">
		</div>
		<div class="pull-left info">
			<p><%=session.getAttribute("firstNameLog")%>
				<%=session.getAttribute("lastNameLog")%></p>
			<a href="#"><i class="fa fa-circle text-success"></i> Online</a>
		</div>
	</div>
	<ul class="list-sidebar bg-defoult">
		<c:if test="${userRole == 1}">
			<li><a href="#" data-toggle="collapse" data-target="#dashboard"
				class="collapsed active"> <i class="fa fa-user"></i> <span
					class="nav-label"> User Administrator </span> <span
					class="fa fa-chevron-left pull-right"></span>
			</a>
				<ul class="sub-menu collapse" id="dashboard">
					<li class="active"><a href="${contextRoot}/alluser">All
							Users</a></li>
					<li class="active"><a href="${contextRoot}/registeruser">Register
							User</a></li>
					<!-- 									<li><a href="#">Buttons</a></li>
									<li><a href="#">Tabs & Accordions</a></li>
									<li><a href="#">Typography</a></li> -->
				</ul></li>
		</c:if>
		<!-- 		<li><a href="#"><i class="fa fa-diamond"></i> <span
				class="nav-label">Layouts</span></a></li> -->
		<li><a href="#" data-toggle="collapse" data-target="#tables"
			class="collapsed active"><i class="fa fa-user-circle-o"
				aria-hidden="true"></i> <span class="nav-label">Customer</span><span
				class="fa fa-chevron-left pull-right"></span></a>
			<ul class="sub-menu collapse" id="tables">
				<li><a href="${contextRoot}/customer/allcustomer"> Customer
						list</a></li>
				<li><a href="${contextRoot}/customer/registerCustomer"> Add
						customer</a></li>
			</ul></li>
		<li><a href="#" data-toggle="collapse" data-target="#products"
			class="collapsed active"> <i class="fa fa-list-alt"></i> <span
				class="nav-label">Category</span> <span
				class="fa fa-chevron-left pull-right"></span>
		</a>
			<ul class="sub-menu collapse" id="products">
				<c:forEach var="category" items="${categories}">
					<li class="active"><a
						href="${contextRoot}/show/category/${category.categoryId}">${category.categoryName }</a></li>
				</c:forEach>
				<!-- 				<li class="active"><a href="#">CSS3 Animation</a></li>
				<li><a href="#">General</a></li>
				<li><a href="#">Buttons</a></li>
				<li><a href="#">Tabs & Accordions</a></li>
				<li><a href="#">Typography</a></li>
				<li><a href="#">FontAwesome</a></li>
				<li><a href="#">Slider</a></li>
				<li><a href="#">Panels</a></li>
				<li><a href="#">Widgets</a></li>
				<li><a href="#">Bootstrap Model</a></li> -->
			</ul></li>
		<!-- 		<li><a href="#"><i class="fa fa-laptop"></i> <span
				class="nav-label">Grid options</span></a></li> -->

		<li><a href="#" data-toggle="collapse" data-target="#e-commerce"
			class="collapsed active"><i class="fa fa-shopping-cart"></i> <span
				class="nav-label">Product</span><span
				class="fa fa-chevron-left pull-right"></span></a>
			<ul class="sub-menu collapse" id="e-commerce">
				<li><a href="${contextRoot}/product/productlist"> Products
						list</a></li>
				<li><a href="${contextRoot}/product/add">Add Product</a></li>

			</ul></li>
		<li><a href="${contextRoot}/order"><i class="fa fa-pie-chart"></i> <span
				class="nav-label">Order</span> </a></li>
<!-- 		<li><a href="#"><i class="fa fa-files-o"></i> <span
				class="nav-label">Other Pages</span></a></li>
		<li><a href="#"><i class="fa fa-files-o"></i> <span
				class="nav-label">Other Pages</span></a></li>
		<li><a href="#"><i class="fa fa-files-o"></i> <span
				class="nav-label">Other Pages</span></a></li>
		<li><a href="#"><i class="fa fa-files-o"></i> <span
				class="nav-label">Other Pages</span></a></li>
		<li><a href="#"><i class="fa fa-files-o"></i> <span
				class="nav-label">Other Pages</span></a></li> -->
	</ul>
</div>