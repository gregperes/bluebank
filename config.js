var app = angular.module('bluebank', ['ngRoute', 'ngMaterial', 'ngMessages']);

app.config(function($routeProvider, $locationProvider) {

	$routeProvider
	.when('/home', {
		templateUrl : 'views/home.html',
		controller  : 'homeController',
	})

	.when('/quemsomos', {
		templateUrl : 'views/quemsomos.html',
		controller  : 'quemsomosController',
	})

	.when('/faleconosco', {
		templateUrl : 'views/faleconosco.html',
		controller  : 'faleconoscoController',
	})
	
	.otherwise ({ redirectTo: '/home' });
});