angular.module('pizzaShopManagementApp')
    .controller('navigationController',
        function ($route) {
            self.tab = function (route) {
                console.log('r');
                return $route.current && route === $route.current.controller;
            };
        });