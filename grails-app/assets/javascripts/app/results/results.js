angular.module('results', [])

.controller('ResultsCtrl', ['$scope','$log','$http','socket','request','$cookieStore',
                            function($scope,$log,$http,socket,request,$cookieStore) {
	$scope.$log = $log;
	$scope.request = request;
	$scope.socket = socket;

	var handleNewInput =  function(data){ 
		console.log(data)
		switch (data.command){
		case 'generalMessage':
			
			break;
			
		case 'updateUIwithPNG':
			var linkImg = data.payload.imageURL
			$("#imgResult").attr("src",linkImg);
			$( "#resultContainer" ).hide();
			$( "#resultContainerSocket" ).show( "slow" );
			break;
		}
	};

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
			/*
			 * lets ignore the session for now
			 * 
			$cookieStore.put('sessionID', data.sessionID);
			$cookieStore.put('reqSession', $scope.request);*/
			$( "#resultContainer" ).show( "slow" );
			$( "#resultContainerSocket" ).hide();
			console.log(data.sessionID);
			if(typeof $scope.socket.client == 'undefined'){
				$scope.socket.client = new SockJS(BASE_URL + '/stomp');
				$scope.socket.stomp = Stomp.over($scope.socket.client);
			}
			$scope.socket.stomp.connect({}, function() {
				$scope.socket.stomp.subscribe("/topic/"+data.sessionID, function(data){
					console.warn('data: ',data.body)
					if(data.body && typeof data.body === 'string'){
						var data = JSON.parse(data.body)
						handleNewInput(data)
					}
				});
			});

		}).
		error(function(data, status, headers, config) {
			// called asynchronously if an error occurs
			// or server returns response with an error status.
		});
	};



}]);