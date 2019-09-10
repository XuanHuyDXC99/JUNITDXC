<div class="student_form col-md-4" style="color: black;">
	<div class="card" style="width: 700px">
		<div class="card-header">
			<h3 align="center">
				<i class="fa fa-user-plus"></i>Register User
			</h3>
		</div>
		<div class="card-body">
			<c:if test="${user.id != null}">
				<form action="${contextRoot}/updateUser" method="post">
			</c:if>
			<c:if test="${user.id == null}">
				<form action="${contextRoot}/adduser" method="post">
			</c:if>
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label for="id">User ID: </label> <input value="${user.id}"
							name="id" type="text" class="form-control" id="id"
							<c:if test="${user.id == null}">disabled="1"</c:if>" readonly="1">
					</div>
					<div class="form-group">
						<label for="firstname">FirstName: </label> <input
							value="${user.firstName}" name="firstname" type="text"
							class="form-control" id="firstname">
					</div>
					<div class="form-group">
						<label for="lastname">LastName: </label> <input
							value="${user.lastName}" name="lastname" type="text"
							class="form-control" id="lastname">
					</div>
					<div class="form-group">
						<label for="name">User Name: </label> <input
							value="${user.userName}" name="name" type="text"
							class="form-control" id="name">
					</div>
					<div class="form-group">
						<label for="pass">Password: </label> <input
							value="${user.passWord}" name="pass" type="password"
							class="form-control" id="pass">
					</div>
					<div class="form-group">
						<label for="role">Position: </label>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="role"
								id="role" value="manager" checked> <label
								class="form-check-label" for="role">Manager</label>
						</div>
						<div class="form-check form-check-inline" style="margin-left: 0">
							<input class="form-check-input" type="radio" name="role"
								id="role" value="emloyee"> <label
								class="form-check-label" for="role">Employee</label>
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label for="address">Address: </label> <input
							value="${user.address}" name="address" type="text"
							class="form-control" id="address">
					</div>
					<div class="form-group">
						<label for="phone">Phone: </label> <input
							value="${user.phoneNumber}" name="phone" type="text"
							class="form-control" id="phone">
					</div>
					<div class="form-group">
						<label for="bday">Birthday: </label> <input
							value="${user.birthday}" name="bday" type="date"
							class="form-control" id="bday">
					</div>
					<div class="form-group">
						<label for="startDate">Start Date: </label> <input
							value="${user.dayToWork}" name="startDate" type="date"
							class="form-control" id="startDate">
					</div>
					<div class="form-group">
						<label for="identityId">Identity ID: </label> <input
							value="${user.peopleId}" name="identityId" type="text"
							class="form-control" id="identityId">
					</div>
					<label for="role">Sex: </label>
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio" name="sex" id="sex"
							value="male" checked> <label class="form-check-label"
							for="role">Male</label>
					</div>
					<div class="form-check form-check-inline" style="margin-left: 0">
						<input class="form-check-input" type="radio" name="sex" id="sex"
							value="female"> <label class="form-check-label"
							for="role">Female</label>
					</div>
				</div>
			</div>

			<c:if test="${user.id != null}">
				<button type="submit" class="btn btn-warning">
					<i class="fa fa-edit"></i> Update
				</button>
				<a href="${contextRoot}/registeruser"
					class="btn btn-primary pull-right"><i class="fa fa-user-plus"></i>
					New</a>
			</c:if>

			<c:if test="${user.id == null}">
				<button type="submit" class="btn btn-success"
					style="margin-left: 280px">
					<i class="fa fa-send"></i> Submit
				</button>
			</c:if>
			</form>
		</div>
		<div class="card-footer"></div>
	</div>
</div>