var app = angular.module('goalsApp', []);

app.controller('goalsController', function($scope, $http) {
	$scope.goals = [];
	$scope.goal = {};
	$scope.hostInfo = {};

	$scope.getGoals = function() {
		$http
		.get("/api/goal/")
		.then(function(response) {
			$scope.goals = response.data.goals;
			$scope.hostInfo.frontend = response.data.frontendInfo || {};
			$scope.hostInfo.backend = response.data.backendInfo || {};
		},
		function errorHandler(response){
			$scope.error = response;
			console.dir(response);
		});
	}
	
	$scope.saveGoal = function() {
		$http
			.post("/api/goal/", $scope.goal)
			.then(function(response) {
				$scope.goal = response.data;
				$scope.getGoals();
			},
			function errorHandler(response){
				$scope.error = response;
				console.dir(response);
			});
	}
	
	$scope.getGoals();
});