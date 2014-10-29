'use strict';

angular.module('common', []);

angular.module('common').controller('HeaderCtrl',
		function($scope,$location) {
		//controller's code goes here
	$scope.getClass = function(path) {
	    if ($location.path().substr(0, path.length) == path) {
	      return "active"
	    } else {
	      return ""
	    }
	}
}).controller('CommonsCtrl', ['$scope','request','$log','$http','socket','$cookieStore','$window',
                              function($scope,request,$log,$http,socket, $cookieStore, $window) {

	$scope.$log = $log;
	$scope.request = request;
	$scope.socket = socket;
	$scope.$cookieStore = $cookieStore;
	
	$window.onbeforeunload = function () {
		if(typeof $scope.socket.client != 'undefined'){
			$scope.socket.client.close();
			$scope.socket = []
		}
	}
	
	$scope.init = function() {
		
	}
}])