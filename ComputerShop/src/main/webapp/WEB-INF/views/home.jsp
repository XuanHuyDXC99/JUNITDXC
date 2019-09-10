<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css"></spring:url>
<spring:url var="js" value="/resources/js"></spring:url>
<spring:url var="img" value="/resources/img"></spring:url>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html ng-app="myApp">
<head>
<meta charset="ISO-8859-1">
<title>Home</title>

<link rel="stylesheet" href="${css}/bootstrap.css">

<link rel="stylesheet" type="text/css" href="${css}/font-awesome.css" />
<link rel="stylesheet" href="${css}/flexdis.css">
<link rel="stylesheet" href="${css}/footer.css">
<link rel="stylesheet" href="${css}/menu.css">


<script type="text/javascript" src="${js}/jquery.min.js"></script>
<script type="text/javascript" src="${js}/bootstrap.js"></script>
<script type="text/javascript" src="${js}/angular.min.js"></script>
<script type="text/javascript" src="${js}/order.js"></script>
<script type="text/javascript" src="${js}/menu.js"></script>
</head>
<body ng-controller="appCtrl">
	<div class="wrapper-main">
		<!--    HEADER    -->
		<%@ include file="shared/header.jsp"%>
		<!-- 	END HEADER -->

		<div class="containerflex">
			<div class="flex-grid">
				<aside class="col1 sidebar1">
					<!-- SIDEBAR -->
					<%@ include file="shared/sidebar.jsp"%>
					<!-- END SIDEBAR -->
				</aside>
				<section class="col1 main">
					<c:if test="${userClickRegister==true || userClickEdit == true}">
						<!--	REGISTER FORM -->
						<%@ include file="register-user.jsp"%>
						<!-- END REIGTER FORM -->
					</c:if>

					<c:if test="${userClickAllUser==true}">
						<!-- USER LIST -->
						<%@ include file="user-list.jsp"%>
						<!-- END USER LIST -->
					</c:if>

					<c:if test="${userClickAllProduct==true }">
						<!-- PRODUCT LIST -->
						<%@ include file="product-list.jsp"%>
						<!-- END PRODUCT -->
					</c:if>

					<c:if
						test="${userClickAddProduct==true || userClickEditProduct == true}">
						<!-- FORM PRODUCT -->
						<%@ include file="add-product.jsp"%>
						<!-- END FORM PRODUCT -->
					</c:if>

					<c:if test="${userClickListCustomer == true}">
						<!-- CUSTOMER LIST -->
						<%@ include file="customer-list.jsp"%>
						<!-- END FORM CUSTOMER LIST -->
					</c:if>

					<c:if
						test="${userClickAddCustomer == true || userClickEditCustomer==true}">
						<!-- CUSTOMER LIST -->
						<%@ include file="add-customer.jsp"%>
						<!-- END FORM CUSTOMER LIST -->
					</c:if>
					<c:if test="${userClickOrder == true}">
						<!-- CUSTOMER LIST -->
						<%@ include file="order.jsp"%>
						<!-- END FORM CUSTOMER LIST -->
					</c:if>
				</section>
			</div>
		</div>
	</div>

	<!-- FOOTER -->
	<%@ include file="shared/footer.jsp"%>


</body>
</html>