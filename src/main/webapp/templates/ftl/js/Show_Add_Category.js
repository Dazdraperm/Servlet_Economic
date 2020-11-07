function show() {

    var show = document.querySelector('#show');
    document.querySelector('#delete_but').remove();
    let a = document.getElementsByClassName("top");

    show.insertAdjacentHTML("afterbegin", '<li class="top">\n' +
        '                            <div class="form-input">\n' +
        '                                <input type="text" oninput="checkCategory()" class="name_category"  name="name_category" placeholder="Name of category" tabindex="10" required>\n' +
        '                            </div>\n' +
        '\n' +
        '                            <div class="form-input">\n' +
        '                                <input type="text" oninput="checkCategory()" class="count_category" name="count_category" placeholder="Money" tabindex="10" required>\n' +
        '                            </div>\n' +
        '                        \n' +

        '                        \n' +
        '\n' +
        '                        \n' +
        '\n' +
        '                        <div class="mb-3" style="margin-top: 55px; margin-left: -350px" >\n'
        +'<div id="check_name_category" ></div>' +
        '                            <button type="submit" id="re" disabled class="btn btn-block text-uppercase">Add Category</button>\n' +
        '                        </div></li>');
}

function showChange() {
    var show = document.querySelector('#showChange');
    document.querySelector('#delete_but_change').remove();
    let a = document.getElementsByClassName("top");

    show.insertAdjacentHTML('afterbegin','<ul style="margin-top: -50px;">\n' +
        '                            <h style=" font-family: \'Open Sans\', sans-serif;font-size: 18px;color: #000000;">Search Category</h>\n' +
        '                            <input oninput="search()" class="" style="background-color: #FFFFFF" role="button"\n' +
        '                                   name="search_input">\n' +
        '                        </ul>\n' +
        '                        <div class="form-input"  style="margin-left: -5px;margin-top: 50px">\n' +
        '                            <ul id="response">\n' +
        '\n' +
        '                            </ul>\n' +
        '                        </div>\n' +
        '\n' +
        '                        <div class="btn-group" id="category" style="margin-left: -50px">\n' +
        '\n' +
        '                            <button type="submit" style="padding: 10px 24px;" class="btn btn-block text-uppercase">Change category</button>\n' +
        '\n' +
        '                            <a type="submit" href="/diagram"  style="padding: 10px 24px;" class="btn btn-block text-uppercase">Drop change</a>\n' +
        '\n' +
        '                            <a type="submit" onclick="remove()" style="padding: 10px 24px;" class="btn btn-block text-uppercase">Remove category</a>\n' +
        '\n' +
        '                        </div>')
}