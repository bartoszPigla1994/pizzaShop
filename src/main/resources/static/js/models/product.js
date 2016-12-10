function Product(){
        this.product={
            id:0,
            type:'',
            name:'',
            description:'',
            photoUrl:''
        };

        this.pizza={
            doughType:'',
            smallPrice:'',
            bigPrice:'',
            ingredients:[]
        };

        this.sauce={
            seasonings:[]
        }

        this.drink={
            literCount:''
        }
    }
function initializeCheckBox(product,$scope) {
    switch (product.type){
        case 'pizza':
            $scope.pizzaIngredientsCheckBoxModel=initializeCheckBoxModel($scope.allPizzaIngredients,product.ingredients);
            break;
        case 'sauce':
            $scope.seasoningsCheckBoxModel=initializeCheckBoxModel($scope.allSeasonings,product.seasonings);
            break;
    }
}

function initializePizzaCheckBoxes($scope){
    $scope.pizzaIngredientsCheckBoxModel=initializeCheckBoxModel($scope.allPizzaIngredients,$scope.selectedPizzaIngredients);
}

function initializeSeasoningCheckBoxes($scope){
    $scope.seasoningsCheckBoxModel=initializeCheckBoxModel($scope.allSeasonings,$scope.selectedSeasonings);
}

function addCheckBoxToModel($scope) {
    switch ($scope.selectedItem.type){
        case 'pizza':
            $scope.selectedItem.ingredients=getSelected($scope.pizzaIngredientsCheckBoxModel,$scope.allPizzaIngredients);
            break;
        case 'sos':
            $scope.selectedItem.seasonings=getSelected($scope.seasoningsCheckBoxModel,$scope.allSeasonings);
            break;
    }
}

Product.prototype.getProduct = function(){
        switch(product.type){
            case 'pizza':
                return {
                    id:this.product.id,
                    type:this.product.type,
                    name:this.product.name,
                    description:this.product.description,
                    photoUrl:this.product.photoUrl,
                    doughType:this.pizza.doughType,
                    smallPrice:this.pizza.smallPrice,
                    bigPrice:this.pizza.bigPrice,
                    ingredients:this.pizza.ingredients
                };
            case 'sauce':
                return {
                    id:this.product.id,
                    type:this.product.type,
                    name:this.product.name,
                    description:this.product.description,
                    photoUrl:this.product.photoUrl,
                    seasonings:this.sauce.seasonings
                };
            case 'drink':
                return {
                    id:this.product.id,
                    type:this.product.type,
                    name:this.product.name,
                    description:this.product.description,
                    photoUrl:this.product.photoUrl,
                    literCount:this.drink.literCount
                };
        }
    }
function getAllPizzaIngredients() {
    return ['ser', 'pomidor', 'szynka', 'pieczarki', 'salami'];
}
function getAllSeasonings() {
    return ['oregano', 'bazylia', 'chili'];
}
function getAllRebates() {
    return ['2 w jednym', 'zaplac za 3 a damy 1', '50% znizki za 3 duza pizze'];
}

Product.prototype = {
    set initialize(obj) {
        this.product = {
            id: obj.id,
            type: obj.type,
            name: obj.name,
            description: obj.description,
            photoUrl: obj.photoUrl,
        };
        switch(obj.type){
            case 'pizza':
                this.pizza={
                    doughType:obj.doughType,
                    smallPrice:obj.smallPrice,
                    bigPrice:obj.bigPrice,
                    ingredients:obj.ingredients
                };
            case 'sauce':
                this.sauce={
                    seasonings:obj.seasonings
                };
            case 'drink':
                this.drink={
                    literCount:obj.literCount
                };
        }
    }
};

function getAllPizzaIngredients() {
    return ['ser', 'pomidor', 'szynka', 'pieczarki', 'salami'];
}
function getAllSeasonings() {
    return ['oregano', 'bazylia', 'chili'];
}
function getAllRebates() {
    return ['2 w jednym', 'zaplac za 3 a damy 1', '50% znizki za 3 duza pizze'];
}

function initializeScope ($scope) {
    $scope.selectedPizzaIngredients=['ser'];
    $scope.selectedSeasonings=[];
    $scope.selectedRebates=[];

    $scope.allPizzaIngredients=getAllPizzaIngredients();
    $scope.allSeasonings=getAllSeasonings();
    $scope.allRebates=getAllRebates();
}



function getExamplePizza() {
    //var pizza=new Product();

    return {
        id: 1,
        type: 'pizza',
        name: 'Margheritta',
        description: 'bardzo dobra pizza',
        photoUrl: 'http://www.cbc.ca/inthekitchen/assets_c/2012/11/MargheritaPizza21-thumb-596x350-247022.jpg',
        price: 12,
        size: 'mala',
        doughType: 'grube',
        doughPrice: 3,
        ingredients: ['ser', 'szynka'],
        rebate:'2 w jednym'
    }
}
//     pizza.product = {
//         id:1,
//         type:'pizza',
//         name:'Margheritta',
//         description:'bardzo dobra pizza',
//         photoUrl:''
//     };
//
//     pizza.pizza ={
//         doughType:'deep-dish',
//         smallPrice:'12',
//         bigPrice:'21',
//         ingredients: ['ser','szynka']
//     };
//
//     return pizza;
// }

function getExampleProducts(productCount) {
    var products=[];
    for(var i=0;i<productCount;i++){
        products.push(getExamplePizza())
    }
    return products;
}