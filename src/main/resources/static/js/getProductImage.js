function showURL() {
    document.getElementById("productImage").onchange = function () {
        var reader = new FileReader();

        reader.onload = function (e) {
            // get loaded data and render thumbnail.
            console.log(e.target.result);
            console.log('as');
            document.getElementById("imageURL").src = e.target.result;
        };



        // // read the image file as a data URL.
        // reader.readAsDataURL(this.files[0]);
    };
}


