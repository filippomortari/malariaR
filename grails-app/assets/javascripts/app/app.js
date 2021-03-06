'use strict';
/* App Module */

//= require_tree /input
//= require_tree /output
//= require_tree /results
//= require common


angular.module('malariaRapp', ['ngRoute','ngCookies','toggle-switch','common','input','output','results']).config(['$routeProvider',
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
}]).factory('request', function($cookieStore){
	if(typeof $cookieStore.get('reqSession') != 'undefined'){
		return $cookieStore.get('reqSession')
	}
	else
		return {
		diseaseName:'Malaria',
		species:'P.Falciparum',
		zValDef:15,
		isDefZ:"1",
		zVal:'',
		kValDef:0.2,
		isDefK:"1",
		kVal:'',
		cdrVal:'',
		cdrValDef:10,
		isDefCDR:"1",
		estimateR:'1',
		isFigure:'1',
		minFigRange:'',
		minFigRangeDef:10,
		isDefMinFR:"1",
		maxFigRange:'',
		maxFigRangeDef:500,
		isDefMaxFR:"1",
		nrOfPoints:20,
		isLogXAxis:'1',
		imported:'',
		isDefImported:'1',
		importedDef:'50',
		casesDetected:'',
		isDefCasesDetected:'1',
		casesDetectedDef:'138',
		email:''
	};

}).factory('socket', function(){

	return []

});