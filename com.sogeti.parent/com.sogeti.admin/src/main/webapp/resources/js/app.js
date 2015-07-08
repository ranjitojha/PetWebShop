'use strict';
var storeApp = angular.module('PetStoreAdmin', [ 'ngRoute', 'ngResource' ]);
storeApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/adminLoginPage', {
		templateUrl : 'views/adminLogin.htm',
		controller : 'storeController'
	}).when('/adminRegistration', {
		templateUrl : 'views/adminRegistration.htm',
		controller : 'storeController'
	}).when('/categoryDetails', {
		templateUrl : 'views/CategoryDetails.htm',
		controller : 'storeController'
	}).when('/orderDetails', {
		templateUrl : 'views/orderDetails.htm',
		controller : 'storeController'
	}).when('/userDetails', {
		templateUrl : 'views/UserDetails.htm',
		controller : 'storeController'
	}).when('/productDetails', {
		templateUrl : 'views/productDetails.htm',
		controller : 'storeController'
	}).when('/viewProductDetails', {
		templateUrl : 'views/viewProductDetails.htm',
		controller : 'storeController'
	}).otherwise({
		redirectTo : '/adminLoginPage'
	});
} ]);

