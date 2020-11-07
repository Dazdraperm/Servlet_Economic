function search(){
    var servResponse = document.querySelector('#response');

    var userInput = document.forms.search_form.search_input.value;
    userInput = encodeURIComponent(userInput);
    var xhr = new XMLHttpRequest();
    xhr.open('POST', '/search');
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

    xhr.send('inputUser=' + userInput);


    xhr.onreadystatechange = function(){
        let a = document.getElementsByClassName("search_li");
        for (let j = 0; j < a.length; j++) {
            let description = a[j];
            description.remove();
        }
        if (xhr.readyState === 4 && xhr.status === 200) {
            let response = xhr.responseText;
            let splitresponse = response.split(" ");
            if (splitresponse[0].length > 0) {
                servResponse.insertAdjacentHTML("afterbegin", '<li class="search_li" style="display: inline-flex"><input id="remove_input" type="login" name=' + splitresponse[0] + ' value=' + splitresponse[0] + ' placeholder="name" tabindex="10" required><input type="login" name=' + splitresponse[0] + ' value=' + splitresponse[1] + ' placeholder="name" tabindex="10" required><input  hidden name="name" value=' + splitresponse[0] + '></li>');

            }
            else{
                servResponse.insertAdjacentHTML("beforeend", ' <h class="search_li" style="margin-left: 35px; font-family: \'Open Sans\', sans-serif;font-size: 12px;color: #000000;">No Results</h>');
            }
        }

    };
};