'use strict';

/* Controllers */

var app = angular.module('querywebapp.controllers', []);


// Clear browser cache (in development mode)
//
// http://stackoverflow.com/questions/14718826/angularjs-disable-partial-caching-on-dev-machine
app.run(function ($rootScope, $templateCache) {
    $rootScope.$on('$viewContentLoaded', function () {
        $templateCache.removeAll();
    });
});


app.controller('DummyCtrl', ['$scope', 'DummyFactory', function ($scope, DummyFactory) {
    $scope.bla = 'bla from controller';
    DummyFactory.get({}, function (dummyFactory) {
        $scope.firstname = dummyFactory.firstName;
    })
}]);

app.controller('UserListCtrl', ['$scope', 'UsersFactory', 'UserFactory','UserEditFactory', '$location',
    function ($scope, UsersFactory, UserFactory, UserEditFactory,  $location) {

 		// callback for ng-click 'selectUser':
        $scope.selectUser = function (userId) {
            $location.path('/user-select/' + userId);
        };
        // callback for ng-click 'editUser':
        $scope.editUser = function (userId) {
            $location.path('/user-detail/' + userId);
        };

        // callback for ng-click 'deleteUser':
        $scope.deleteUser = function (userId) {
        	UserFactory.deleteUser({ id: userId });
            $location.path('/user-list');
            $scope.users = UsersFactory.query();

        };

        // callback for ng-click 'createUser':
        $scope.createNewUser = function () {
            $location.path('/user-creation');
        };
        
        // callback for ng-click 'cancel':
        $scope.cancel = function () {
            $location.path('/user-list');
        };

        $scope.users = UsersFactory.query();
    }]);


app.controller('UserDetailCtrl', ['$scope', '$routeParams', 'UserEditFactory','UserUpdateFactory', '$location',
    function ($scope, $routeParams, UserEditFactory, UserUpdateFactory,  $location) {
        // callback for ng-click 'updateUser':
	
     $scope.editUser = function (userId) {
    	 $scope.user=UserEditFactory.show({ id: userId });
         alert('in UserDetailCtrl22');

         $location.path('/user-detail/' + userId);
         //$scope.user=userData;
     };
     
     
        $scope.updateUser = function () {
        	UserUpdateFactory.update($scope.user);
           $location.path('/user-list');
        };

        // callback for ng-click 'cancel':
        $scope.cancel = function () {
            $location.path('/user-list');
        };
        //$scope.users = UserEditFactory.query();

       $scope.user = UserEditFactory.show({id: $routeParams.id});
    }]);

app.controller('UserCreationCtrl', ['$scope', 'UsersCreateFactory', '$location',
    function ($scope, UsersFactory, $location) {
        // callback for ng-click 'createNewUser':
        $scope.createNewUser = function () {
            UsersFactory.createNewUser($scope.user);
            $location.path('/user-list');
        };
    }]);
