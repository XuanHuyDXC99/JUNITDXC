var myApp = angular.module("myApp", []);

myApp.controller("appCtrl", function($scope, $http) {

	$scope.orderId = "";
	$scope.orderDate = new Date();
	$scope.finalTotal = 0;

	$scope.products = [];
	$scope.getAllProduct = function() {
		$http({
			method : 'GET',
			url : 'productr/allProduct'
		}).then(function(response) {
			$scope.products = response.data;
		});
	};

	$scope.getAllProduct();

	$scope.clickedProduct = {};

	$scope.getAllCustomer = function() {
		$http({
			method : 'GET',
			url : 'customerr/allCustomer'
		}).then(function(response) {
			$scope.customers = response.data;
		});
	}

	$scope.getAllCustomer();

	$scope.clickedCustomer = {};

	$scope.quantity = 0;
	$scope.total = 0;

	// add to cart
    $scope.cartProduct = [];
    $scope.finalTotal = 0;
    $scope.addToCart = function () {

        $scope.cp = {};
        $scope.cp = $scope.clickedProduct;
        $scope.cp.cartQty = 1;
        $scope.cp.subTotal = $scope.cp.cartQty * $scope.cp.price;
        

        if ($scope.cartProduct.length === 0) {
            $scope.cartProduct.push($scope.cp);
            $scope.finalTotal += $scope.cp.subTotal;
            // alert("first insert");
        } else if ($scope.cartProduct.length > 0) {
            for (var i = 0; i < $scope.cartProduct.length; i++) {
                if ($scope.cartProduct[i].pid === $scope.cp.pid) {
                    alert("Item already available in Cart");
                    break;
                }
            }
            if (i === $scope.cartProduct.length) {
                $scope.cartProduct.push($scope.cp);
                $scope.finalTotal += $scope.cp.subTotal;
            }
        }

    };
    // remove from cart
    $scope.rCkickedProduct = {};
    $scope.removeProduct = function (product) {
        $scope.removableProduct = product;
        $scope.value = -1;
        // alert($scope.cartProduct.indexOf($scope.rClickedProduct));
        $scope.value = $scope.cartProduct.indexOf($scope.removableProduct);
        if ($scope.value >= 0) {
            $scope.cartProduct.splice($scope.value, 1);
        }
    };
    
 // CheckOut

    $scope.checkOut = function () {
        $scope.orderDetails = {'orderDetailId': '', 'quantity': '','price': '', 'orderId': '','productId': ''};
        $scope.order = {'orderId': '', 'total': '', 'orderDate': '','userId': '','customerId': ''};


        // make order perform
        $scope.order.customerId = $scope.clickedCustomer.id;
        $scope.order.total = $scope.finalTotal;
        $scope.order.orderDate = new Date();
        $scope.order.userId = 1;
        $http({
            method: 'POST',
            url: 'orders/order',
            data: angular.toJson($scope.order),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(function (response) {
            $scope.os = 1;
        }, function (reason) {
            $scope.oe = 0;
        });
        // make order details perform
        for (var i = 0; i < $scope.cartProduct.length; i++) {
            $scope.orderDetails.orderId= $scope.orderId;
            $scope.orderDetails.productId = $scope.cartProduct[i].pid;
            $scope.orderDetails.price = $scope.cartProduct[i].price;
            $scope.orderDetails.quantity = $scope.cartProduct[i].cartQty;
            // alert("loop: " + (i + 1));
            $http({
                method: 'POST',
                url: 'orderdetails/orderdetail',
                data: angular.toJson($scope.orderDetails),
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(function (response) {
                $scope.ods = 1;
            }, function (reason) {
                $scope.ode = 0;
            });
         // make product update perform
            $scope.updatedProduct = {'pid': '', 'pName': '', 'price': '', 'quantity': '','category': '','brand': ''};

            // alert($scope.productsAgain.length);
            for (var j = 0; j < $scope.productsAgain.length; j++) {
                // alert("enter to loop");
                if ($scope.productsAgain[j].pid === $scope.orderDetails.pid) {
                    // alert("product stock: " + $scope.productsAgain[i].qty);
                    // alert("cart qty: " + $scope.orderDetails.qty);
                
                    $scope.changedQty = $scope.productsAgain[j].quantity - $scope.orderDetails.quantity;
                

                    // alert("changable qty: " + $scope.changedQty);
                    $scope.updatedProduct.pid = $scope.productsAgain[j].pid;
                    $scope.updatedProduct.pName = $scope.productsAgain[j].pName;
                    $scope.updatedProduct.price = $scope.productsAgain[j].price;
                    $scope.updatedProduct.quantity = $scope.changedQty;
                }
            }
            $http({
                method: 'PUT',
                url: 'productr/product',
                data: angular.toJson($scope.updatedProduct),
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(function (response) {
                $scope.ps = 1;
            }, function (reason) {
                $scope.pe = 0;
            });
    }
    };


    // safty
    $scope.productsAgain = [];
    $scope.productAgainRequest = function () {
        $http({
            method: 'GET',
            url: 'productr/allProduct'
        }).then(function (response) {
            $scope.productsAgain = response.data;
        });
    };
    $scope.productAgainRequest();
    // increase and decrease cart product qty
    $scope.increaseQty = function (product) {
        // alert("hi");
        $scope.qtyChangedProduct = product;
        $scope.qtyChangedProduct.cartQty = parseInt($scope.qtyChangedProduct.cartQty) + 1;
        for (var i = 0; i < $scope.cartProduct.length; i++) {
            if ($scope.cartProduct[i].pid === $scope.qtyChangedProduct.pid) {
                $scope.cartProduct[i].cartQty = $scope.qtyChangedProduct.cartQty;
            }
        }

        $scope.finalTotal = 0;
        for (var i = 0; i < $scope.cartProduct.length; i++) {
            $scope.finalTotal = $scope.finalTotal + ($scope.cartProduct[i].price * $scope.cartProduct[i].cartQty);
        }
    };

    $scope.decreaseQty = function (product) {
        $scope.qtyChangedProduct = product;
        $scope.qtyChangedProduct.cartQty = parseInt($scope.qtyChangedProduct.cartQty) - 1;
        if ($scope.qtyChangedProduct.cartQty < 1) {
            $scope.qtyChangedProduct.cartQty = 1;
        }
        for (var i = 0; i < $scope.cartProduct.length; i++) {
            if ($scope.cartProduct[i].pid === $scope.qtyChangedProduct.pid) {
                $scope.cartProduct[i].cartQty = $scope.qtyChangedProduct.cartQty;
            }
        }

        $scope.finalTotal = 0;
        for (var i = 0; i < $scope.cartProduct.length; i++) {
            $scope.finalTotal = $scope.finalTotal + ($scope.cartProduct[i].price * $scope.cartProduct[i].cartQty);
        }
    };
	
});