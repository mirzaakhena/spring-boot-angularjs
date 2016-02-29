'use strict';

angular.module('myApp')

.config(function($stateProvider) {

    $stateProvider
        .state('main.data', {
            url: '/data',
            templateUrl: 'templates/data.html',
            controller: 'DataDataController',
            onEnter: function() {
                console.log('masuk sini');
            }
        })

})


.factory('DataService', function($resource) {
    // return $resource('/data/:userId', null, {
    //     update: {
    //         method: 'PUT'
    //     }
    // });
    return $resource('http://localhost:8080/user/:userId', null, {
        'update': {
            method: 'PUT'
        }
    });

})

.controller('DataDataController', function($scope, $uibModal, DataService) {

    function reload() {
        $scope.datas = DataService.query();
    }

    function create() {
        $uibModal.open({
            templateUrl: 'templates/data-input.html',
            controller: 'DataInputController',
            resolve: {
                data: function() {
                    return null;
                }
            }

        }).result.then(reload);
    }

    function update(data) {
        $uibModal.open({
            templateUrl: 'templates/data-input.html',
            controller: 'DataInputController',
            resolve: {
                data: function() {
                    return data;
                }
            }

        }).result.then(reload);
    }

    function remove(data) {

        DataService.remove({
            userId: data.id
        }, function() {
            reload();
        })

    }

    $scope.create = create;
    $scope.update = update;
    $scope.remove = remove;

    reload();

})

.controller('DataInputController', function($scope, $uibModalInstance, data, DataService) {

    $scope.data = data;

    function closeModal(data) {
        $uibModalInstance.close(data);
    }

    function ok() {
        if (data === null) {
            console.log($scope.data);
            DataService.save($scope.data, closeModal);
        } else {
            DataService.update({
                userId: $scope.data.id
            }, $scope.data, closeModal);
        }
    }

    function cancel() {
        $uibModalInstance.dismiss();
    }

    $scope.ok = ok;
    $scope.cancel = cancel;

});
