var formApp = angular.module('deleteProductApp', [])

    .controller('deleteProductController', ['$scope',function($scope) {
        $scope.deleted=false;
        $scope.operation='delete';
        $scope.toggleDialog=function (itemIndex) {
            $scope.selectedIdx=itemIndex;
            $("#myModal").on("show", function() {    // wire up the OK button to dismiss the modal when shown
                $("#myModal a.btn").on("click", function(e) {
                    console.log("button pressed");   // just as an example...
                    $("#myModal").modal('hide');     // dismiss the dialog
                });
            });
            $("#myModal").on("hide", function() {    // remove the event listeners when the dialog is dismissed
                $("#myModal a.btn").off("click");
            });

            $("#myModal").on("hidden", function() {  // remove the actual elements from the DOM when fully hidden
                $("#myModal").remove();
            });

            $("#myModal").modal({                    // wire up the actual modal functionality and show the dialog
                "backdrop"  : "static",
                "keyboard"  : true,
                "show"      : true                     // ensure the modal is shown immediately
            });
        };


        initializeItemsSelection($scope,3,4,getExampleProducts);
        //initializeScope($scope);

        $scope.deleteItem= function () {
            //delete
            $scope.deleted=true;
            $scope.selectedIdx=-1;
        };

        console.log($scope.selectedIdx);
        console.log($scope.selectedItem);

    }]);









// var formApp = angular.module('productMenuManagementApp', [])
//
//     .controller('productMenuManagementController', ['$scope',function($scope) {
//         $scope.deleted=false;
//         $scope.operation='delete';
//         $scope.toggle = toggle;
//
//         initializeItemsSelection($scope,3,4,getExampleProducts);
//         //initializeScope($scope);
//
//         $scope.deleteItem= function (itemIndex) {
//
//         };
//
//         console.log($scope.selectedIdx);
//         console.log($scope.selectedItem);
//
//     }]);
