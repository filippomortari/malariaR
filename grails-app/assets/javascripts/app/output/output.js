angular.module('output', [])

.controller('OutputCtrl', ['$scope', 'request', '$log',
                            function($scope, request, $log) {
	$scope.$log = $log;
	$scope.request = request;
}]);