'use strict';

// Declare app level module which depends on filters, and services
angular.module('ngdemo', ['querywebapp.filters', 'querywebapp.services', 'querywebapp.directives', 'querywebapp.controllers']).
    config(['$routeProvider', function ($routeProvider) {

        $routeProvider.when('/dummy', {templateUrl: 'partials/dummy.html', controller: 'DummyCtrl'});
        $routeProvider.when('/user-list', {templateUrl: 'partials/user-list.html', controller: 'UserListCtrl'});
        $routeProvider.when('/user-select/:id', {templateUrl: 'partials/user-select.html', controller: 'UserListCtrl'});
        $routeProvider.when('/user-detail/:id', {templateUrl: 'partials/user-detail.html', controller: 'UserDetailCtrl'});
        $routeProvider.when('/user-creation', {templateUrl: 'partials/user-creation.html', controller: 'UserCreationCtrl'});
        $routeProvider.otherwise({redirectTo: '/dummy'});
    }]);
