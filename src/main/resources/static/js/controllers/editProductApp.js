var formApp = angular.module('editProductApp', [])
    .controller('editProductController',function($scope) {
        $scope.edited=false;
        $scope.operation='edit';
        console.log('edit');
        $scope.editProduct=function () {
            console.log($scope.selectedItem);
            $scope.selectedIdx=-1;
            $scope.edited=true;
            addCheckBoxToModel($scope);
            console.log($scope.selectedItem);
        };

        $scope.toggle = toggle;

        initializeItemsSelection($scope,3,4,getExampleProducts);
        initializeScope($scope);

        //initializeCheckBox($scope.selectedItem,$scope);

        console.log($scope.selectedIdx);
        console.log($scope.selectedItem);

        // $scope.pizzaIngredientsCheckBoxModel=initializeCheckBoxModel($scope.allPizzaIngredients,['ser']);
        // $scope.seasoningsCheckBoxModel=initializeCheckBoxModel($scope.allSeasonings,['oregano']);
        //
        // $scope.pizzaIngredientsCheckBoxModel=initializeCheckBoxModel($scope.allPizzaIngredients,$scope.selectedItem.ingredients);
        // $scope.seasoningsCheckBoxModel=initializeCheckBoxModel($scope.allSeasonings,$scope.selectedItem.seasonings);
    });


