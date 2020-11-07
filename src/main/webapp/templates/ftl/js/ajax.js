document.forms.my_form.oninput = function(e) {
    var servResponse = document.querySelector('#resp');
    e.preventDefault();

    var userInput = document.forms.my_form.my_input.value;
    userInput = encodeURIComponent(userInput);
    var xhr = new XMLHttpRequest();
    xhr.open('POST', '/ajax');
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

    xhr.send('inputUser=' + userInput);


    xhr.onreadystatechange = function(){
        let a = document.getElementsByClassName("abc");
        for (let j = 0; j < a.length; j++) {
            let description = a[j];
            description.remove();
        }
        if (xhr.readyState === 4 && xhr.status === 200) {

            let response = xhr.responseText;
            let splitresponse = response.split(" ");
            if (splitresponse[0].length > 0) {
                for (let i = 0; i < splitresponse.length; i++) {
                    servResponse.insertAdjacentHTML("beforeend", '<li class="abc"><a type="button" class="nav__link btn btn-info" style="width: 175px;" href="/profile?login=' + splitresponse[i] + ' ">' + splitresponse[i] + '</a></li>');
                }
            }
            else{
                servResponse.insertAdjacentHTML("beforeend", ' <h class="abc" style="margin-left: 35px; font-family: \'Open Sans\', sans-serif;font-size: 12px;color: #000000;">No Results</h>');
            }
        }

    };


};

