angular.module('results', [])

.controller('ResultsCtrl', ['$scope','request','$log','$http','socket','$cookieStore',
                           function($scope,request,$log,$http,socket, $cookieStore) {
	$scope.$log = $log;
	$scope.request = request;
	$scope.socket = socket;

	$scope.processRequest = function(){
		var jsonRequest = JSON.stringify($scope.request)
		console.log(new Date() + jsonRequest)
		var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		if(!regex.test($scope.request.email)){
			alert("please provide a valid email address (set it in output page)!");
			return;
		}
		$http.post('RScriptRequest/newRequest', jsonRequest).
		success(function(data, status, headers, config) {
			$cookieStore.put('sessionID', data.sessionID);
			$( "#resultContainer" ).show( "slow" );
			console.log(data.sessionID);
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