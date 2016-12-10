function initializeCheckBoxModel(allElements, selectedElements){
    var checkBoxModel=[];
    for(var i=0;i<allElements.length;i++){
        var element=allElements[i];
        if(selectedElements.indexOf(element)==-1)
            checkBoxModel[i]=false;
        else
            checkBoxModel[i]=true;
    }
    return checkBoxModel;
}

function getSelected(checkBoxModel, allElements){
    var selectedElements=[];
    for(var i=0;i<allElements.length;i++){
        if(checkBoxModel[i])
            selectedElements.push(allElements[i]);
    }
    return selectedElements;
}

// function initializeCheckBox(item) {
//     switch (item.type){
//         case 'pizza':
//             initializeCheckBoxModel($scope.)
//     }
// }