function initializeItemsSelection($scope, pageCount, pageSize, collectionFetcher){
    $scope.selectedIdx=-1;
    $scope.pageSize=pageSize;
    $scope.pageCount=pageCount;
    console.log('iis');
    console.log($scope.selectedIdx);

    var getCollection = function (pageNumber) {
        $scope.pageNumber=pageNumber;
        $scope.collection=collectionFetcher();
        console.log($scope.collection);
    };

    $scope.getCollection=getCollection;

    $scope.openItem= function (itemIndex) {
        $scope.selectedIdx=itemIndex;
        $scope.selectedItem=$scope.collection[$scope.selectedIdx];

        initializeCheckBox($scope.selectedItem,$scope);
    };

    getCollection(1);

    var pages = [];
    for (var i = 0; i < $scope.pageCount; i++) {
        console.log(pages);
        pages.push(i + 1);
    }

    $scope.pages=pages;
}