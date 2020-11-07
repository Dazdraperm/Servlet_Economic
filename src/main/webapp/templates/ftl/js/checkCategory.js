function checkCategory () {

    var name_category = document.getElementsByClassName("name_category")[0].value;
    var count_category = document.getElementsByClassName("count_category")[0].value;

    let name_result = name_category.match(/([A-Za-z0-9_]{1,25})/);
    let count_result = count_category.match(/([0-9_]{1,9})/);


    if(name_result === null || count_result === null){
        document.getElementById('re').setAttribute("disabled", true);

    }
    else {
        document.getElementById('re').removeAttribute("disabled");
    }

    if(name_result === null && count_result === null){
        $("#check_name_category").html("NAME:<br>1-25 Symbol;<br> Only English upper and lower case symbol;<br><br> COUNT:<br> 1-9 symbol only integer");
    }

    else if (name_result === null){
        $("#check_name_category").html("NAME:<br>1-25 Symbol;<br> Only English upper and lower case symbol");
    }

    else if (count_result === null){
        $("#check_name_category").html('COUNT:<br> 1-9 symbol only integer');
    }

    else {
        $("#check_name_category").html("");
    }
}
