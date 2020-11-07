<#include "Base.ftl">

<#macro head>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@700&family=Raleway:ital,wght@0,400;0,600;1,700&display=swap"
          rel="stylesheet">
<#--    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet"-->
<#--          id="bootstrap-css">-->
<#--    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>-->
    <link rel="stylesheet" href="templates/ftl/css/personalac.css">

</#macro>

<#macro content>
    <div class="container">
        <div class="row profile">
            <div class="col-md-3">
                <div class="profile-sidebar">
                    <div class="profile-userpic">
                        <img src="https://static.change.org/profile-img/default-user-profile.svg"
                             class="img-responsive"
                             alt="">
                    </div>

                    <!-- <div class="profile-userbuttons">
                        <button type="button" class="btn btn-primary btn-sm">Message</button>
                    </div> -->

                    <div class="profile-usermenu">
                        <ul class="nav">
                            <li class="active">
                                <a href="/profile">
                                    <i class=""></i>
                                    Information</a>
                            </li>
                            <li>
                                <a href="#">
                                    <i class=""></i>
                                    Friend </a>
                            </li>
                            <#if listUser??>

                                <#list listUser as user >
                                    <li>
                                        <a href='/chat?User=${user.getLogin()}' target="">
                                            <i class=""></i>
                                            Chat </a>
                                    </li>
                                </#list >


                            </#if>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="col-md-9">
                <div class="profile-content">
                    <#if listUser??>

                        <#list listUser as user >
                            <h1>${user.getLogin()}</h1>
                            <h2>Name</h2>
                            <input type="text" oninput="checkNameLastNameLogin()" class="name_user" name="name_user"
                                   value=${user.getFIRST_NAME()}>
                            <h2>Surname</h2>
                            <input type="text" oninput="checkNameLastNameLogin()" class="last_name" name="last_name"
                                   value=${user.getLAST_NAME()}>
                            <h2>Email</h2>
                            <input type="text" oninput="checkNameLastNameLogin()" class="email" name="email"
                                   value=${user.getEMAIL()}>
                            <h2>Login</h2>
                            <input type="text" oninput="checkNameLastNameLogin()" class="login" name="login"
                                   value=${user.getLogin()}>
                            <div id="check_login_name_lastName"></div>
                        </#list >


                    </#if>

                </div>

            </div>
            <#if listCategory??>
                <#list listCategory as category >


                    <input type="login" hidden oninput="inputChange(name, value)" class="disable_field_name"
                           name=${category.getCategory()} value=${category.getCategory()} placeholder="name"
                           tabindex="10" required>
                    <input type="login" hidden oninput="inputChangeCount(value, id)" class="disable_field_count"
                           name=${category.getCategory()} value=${category.getCountCategory()}
                           placeholder="count" tabindex="10" required id=${category.getCountCategory()}>
                </#list >
            </#if>
            <div id="piechart_3d" style="margin-top: -300px; margin-left: 575px; width: 450px; height: 350px;"></div>
        </div>

    </div>




</#macro>