angular.module('input', [])

.controller('InputCtrl', ['$scope', 'request', 
                            function($scope, request) {
	$scope.request = request;
}]);