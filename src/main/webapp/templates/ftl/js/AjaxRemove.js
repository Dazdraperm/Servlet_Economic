function remove() {

    var input = document.querySelector('#remove_input');
    var draw = document.querySelector('#piechart_3d');

    var name_delete_category = input.attributes.item(2).value;


    var xhr = new XMLHttpRequest();
    xhr.open('POST', '/remove');
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send('name_delete_category=' + name_delete_category);
    location.reload();
}
