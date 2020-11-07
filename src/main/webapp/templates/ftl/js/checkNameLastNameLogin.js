function checkNameLastNameLogin() {

    var name_user = document.getElementsByClassName("name_user")[0].value;
    var last_name = document.getElementsByClassName("last_name")[0].value;
    var login = document.getElementsByClassName("login")[0].value;
    var email = document.getElementsByClassName("email")[0].value;

    let name_result = name_user.match(/([A-Za-z0-9_]{1,25})/);
    let last_name_result = last_name.match(/([A-Za-z0-9_]{1,25})/);
    let login_result = login.match(/([A-Za-z0-9_]{1,25})/);

    if(name_result === null || last_name_result === null || login_result === null || !(email.length >= 1 && email.length <= 30)){
        document.getElementById('change').setAttribute("disabled", true);
        $("#check_login_name_lastName").html("Login or Name or Lastname:<br>1-25 Symbol(Email 30);<br> Only English upper and lower case symbol;");
    }
    else {
        $("#check_login_name_lastName").text("");
        document.getElementById('change').removeAttribute("disabled");
    }
}
