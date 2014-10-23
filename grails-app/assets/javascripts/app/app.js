'use strict';
/* App Module */

//= require_tree /input
//= require_tree /output
//= require_tree /results
//= require common


angular.module('malariaRapp', ['ngRoute','common','input','output','results']).config(['$routeProvider',
                    function($routeProvider) {
	$routeProvider.
	when('/input', {
		templateUrl: 'assets/app/input/input-params.tpl.html',
		controller: 'InputCtrl'
	}).
	when('/output', {
		templateUrl: 'assets/app/output/output-params.tpl.html',
		controller: 'OutputCtrl'
	}).
	when('/results', {
		templateUrl: 'assets/app/results/results.tpl.html',
		controller: 'ResultsCtrl'
	}).
	otherwise({
		redirectTo: '/input'
	});
}]).factory('request', function(){

	return {
		diseaseName:'',
		species:'',
		estimateR:''
	};

});