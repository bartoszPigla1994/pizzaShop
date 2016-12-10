var formApp = angular.module('productComplaintsApp', [])

    .controller('productComplaintsController', function ($scope, $http) {
        $scope.pageNumber=1;

        var getComplaints=function () {
            $http({
                method: 'GET',
                url: 'http://localhost:8080/complaint/read?pageSize='+$scope.pageSize+'&pageNumber='+$scope.pageNumber,
                headers: {'Content-Type': 'application/json'}
            }).then(function successCallback(response) {
                console.log('complaints');
                console.log(response.data);
                $scope.collection=response.data;
                return response.data;
            }, function errorCallback(response) {
            });
        };

        var getComplaintCount=function () {
            $http({
                method: 'GET',
                url: 'http://localhost:8080/complaint/count',
                headers: {'Content-Type': 'application/json'}
            }).then(function successCallback(response) {
                console.log('complaint count');
                console.log(response.data);
                $scope.complaintCount=response.data;
                return response.data;
            }, function errorCallback(response) {
            });
        };

        initializeItemsSelection($scope,3,5,getComplaints);

        getComplaints();
        getComplaintCount();

        $scope.selectedIdx=-1;
        $scope.pageSize=5;
        $scope.pageCount=$scope.complaintCount/$scope.pageSize;

        var pages = [];
        for (var i = 0; i < $scope.pageCount; i++) {
            console.log(pages);
            pages.push(i + 1);
        }

        $scope.pages=pages;
    });