'use strict';

/* Services */

/*
 http://docs.angularjs.org/api/ngResource.$resource

 Default ngResources are defined as

 'get':    {method:'GET'},
 'save':   {method:'POST'},
 'query':  {method:'GET', isArray:true},
 'remove': {method:'DELETE'},
 'delete': {method:'DELETE'}

 */

var services = angular.module('querywebapp.services', ['ngResource']);

services.factory('DummyFactory', function ($resource) {
    return $resource('/querywebapp/dummy', {}, {
        query: { method: 'GET', params: {}, isArray: false }
    })
});

services.factory('UsersFactory', function ($resource) {
    return $resource('/querywebapp/allPerson', {}, {
        query: { method: 'GET', isArray: true }
    })
});



services.factory('UserEditFactory', function ($resource) {
    return $resource('/querywebapp/person/:id', {}, {
        show: { method: 'GET' },
        update: { method: 'PUT', params: {id: '@id'} },
    })
});


services.factory('UserUpdateFactory', function ($resource) {
    return $resource('/querywebapp/updatePerson', {}, {
        update: { method: 'PUT', params: {id: '@id'} },
    })
});


/*
services.factory('UserFactory', function ($resource) {
    return $resource('/querywebapp/users/:id', {}, {
        show: { method: 'GET' },
        update: { method: 'PUT', params: {id: '@id'} },
    })
});
*/

services.factory('UserFactory', function ($resource) {
    return $resource('/querywebapp/deletePerson/:id', {}, {
        deleteUser: { method: 'DELETE', params: {id: '@id'},
        	show: { method: 'GET', params: {id: '@id'}}

        }
    })
});



services.factory('UsersCreateFactory', function ($resource) {
    return $resource('/querywebapp/addPerson', {}, {
    	createNewUser: { method: 'POST' }
    })
});
