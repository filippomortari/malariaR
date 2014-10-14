'use strict';
/* App Module */

//= require_tree /input
//= require common


var malariaRapp = angular.module('malariaRapp', [
  'ngRoute',
  'common',
  'input'
  
]);

malariaRapp.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/input', {
        templateUrl: 'assets/app/input/input-params.tpl.html',
        controller: 'InputCtrl'
      }).
      when('/output', {
        templateUrl: 'assets/app/output/output-params.tpl.html',
        controller: 'PhoneDetailCtrl'
      }).
      otherwise({
        redirectTo: '#'
      });
  }]);