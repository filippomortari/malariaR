angular.module('results', [])

.controller('ResultsCtrl', ['$scope','request','$log','$http','socket',
                           function($scope,request,$log,$http,socket) {
	$scope.$log = $log;
	$scope.request = request;
	$scope.socket = socket;

	$scope.processRequest = function(){
		var jsonRequest = JSON.stringify($scope.request)
		console.log(new Date() + jsonRequest)
		$http.post('RScriptRequest/newRequest', jsonRequest).
		success(function(data, status, headers, config) {
			alert(data.sessionID)
			if(typeof $scope.socket.client === 'undefined'){
				$scope.socket.client = new SockJS(BASE_URL + '/stomp');
	            $scope.socket.stomp = Stomp.over($scope.socket.client);
			}
		}).
		error(function(data, status, headers, config) {
			// called asynchronously if an error occurs
			// or server returns response with an error status.
		});
	};
}]);