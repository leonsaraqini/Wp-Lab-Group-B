

var div = document.getElementById("songSelect");

var form = document.createElement("form");
form.setAttribute("method", "post");
form.setAttribute("action", "/listSongs/addArtist");


while (div.firstChild) {
    form.appendChild(div.firstChild);
}


div.parentNode.replaceChild(form, div);