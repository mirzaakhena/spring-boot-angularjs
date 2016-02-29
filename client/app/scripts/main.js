'use strict';

angular.module('myApp', [
    'LocalStorageModule',
    'ui.router',
    'ui.bootstrap',
    'ngResource'
])

.config(function($stateProvider, $urlRouterProvider, $httpProvider) {

    $urlRouterProvider.otherwise('/data');

    $stateProvider
        .state('main', {
            abstract: 'true',
            templateUrl: 'templates/main.html'
        })

})

.run(function($state, $rootScope) {

    $state.go('main.data');

})
