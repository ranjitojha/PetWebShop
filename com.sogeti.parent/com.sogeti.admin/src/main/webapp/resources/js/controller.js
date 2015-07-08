'use strict';

// the storeController contains two objects:
// - store: contains the product list
// - cart: the shopping cart object
storeApp
		.controller(
				'storeController',
				function($scope, $routeParams, $http, $resource, $location) {
					var UserObject = [];
					$scope.currentPage = 1;
					$scope.pageSize = 3;

					$scope.productManageAdd = function(prodName, prodPrice,
							prodQuant, category) {
						alert(prodName + "prodName")
						$http
								.get(
										'http://localhost:8080/com.sogeti.admin/productAddAdmin'
												+ '/' + prodName + '/'
												+ prodPrice + '/' + prodQuant
												+ '/' + category)
								.success(
										function(data) {
											console
													.log("inside productManageAdd success"
															+ JSON
																	.stringify(data));
											$scope.getProductList();
											$scope.prodName = '';
											$scope.prodPrice = '';
											$scope.prodQuant = '';
										}).error(function(data) {
									alert("inside Error " + data);
								});
					};

					$scope.getProductList = function() {
						$http
								.get(
										'http://localhost:8080/com.sogeti.admin/productMasterAdmin')
								.success(
										function(data, status, headers, config) {
											console.log("inside success"
													+ JSON.stringify(data));
											$scope.products = data;

										})
								.error(
										function(data, status, headers, config) {
											alert("inside Error " + data
													+ " Header : " + headers
													+ "Status : " + status
													+ "config : " + config);

										});
					};

					$scope.getAllUser = function() {
						$http
								.get(
										'http://localhost:8080/com.sogeti.admin/getAllUser')
								.success(
										function(data, status, headers, config) {
											console.log("inside success"
													+ JSON.stringify(data));
											$scope.users = data;

										})
								.error(
										function(data, status, headers, config) {
											alert("inside Error " + data
													+ " Header : " + headers
													+ "Status : " + status
													+ "config : " + config);
										});

					};

					$scope.getAllOrder = function() {
						$http
								.get(
										'http://localhost:8080/com.sogeti.admin/getAllOrder')
								.success(
										function(data, status, headers, config) {
											console.log("inside success"
													+ JSON.stringify(data));
											$scope.orders = data;

										})
								.error(
										function(data, status, headers, config) {
											alert("inside Error " + data
													+ " Header : " + headers
													+ "Status : " + status
													+ "config : " + config);
										});

					};

					$scope.editProduct = function(product) {
						$scope.prodName = product.productName
						$scope.prodPrice = product.productPrice
						$scope.prodQuant = product.productQuantity
						$scope.category = product.productCatagory.catagoryName
					};

					$scope.deleteProduct = function(productId) {
						$http.get(
								'http://localhost:8080/com.sogeti.admin/productDeleteAdmin'
										+ '/' + productId).success(
								function(data) {
									console.log("inside deleteProduct success"
											+ JSON.stringify(data));
									$scope.getProductList();
								}).error(function(data) {
						});

					};

					$scope.deleteUser = function(userId) {


						$http.get(
								'http://localhost:8080/com.sogeti.admin/userDelete'
										+ '/' + userId).success(
								function(data) {
									alert("data" + data);
									console.log("inside deleteProduct success"
											+ JSON.stringify(data));
									$scope.getAllUser();
								}).error(function(data) {
							alert("inside Error " + data);
						});

					};

					$scope.getAllCategory = function() {

						var categoryObject = [];
						$http
								.get(
										'http://localhost:8080/com.sogeti.admin/allCategoryAdmin')
								.success(
										function(data) {
											console
													.log("inside getAllCategory success"
															+ JSON
																	.stringify(data));
											var temp = JSON.stringify(data);
											for (var i = 0; i < data.length; i++) {
												var catId = data[i].catagoryId;
												var catName = data[i].catagoryName;
												categoryObject[i] = new category(
														catId, catName);
											}
										}).error(function(data) {
									alert("inside Error " + data);
								});
						this.categorys = categoryObject;
					};

					// This method is for admin registration
					$scope.newUserRegistration = function(firstname, lastname,
							username, password) {
						var flag = true;
						if (firstname == undefined || lastname == undefined
								|| username == undefined
								|| password == undefined) {

							flag = false;

						}
						if (firstname != undefined && lastname != undefined
								&& username == undefined
								&& password != undefined) {

							flag = false;

						}
						if (flag == true) {
							$http
									.get(
											'http://localhost:8080/com.sogeti.admin/addNewUser'
													+ '/' + firstname + '/'
													+ lastname + '/' + username
													+ '/' + password)
									.success(
											function(data) {
												$location
														.path("productDetails");
												alert("Registered Successfully")
												console
														.log("newUserDetails response "
																+ JSON
																		.stringify(data));
												$scope.firstname = '';
												$scope.lastname = '';
												$scope.username = '';
												$scope.password = '';

											});
						}
					};

					$scope.userLoginfunc = function(uname, password) {
						if (uname == undefined || password == undefined) {
						} else {
							$http
									.get(
											'http://localhost:8080/com.sogeti.admin/userLogin'
													+ '/' + uname + '/'
													+ password)
									.success(
											function(data) {
												if (data.firstName == null) {
													alert("Invalid User, Please try once again or Register");
													$scope.uname = "";
													$scope.password = "";

												} else {
													$location
															.path("viewProductDetails");
													alert("Login Successfully")
													$scope.uname = "";
													$scope.password = "";
													console
															.log("response "
																	+ JSON
																			.stringify(data));

													console
															.log("inside UserObject ");
												}
											});
						}

					};

				});

function product(sku, name, description, price, catagoryName, catagoryId,
		quantity) {
	this.sku = sku;
	this.name = name;
	this.description = description;
	this.price = price;
	this.catagoryName = catagoryName;
	this.catagoryId = catagoryId;
	this.quantity = quantity;
}

function category(catId, CatName) {
	this.catId = catId;
	this.CatName = CatName;
}
