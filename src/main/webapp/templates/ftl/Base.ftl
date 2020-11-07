<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta charset="UTF-8">

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet"
          id="bootstrap-css">
    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>

    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@700&family=Raleway:ital,wght@0,400;0,600;1,700&display=swap"
          rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="templates/ftl/css/mainstyle.css">
    <@head></@head>


    <title>Moneysave</title>
    <style>
        p {
            text-indent: 4.5em;
            text-align: justify;
        }

        ul {
            display: inline-block;
        }
    </style>

    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript" src="templates/ftl/js/diagramDraw.js"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript" src="templates/ftl/js/disableField.js"></script>
    <script type="text/javascript" src="templates/ftl/js/checkCategory.js"></script>
    <script type="text/javascript" src="templates/ftl/js/checkNameLastNameLogin.js"></script>


</head>
<body>
<header class="header">
    <div class="container">
        <div class="header__inner">
            <div class="header__logo">
                <a href="/"><img src="templates/img/logolo.png" alt=""></a>
            </div>
            <#if name??>

                <form name="my_form">
                    <h style=" font-family: 'Open Sans', sans-serif;font-size: 18px;color: #000000;">Search user</h>
                    <input class="" style="background-color: #FFFFFF" role="button"
                           name="my_input" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true"
                           aria-expanded="false">
                </form>
                <ul id="resp" style="margin-left: 64px"><a></a></ul>
                <script src="templates/ftl/js/ajax.js"></script>


            <div class="dropdown dropright">
                <a class="btn btn-outline-info btn-lg dropdown-toggle " style="background-color: #fbe9df" href="#"
                   role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true"
                   aria-expanded="false">
                    Menu
                </a>

                <div class="dropdown-menu dropdown-menu-width " style="background-color: #fbe9df"
                     aria-labelledby="dropdownMenuLink">

                        <a></a>
                        <a class="nav__link btn btn-info" style="width: 100px;"
                           href="/profile?login=${login}">${login}</a>
                        <br>
                        <a class="nav__link btn btn-info" style="width: 100px;" href="/diagram">Diagram</a>
                        <br>
                        <a class="nav__link btn btn-info" style="width: 100px;" href="/resourceCenter">Resource</a>
                        <br>
                        <a class="nav__link btn btn-info" style="width: 100px;" href="/chatMain">Chat</a>
                        <br>

                        <form style="margin-left: 35px" action="logout" method="post">
                            <input type="submit" class="nav__link btn btn-info" value="Logout" style="width: 100px;">
                        </form>

                    <#else>
                    <div class="dropdown dropright">
                        <a class="btn btn-outline-info btn-lg dropdown-toggle " style="background-color: #fbe9df" href="#"
                           role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true"
                           aria-expanded="false">
                            Menu
                        </a>

                        <div class="dropdown-menu dropdown-menu-width " style="background-color: #fbe9df"
                             aria-labelledby="dropdownMenuLink">
                        <a class="nav__link btn btn-info" style="margin-left: 10px; width: 145px;" href="/registration">Create
                            an account </a>
                        <a class="nav__link btn btn-info" style="width: 100px;" href="/login">Sign in</a>
                        </div>
                    </div>
                    </#if>

                </div>
            </div>


        </div>
    </div>
</header>


<@content></@content>


</body>
</html>