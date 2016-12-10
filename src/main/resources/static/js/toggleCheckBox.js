var toggle = function (element, array) {
    var idx = array.indexOf(element);

    if (idx > -1) {
        array.splice(idx, 1);
    }
    else {
        array.push(element);
    }
};