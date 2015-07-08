'use strict';


storeApp.controller('storeController',  function ($scope, $routeParams, DataService, $http,$resource, $location) {

	// get store and cart from service
	$scope.store = DataService.store;

	$scope.cart = DataService.cart;
	
	// This variable for pagination 
	 $scope.currentPage = 1;
	  $scope.pageSize = 3;

	// use routing to pick the selected product
	if ($routeParams.productSku != null) {
		$scope.product = $scope.store.getProduct($routeParams.productSku);
	}
	
	var UserObject = [];

	// This method is for user login
	$scope.userLoginfunc = function(uname, password) {
		if (uname == undefined || password == undefined) {
		} else {
			 $http.get('http://localhost:8080/com.sogeti.user/userLogin'+'/'+ uname +'/'+ password).
		     success(function(data) {
		         if (data.firstName == null) {
						alert("Username or password is incorrect, Please try once again or Register");
						$scope.uname = "";
						$scope.password = "";

					} else {
						$location.path("cart");
						console.log("response "
								+ JSON.stringify(data));
						$("#userNameId").val(
								"Welcome " + data.firstName);
						$('#userNameId').show();
						UserObject[0] = new userDetails(
								data.userId, data.firstName,
								data.middleName, data.lastName,
								data.addressLine1,
								data.addressLine2, data.city,
								data.state);
						console.log("inside UserObject "
								+ UserObject);
						$scope.cart.userDetails = UserObject;
					}
		    });
		}

	};

	// This method is for user registration
	$scope.newUserRegistration = function(firstname,lastname,username,password) {
		var flag = true;
		if (firstname == undefined
				|| lastname == undefined || username == undefined 
				|| password == undefined) {

			alert("Please enter all the fields");
			flag = false;

		}
		if (firstname != undefined 
				&& lastname != undefined 
				&&  username == undefined
				&& password != undefined ) {

			flag = false;

		}
		if (flag == true) {
			$http.get('http://localhost:8080/com.sogeti.user/addNewUser' + '/' + firstname + '/' + lastname +  '/'
					+ username + '/' + password).success(function(data) {
				alert("Registered Successfully")
				$location.path("cart");
				console.log("newUserDetails response " + JSON.stringify(data));
				$scope.store = DataService.store;

			});
		}
	};

	// This method is for random string generation for transaction ID
	$scope.randomString = function() {
		var randomObject = [];
		var orderID = " ";
		var transactionID = " ";
		var charset = "abcdefghijklmnopqrstuvwxyz0123456789";
		for (var i = 0; i < 7; i++) {
			orderID += charset.charAt(Math
					.floor(Math.random() * charset.length));
		}
		for (var i = 0; i < 7; i++) {
			transactionID += charset.charAt(Math.floor(Math.random()
					* charset.length));
		}
		// return text;
		randomObject[0] = new randomGenerator(orderID, transactionID);
		$scope.cart.randomGenerator = randomObject;

	}

	// This method is for get category
	$scope.getAllCategory = function() {

		alert("hello");
		var categoryObject = [];
		$http
				.get(
						'http://localhost:8080/com.sogeti.user/allCategoryAdmin')
				.success(
						function(data) {
							console
									.log("inside getAllCategory success"
											+ JSON
													.stringify(data));
							var temp = JSON.stringify(data);
							for (var i = 0; i < data.length; i++) {
								var catId = data[i].catagoryId;
								alert("catId"+catId);
								
								var catName = data[i].catagoryName;
								categoryObject[i] = new category(
										catId, catName);
							}
						}).error(function(data) {
					alert("inside Error " + data);
				});
		this.categorys = categoryObject;
	
		};
	// This method is for Place order

	$scope.placeOrder = function(userId, transactionID, totalPrice, status,
			cartItems) {
		console.log("response placeOrder :" + JSON.stringify(cartItems));
		$http(
				{
					method : 'GET',
					url : 'paymentCheckOut' + '/' + userId + '/'
							+ transactionID + '/' + totalPrice + '/' + status
							+ '/' + JSON.stringify(cartItems),
				}).success(function(data) {
			console.log("response " + JSON.stringify(data));
		}).error(function(data, status, headers, config) {
			alert("Inside Error" + data);
		});

	};

});
