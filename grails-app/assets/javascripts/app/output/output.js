angular.module('output', [])

.controller('OutputCtrl', ['$scope','request','$log','$http','socket',
                           function($scope,request,$log,$http,socket) {
	$scope.$log = $log;
	$scope.request = request;
	
}]);