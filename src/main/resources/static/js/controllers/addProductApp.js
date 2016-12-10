var formApp = angular.module('addProductApp', [])
    .controller('addProductController', function($scope, $http) {
        $scope.added=false;
        $scope.selectedItem={
            type:'pizza'
        };

        $scope.addProduct=function () {
            var data = JSON.stringify($scope.selectedItem);

            $http({
                method: 'POST',
                url: 'http://pizzahop22.herokuapp.com/pizza/create',
                headers: {'Content-Type': 'application/json'},
                data:$.param(JSON.stringify($scope.selectedItem))
            }).then(function successCallback(response) {
                // this callback will be called asynchronously
                // when the response is available
            }, function errorCallback(response) {
                // called asynchronously if an error occurs
                // or server returns response with an error status.
            });

            // $http.post("http://localhost:8080/create", data).success(function(data, status) {
            //     $scope.hello = data;});

            $scope.added=true;
            addCheckBoxToModel($scope);
            console.log($scope.selectedItem);
            $scope.selectedItem={
                type:'pizza'
            };
        };

        // $scope.product=new Product();
        //
        // $scope.product.initializeScope($scope);
        initializeScope($scope);

        initializePizzaCheckBoxes($scope);
        initializeSeasoningCheckBoxes($scope);

        $scope.toggle = toggle;
    });