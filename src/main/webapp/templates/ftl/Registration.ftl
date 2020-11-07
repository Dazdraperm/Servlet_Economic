<#include "Base.ftl">

<#macro head>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@700&family=Raleway:ital,wght@0,400;0,600;1,700&display=swap"
          rel="stylesheet">
    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet"
          id="bootstrap-css">
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
    <link rel="stylesheet" href="templates/ftl/css/style.css">
</#macro>

<#macro content>

                <div class="container">
                    <div class="row px-3">
                        <div class="col-lg-5 col-xl-5 card flex-row mx-auto px-0">
                            <div class="card-body">
                                <h4 class="title text-center mt-4">Login to your account</h4>

                                <form class="form-box px-3" METHOD="post" action="/registration">
                                    <div class="form-input">
                                        <span><i class="fa fa-user-circle"></i></span>
                                        <input type="name" name="FIRST_NAME" placeholder="Name" tabindex="10" required>
                                    </div>

                                    <div class="form-input">
                                        <span><i class="fa fa-user-circle-o"></i></span>
                                        <input type="surname" name="LAST_NAME" placeholder="Surname" tabindex="10" required>
                                    </div>

                                    <div class="form-input">
                                        <span><i class="fa fa-envelope-o"></i></span>
                                        <input type="email" name="EMAIL" placeholder="Email" tabindex="10" required>
                                    </div>

                                    <div class="form-input">
                                        <span><i class="fa fa-sign-in"></i></span>
                                        <input type="login" name="login" placeholder="Login" tabindex="10" required>
                                    </div>

                                    <div class="form-input">
                                        <span><i class="fa fa-key"></i></span>
                                        <input type="password" name="password" placeholder="Password" required>
                                    </div>

                                    <div class="form-input">
                                        <span><i class="fa fa-key"></i></span>
                                        <input type="password" name="rPassword" placeholder="Repeat the Password" required>
                                    </div>

                                    <div class="mb-3">
                                        <div class="custom-control custom-checkbox">
                                            <input type="checkbox" class="custom-control-input" id="cb1" name="">
                                            <label class="custom-control-label" for="cb1">Remember me</label>
                                        </div>
                                    </div>

                                    <div class="mb-3">
                                        <button type="submit" class="btn btn-block text-uppercase">Register</button>
                                    </div>

                                    <hr class="my-4">

                                </form>
                            </div>
                        </div>
                    </div>
                </div>

</#macro>