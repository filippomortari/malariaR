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
});

/*
 * 
 * angular.module('common', [])

.controller('HeaderCtrl', ['$scope', '$location'
                            function($scope, $location) {
	$scope.isActive = function (viewLocation) { 
        return viewLocation === $location.path();
    };
}]);
 * 
 */