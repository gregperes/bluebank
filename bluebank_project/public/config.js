var app = angular.module('bluebank',['ngRoute']);

app.config(function($routeProvider, $locationProvider) {

	$routeProvider
	.when('/home', {
		templateUrl : 'views/home.html',
		controller  : 'homeController',
		controllerAs: 'homectrl',
	})

	.when('b', {
		templateUrl : 'views/b.html',
		controller  : 'bController',
	})

	.when('/c', {
		templateUrl : 'views/c.html',
		controller  : 'cController',
	})
	
	.otherwise ({ redirectTo: '/home' });
});