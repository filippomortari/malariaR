angular.module('output', [])

.controller('OutputCtrl', ['$scope','request','$log','$http',
                           function($scope,request,$log,$http) {
	$scope.$log = $log;
	$scope.request = request;

	$scope.processRequest = function(){
		var jsonRequest = JSON.stringify($scope.request)
		console.log(new Date() + jsonRequest)
		$http.post('RScriptRequest/newRequest', jsonRequest).
		success(function(data, status, headers, config) {
			// this callback will be called asynchronously
			// when the response is available
		}).
		error(function(data, status, headers, config) {
			// called asynchronously if an error occurs
			// or server returns response with an error status.
		});
	};

}]);