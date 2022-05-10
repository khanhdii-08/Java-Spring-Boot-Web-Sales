const f = document.querySelector('#imageFile');

f.onchange = function (evt) {
    var tgt = evt.target || window.event.srcElement,
        files = tgt.files;

    // FileReader support
    if (FileReader && files && files.length) {
        var fr = new FileReader();

        fr.onload = function () {
            document.getElementById("image").src = fr.result;
        }
        fr.readAsDataURL(files[0]);
    }
}