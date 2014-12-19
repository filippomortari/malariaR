angular.module('output', [])

.controller('OutputCtrl', ['$scope','request','$log','$http','socket',
                           function($scope,request,$log,$http,socket) {
	$scope.$log = $log;
	$scope.request = request;
	
	$scope.$watch('request.isFigure', function(newVal, oldVal){
	    console.log("isFigure was changed to:"+newVal);
	    if(newVal == false){
	    	$('#figureSection').hide("fast");
	    	$('#rThresold').hide("fast");
	    }
	    	
	    if(newVal == true){
	    	$('#figureSection').show("fast");
	    	$('#rThresold').show("fast");
	    }
	    	
	});
	
}]);